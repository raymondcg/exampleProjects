package org.sample.bdd.profiles;

import java.io.IOException;

import org.junit.runners.model.InitializationError;

import cucumber.api.junit.Cucumber;

/*
 * Profile is to test multi-threading cases. pick a small case of property settings that will cause the application to be multi-threaded.
 */
public class CucumberTestProfileLargeGridSize extends Cucumber {

    // Any properties in here override application properties
    static {
        System.setProperty( "env", "unit" );
        // Add any multi-threading properties
    }

    public CucumberTestProfileLargeGridSize( Class<?> clazz ) throws IOException, InitializationError {
        super( clazz );
    }

}
