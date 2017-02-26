package org.sample.config;

import org.sample.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger( Application.class );

    public static void main( String[] args ) {
        ApplicationContext ctx = SpringApplication.run( Application.class, args );
        logger.info( "Application has started." );
    }

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldService();
    }

}
