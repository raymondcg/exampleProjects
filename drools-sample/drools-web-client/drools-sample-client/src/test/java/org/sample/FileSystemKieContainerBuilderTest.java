package org.sample;

import org.drools.runner.core.api.KieContainerBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.builder.Message.Level;
import org.kie.api.runtime.KieContainer;
import org.sample.context.LocalContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LocalContext.class)
@ActiveProfiles("local-test")
public class FileSystemKieContainerBuilderTest {

    private static final Logger logger = LoggerFactory.getLogger( FileSystemKieContainerBuilderTest.class );

    private KieContainerBuilder kieContainerBuilder;

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
        for ( String baseName : kieContainer.getKieBaseNames() ) {
            Assert.assertNotNull( kieContainer.getKieBase( baseName ) );
        }
        // TODO For each component update to the base to be validated.
        Assert.assertNotNull( kieContainer.newKieSession( "exampleStatelessSession" ) );
        Assert.assertFalse( kieContainer.verify().hasMessages( Level.ERROR, Level.WARNING ) );
    }

}
