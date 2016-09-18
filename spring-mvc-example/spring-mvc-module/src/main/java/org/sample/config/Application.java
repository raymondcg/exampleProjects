package org.sample.config;

import org.sample.domain.service.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldService();
    }

}
