package org.sample;

import org.drools.runner.core.api.KieContainerBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.sample.context.WebClientContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FileSystemKieContainerBuilderTest {

    private static final Logger logger = LoggerFactory.getLogger( FileSystemKieContainerBuilderTest.class );

    private KieContainerBuilder kieContainerBuilder;

    @Before
    public void setup() {
        // TODO what is the best way to do this as a part of Spring-test?
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register( WebClientContext.class );
        ctx.refresh();

        kieContainerBuilder = ctx.getBean( KieContainerBuilder.class );
    }

    @Test
    public void shouldAutowireKieContainerBuilder() {
        Assert.assertNotNull( kieContainerBuilder );
    }

    @Test
    public void shouldLoadRulesAndExecuteLocally() {
        boolean result = kieContainerBuilder.createOrUpgradeRulesWithVersion( Deployment.GROUP_ID,
                Deployment.ARTIFACT_ID, Deployment.VERSION );
        KieContainer kieContainer = kieContainerBuilder.getKieContainer();
        Assert.assertNotNull( result );
        Assert.assertNotNull( kieContainer );

        logger.info( "KieBases: " + kieContainer.getKieBaseNames() );
        // TODO For each component update to the base to be validated.
        Assert.assertNotNull( kieContainer.getKieBase() );
        // TODO For each component update to the base to be validated.
        Assert.assertNotNull( kieContainer.newKieSession() );

        // TODO how to actually use to 'validate'
        kieContainer.verify();
    }

}
