package org.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Replaces spring-core-config.xml
 *
 */
@Configuration
@ComponentScan({ "org.sample.service" })
public class SpringRootConfig {

}
