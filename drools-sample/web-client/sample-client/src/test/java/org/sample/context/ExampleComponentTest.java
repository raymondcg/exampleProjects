package org.sample.context;

import org.drools.runner.core.api.KieContainerBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleComponentTest {

    private static final Logger logger = LoggerFactory.getLogger( ExampleComponentTest.class );

    private KieContainerBuilder kieContainerBuilder;

    @Before
    public void setup() {
        // TODO what is the best way to do this as a part of Spring-test?
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register( WebClientContext.class );
        ctx.refresh();

        kieContainerBuilder = ctx.getBean( KieContainerBuilder.class );
    }

    /**
     * This test method should compile all rules and catch any rules compilation errors. Fast.
     */
    @Test
    public void shouldCreateKnowledgeBaseFromClasspathBuilder() {
        Assert.assertNotNull( kieContainerBuilder );
        Assert.assertNotNull( kieContainerBuilder.getKieContainer() );
        KieContainer kieContainer = kieContainerBuilder.getKieContainer();

        logger.info( "KieBases: " + kieContainer.getKieBaseNames() );
        // TODO For each component update to the base to be validated.
        Assert.assertNotNull( kieContainer.getKieBase() );
        // TODO For each component update to the base to be validated.
        Assert.assertNotNull( kieContainer.newKieSession() );

        // TODO find a better way to use this method.
        kieContainer.verify();

    }
}
