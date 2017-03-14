package org.drools.runner.core.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.drools.runner.core.api.KieContainerBuilder;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.Results;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class FileSystemKieContainerBuilder implements KieContainerBuilder {

	private static final Logger logger = LogManager.getLogger(FileSystemKieContainerBuilder.class);

	private KieContainer kieContainer;

	public FileSystemKieContainerBuilder() {
		kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		try {
			StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession();
			logger.debug(statelessKieSession.getKieBase().toString());
		} catch (Exception e) {
			logger.warn(
					"There are no KieModules on the classpath. Upgrade the KieContainer to a valid Kiemodule to fire rules");
		}
		/**
		 * Break point here to find what rules are in the KIE Base
		 * 
		 */
		@SuppressWarnings("unused")
		KieCommands commandFactory = KieServices.Factory.get().getCommands();
	}

	@Override
	public boolean createOrUpgradeRulesWithVersion(String group, String artifact, String version) {
		ReleaseId releaseId = KieServices.Factory.get().newReleaseId(group, artifact, version);
		Results results = null;
		try {
			results = kieContainer.updateToVersion(releaseId);

		} catch (UnsupportedOperationException e) {
			logger.info("Upgrading to version" + releaseId.toString());
			try {
				kieContainer = KieServices.Factory.get().newKieContainer(releaseId);
				results = kieContainer.updateToVersion(releaseId);

			} catch (Exception e2) {
				return false;
			}
		}

		return results.getMessages().size() == 0;
	}

	@Override
	public KieContainer getKieContainer() {
		return kieContainer;
	}

	@Override
	public String getCurrentVersion() {
		ReleaseId version = this.kieContainer.getReleaseId();
		if (version == null) {
			return "local container is empty";
		}
		return version.toString();
	}

}
