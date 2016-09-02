package org.drools.runner.core.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Used to monitor how much time it takes for each rule flow group to execute.
 */
public class TimerAgendaEventListener implements AgendaEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger( TimerAgendaEventListener.class );

    private Map<String, StopWatch> map = new HashMap<String, StopWatch>();
    private long sum = 0;

    @Override
    public void afterMatchFired( AfterMatchFiredEvent event ) {
        // No-op
    }

    @Override
    public void afterRuleFlowGroupActivated( RuleFlowGroupActivatedEvent event ) {
        LOGGER.debug( event.getRuleFlowGroup().getName() + " : Started" );

        StopWatch watch = new StopWatch();
        watch.start();
        if ( !map.containsKey( event.getRuleFlowGroup().getName() ) ) {
            map.put( event.getRuleFlowGroup().getName(), watch );
        }

    }

    @Override
    public void afterRuleFlowGroupDeactivated( RuleFlowGroupDeactivatedEvent event ) {
        StopWatch watch = map.get( event.getRuleFlowGroup().getName() );
        LOGGER.debug( "{} : Stopped : Took {} ms to run.", event.getRuleFlowGroup().getName(), watch.getTime() );
    }

    @Override
    public void agendaGroupPopped( AgendaGroupPoppedEvent event ) {
        // No-op
    }

    @Override
    public void agendaGroupPushed( AgendaGroupPushedEvent event ) {
        // No-op
    }

    @Override
    public void beforeMatchFired( BeforeMatchFiredEvent event ) {
        // No-op
    }

    @Override
    public void beforeRuleFlowGroupActivated( RuleFlowGroupActivatedEvent event ) {
        // No-op
    }

    @Override
    public void beforeRuleFlowGroupDeactivated( RuleFlowGroupDeactivatedEvent event ) {
        // No-op

    }

    @Override
    public void matchCancelled( MatchCancelledEvent event ) {
        // No-op
    }

    @Override
    public void matchCreated( MatchCreatedEvent event ) {
        // No-op
    }

}
