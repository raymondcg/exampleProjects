package org.drools.runner.core.common.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;

public class DebugAgendaEventListener implements AgendaEventListener {
	private static final Logger LOGGER = LogManager.getLogger(DebugAgendaEventListener.class);

	@Override
	public void matchCancelled(MatchCancelledEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void matchCreated(MatchCreatedEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
		LOGGER.trace(event);
	}

}