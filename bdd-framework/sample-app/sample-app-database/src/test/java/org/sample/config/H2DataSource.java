package org.sample.config;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
// @PropertySources({ @PropertySource("classpath:$application.properties") })
@Profile("h2")
public class H2DataSource {

    @Value("${database.url}")
    private String databaseUrl;

    @Value("${database.user}")
    private String databaseUser;

    @Value("${database.password}")
    private String databasePassword;

    // jdbc:h2:mem:testdb
    @Bean
    @Scope("prototype")
    public DataSource dataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setType( EmbeddedDatabaseType.H2 );
        builder.continueOnError( true );
        builder.addScripts( "db/sql/create-db.sql" );
        EmbeddedDatabase db = builder.build();
        return db;

    }

    // Pop up a DB manager to inspect database
    @PostConstruct
    public void startDBManager() {

        // h2
        DatabaseManagerSwing.main( new String[] { "--url", databaseUrl, "--user", databaseUser, "--password",
                databasePassword } );
    }

    // Start WebServer, access http://localhost:8082
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server startDBWebServerManager() throws SQLException {
        return Server.createWebServer();
    }

    // // To resolve ${} in @Value
    // @Bean
    // public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    // return new PropertySourcesPlaceholderConfigurer();
    // }
}
