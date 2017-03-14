package org.drools.runner.core.common.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;

public class DebugRuleRuntimeEventListener implements RuleRuntimeEventListener {
	private static final Logger LOGGER = LogManager.getLogger(DebugRuleRuntimeEventListener.class);

	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void objectDeleted(ObjectDeletedEvent event) {
		LOGGER.trace(event);
	}

	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {
		LOGGER.trace(event);
	}

}