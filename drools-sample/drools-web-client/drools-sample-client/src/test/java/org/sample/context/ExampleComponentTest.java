package org.sample.context;

import org.drools.runner.core.api.KieContainerBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.builder.Message.Level;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LocalContext.class)
@ActiveProfiles("local-test")
public class ExampleComponentTest {

    private static final Logger logger = LoggerFactory.getLogger( ExampleComponentTest.class );

    private KieContainerBuilder kieContainerBuilder;

    /**
     * This test method should compile all rules and catch any rules compilation errors. Fast.
     */
    @Test
    public void shouldCreateKnowledgeBaseFromClasspathBuilder() {
        Assert.assertNotNull( kieContainerBuilder );
        Assert.assertNotNull( kieContainerBuilder.getKieContainer() );
        KieContainer kieContainer = kieContainerBuilder.getKieContainer();

        logger.info( "KieBases: " + kieContainer.getKieBaseNames() );
        Assert.assertNotNull( kieContainer.getKieBase( "kbase1" ) );
        Assert.assertNotNull( kieContainer.newKieSession( "exampleStatelessSession" ) );
        Assert.assertFalse( kieContainer.verify().hasMessages( Level.ERROR, Level.WARNING ) );

    }
}
