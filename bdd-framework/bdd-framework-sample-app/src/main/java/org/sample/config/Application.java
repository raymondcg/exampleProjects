package org.sample.config;

import org.sample.domain.api.UserDao;
import org.sample.domain.dao.UserDaoImpl;
import org.sample.domain.service.HelloWorldServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "org.sample" })
public class Application {

    @Bean
    public HelloWorldServiceImpl helloWorldService() {
        return new HelloWorldServiceImpl();
    }

    @Bean
    public UserDao helloWorldDao() {
        return new UserDaoImpl();
    }

    // TODO add transaction manager

}
