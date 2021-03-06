package org.sample.context;

import org.drools.runner.core.StatelessRulesRunner;
import org.drools.runner.core.api.RulesRunner;
import org.drools.runner.core.builder.FileSystemKieContainerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientContext {

    @Bean
    public RulesRunner rulesRunner() {
        StatelessRulesRunner rulesRunner = new StatelessRulesRunner();
        rulesRunner.setKieContainerBuilder( exampleKieContainerBuilder() );
        return rulesRunner;
    }

    @Bean
    public FileSystemKieContainerBuilder exampleKieContainerBuilder() {
        return new FileSystemKieContainerBuilder();
    }

}
