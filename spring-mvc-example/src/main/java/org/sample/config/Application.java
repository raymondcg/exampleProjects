package org.sample.config;

import org.sample.controller.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sample")
public class Application extends WebMvcConfigurerAdapter {

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldService();
    }

}
