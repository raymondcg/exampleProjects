package org.drools.runner.core;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.drools.runner.core.api.KieContainerBuilder;
import org.drools.runner.core.api.Request;
import org.drools.runner.core.api.RulesRunner;
import org.drools.runner.core.common.CommandUtils;
import org.drools.runner.core.common.ReflectiveExecutionResultsTransformer;
import org.drools.runner.core.common.listener.DebugAgendaEventListener;
import org.drools.runner.core.common.listener.DebugRuleRuntimeEventListener;
import org.drools.runner.core.common.listener.TimerAgendaEventListener;
import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

/**
 * This class is a generic runner using the Stateless BRMS project. It will run
 * a Stateless component, and return that component's object of response.
 *
 */
public class StatelessRulesRunner implements RulesRunner {

	private static final Logger LOGGER = LogManager.getLogger(StatelessRulesRunner.class);

	private KieContainerBuilder kieContainerBuilder;

	private KieContainer kieContainer;
	private boolean debugConsoleLogging;
	private String auditLogName;
	private KieRuntimeLogger auditLogger;

	public StatelessRulesRunner() {
		debugConsoleLogging = false;
	}

	@Override
	public <Response> Response execute(Request request, String processId, Class<Response> responseClazz,
			String lookup) {
		LOGGER.debug("PROCESS: Process a Drools request.");
		StopWatch timer = new StopWatch();
		timer.start();

		StatelessKieSession session;
		try {
			session = kieContainer.newStatelessKieSession(lookup);

		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage());
			return null;
		}

		BatchExecutionCommand batchExecutionCommand = CommandUtils.createBatchExecutionCommand(request, processId,
				responseClazz, lookup);

		// Test Debugging ONLY
		if (auditLogName != null) {
			auditLogger = KieServices.Factory.get().getLoggers().newFileLogger(session, auditLogName);
		}
		if (debugConsoleLogging) {
			session.addEventListener(new DebugRuleRuntimeEventListener());
			session.addEventListener(new DebugAgendaEventListener());
			session.addEventListener(new TimerAgendaEventListener());

		}
		// End Test Debugging ONLY

		ExecutionResults results = session.execute(batchExecutionCommand);

		Response response = ReflectiveExecutionResultsTransformer.transform(results, responseClazz);

		if (auditLogger != null) {
			auditLogger.close();
		}

		timer.stop();
		LOGGER.debug("TIME for PROCESS: " + timer.getTime());
		return response;
	}

	@Override
	public <Response> Response execute(Request request, String processId, String lookup) {
		return execute(request, processId, null, lookup);
	}

	public KieContainer getKieContainer() {
		return kieContainer;
	}

	public boolean isDebugConsoleLogging() {
		return debugConsoleLogging;
	}

	public void setDebugConsoleLogging(boolean debugConsoleLogging) {
		this.debugConsoleLogging = debugConsoleLogging;
	}

	public String getAuditLogName() {
		return auditLogName;
	}

	public void setAuditLogName(String auditLogName) {
		this.auditLogName = auditLogName;
	}

	public KieContainerBuilder getKieContainerBuilder() {
		return kieContainerBuilder;
	}

	public void setKieContainerBuilder(KieContainerBuilder kieContainerBuilder) {
		this.kieContainerBuilder = kieContainerBuilder;
		this.kieContainer = kieContainerBuilder.getKieContainer();
	}
}