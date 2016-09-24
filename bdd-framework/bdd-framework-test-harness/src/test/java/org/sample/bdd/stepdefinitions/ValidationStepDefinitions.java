package org.sample.bdd.stepdefinitions;

import java.util.HashSet;
import java.util.Set;

import org.sample.domain.model.User;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

/**
 * Steps should read data from in memory database/message broker/service response then validate data results. There are
 * likely to be many validation steps validating all sorts of different things. Try to reuse steps whenever possible.
 */

public class ValidationStepDefinitions extends BaseStep {

    @Then("^the system will have the following users:$")
    public void the_system_will_have_the_following_users( DataTable exampleTable ) throws Throwable {
        Set<User> expectedUsers = new HashSet<>( exampleTable.asList( User.class ) );
        Set<User> actualUsers = new HashSet<>( userDao.findAll() );

        assertTrue( "Set equality failed, expected and actuals are not the same.",
                expectedUsers.equals( actualUsers ) );
    }

}
