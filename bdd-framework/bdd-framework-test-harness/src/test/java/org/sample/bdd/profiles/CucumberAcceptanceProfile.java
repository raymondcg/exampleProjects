package org.sample.bdd.profiles;

import java.io.IOException;

import org.junit.runners.model.InitializationError;

import cucumber.api.junit.Cucumber;

/*
 * Basic profile, all multi-threading properties should be set to single threaded base case, usually 1.
 */
public class CucumberAcceptanceProfile extends Cucumber {

    // Any properties in here override application properties
    static {
        System.setProperty( "env", "acceptance" );
        // Add any multi-threading properties
    }

    public CucumberAcceptanceProfile( Class<?> clazz ) throws IOException, InitializationError {
        super( clazz );
    }

}
