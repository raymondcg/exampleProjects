package org.sample;

import org.drools.runner.core.api.RulesRunner;
import org.drools.runner.core.common.response.ExampleResponse;
import org.drools.runner.core.request.GenericRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.context.LocalContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Since the rules runner and Stateless BRMS code is generic, it is reusable. Beyond defining the dependency injection
 * to wire everything together, the only thing a developer has to implement is the response object, the domain model,
 * and the rules.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LocalContext.class)
@ActiveProfiles("local-test")
public class StatelessRulesRunnerTest {

    private static final Logger logger = LoggerFactory.getLogger( StatelessRulesRunnerTest.class );

    private RulesRunner rulesRunner;

    @Test
    public void shouldAutowireRulesRunner() {
        Assert.assertNotNull( rulesRunner );
    }

    /**
     * Tests to ensure that the stateless drools context is step and building correctly. Great for detecting rules
     * errors early.
     * 
     */
    @Test
    public void shouldRunRulesWithOutException() {
        // Data In - Setup Data
        // Add Facts
        GenericRequest request = new GenericRequest();
        request.addFact( "New Fact 1" );
        request.addFact( "New Fact 2" );

        // Run Rules
        ExampleResponse response = rulesRunner.execute( request, "example.process", ExampleResponse.class,
                Deployment.KSESSION );
        logger.info( response.toString() );

        // Data Out - TODO Validate results
        Assert.assertNotNull( response );
    }

}