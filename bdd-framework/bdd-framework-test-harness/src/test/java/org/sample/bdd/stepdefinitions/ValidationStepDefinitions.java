package org.sample.bdd.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sample.domain.model.User;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

/**
 * Steps should read data from in memory database/message broker/service response then validate data results. There are
 * likely to be many validation steps validating all sorts of different things. Try to reuse steps whenever possible.
 */

public class ValidationStepDefinitions extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger( ValidationStepDefinitions.class );

    @Then("^the system will have the following users:$")
    public void the_system_will_have_the_following_users( DataTable exampleTable ) throws Throwable {
        Set<User> expectedUsers = new HashSet<>( exampleTable.asList( User.class ) );
        Set<User> actualUsers = new HashSet<>( userDao.findAll() );

        assertTrue( "Set equality failed, expected and actuals are not the same.",
                expectedUsers.equals( actualUsers ) );

        // Debug logs to show how to use the collectionToString method.
        LOGGER.debug( "Expected Users" );
        LOGGER.debug( collectionToString( expectedUsers ) );
        LOGGER.debug( "Actual Users" );
        LOGGER.debug( collectionToString( actualUsers ) );
    }

}
