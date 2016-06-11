package org.sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger( Application.class );

    public static void main( String[] args ) {
        ApplicationContext ctx = SpringApplication.run( Application.class, args );

        System.out.println( "Application has started" );
        LOGGER.info( "Application has started" );

    }

}
