package org.sample;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import org.sample.service.jaxrs.impl.JaxRsExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleServiceIntegration extends JerseyTest {

    private static final Logger logger = LoggerFactory.getLogger( ExampleServiceIntegration.class );

    private static String RESOURCE_PATH = "/example";
    private static final String IS_RUNNING = "/isrunning";

    @Override
    protected Application configure() {
        // find first available port. Allows for multiple test containers in parallel.
        forceSet( TestProperties.CONTAINER_PORT, "0" );
        // Class under test
        return new ResourceConfig( JaxRsExampleService.class );
    }

    @Test
    public void validateURLWorks() throws Exception {
        String path = RESOURCE_PATH + IS_RUNNING;

        String hello = target( path ).request().get( String.class );
        assertEquals( "Winner Winner Chicken Dinner", hello );
    }

}