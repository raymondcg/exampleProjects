package org.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 * Replaces Spring-web-config.xml
 */
@EnableWebMvc // <mvc:annotation-driven />
@Configuration
@ComponentScan({ "org.sample.controller" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

}
