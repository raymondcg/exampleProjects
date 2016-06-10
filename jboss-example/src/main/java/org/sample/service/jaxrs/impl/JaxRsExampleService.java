package org.sample.service.jaxrs.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.sample.service.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// this calls implements client search service API methods.
@Path("/example")
public class JaxRsExampleService implements ExampleService {

    private static final Logger logger = LoggerFactory.getLogger( JaxRsExampleService.class );

    @GET
    @Path("/isrunning")
    public Response isRunning() {
        logger.info( "JaxRsExampleService.isRunning()" );
        Response returnedResponse = Response.status( Response.Status.OK ).entity( "Winner Winner Chicken Dinner" )
                .build();
        return returnedResponse;
    }

}