package org.sample;

import static org.junit.Assert.fail;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.service.jaxrs.impl.JaxRsExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Arquillian.class)
public class SampleServiceIntegration {

    private static final Logger logger = LoggerFactory.getLogger( SampleServiceIntegration.class );

    /**
     * To Setup the container under test. Probably should be a parent method for reuse
     */
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create( JavaArchive.class ).addClass( JaxRsExampleService.class )
                .addAsManifestResource( EmptyAsset.INSTANCE, "context/applicationContext.xml" );
        logger.info( jar.toString( true ) );
        return jar;
    }

    @Test
    public void should_create_application() {
        fail( "Not Yet Implemented" );
    }
}