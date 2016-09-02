package org.sample.context;

import org.drools.runner.core.StatelessRulesRunner;
import org.drools.runner.core.api.RulesRunner;
import org.drools.runner.core.builder.FileSystemKieContainerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local-test")
public class LocalContext {

    @Bean
    public RulesRunner rulesRunner() {
        StatelessRulesRunner rulesRunner = new StatelessRulesRunner();
        rulesRunner.setKieContainerBuilder( exampleKieContainerBuilder() );
        rulesRunner.setAuditLogName( "testAudit" );
        rulesRunner.setDebugConsoleLogging( true );
        return rulesRunner;
    }

    @Bean
    public FileSystemKieContainerBuilder exampleKieContainerBuilder() {
        return new FileSystemKieContainerBuilder();
    }

}
