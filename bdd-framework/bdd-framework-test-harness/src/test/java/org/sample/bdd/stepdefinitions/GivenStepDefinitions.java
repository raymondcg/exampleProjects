package org.sample.bdd.stepdefinitions;

import java.util.List;

import org.sample.domain.model.User;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

/**
 * Steps should setup data in an in memory database or prepare the data to be sent to message brokers/services. There
 * should be a limited set of 'Given' step definitions and they should be re-used across tests.
 */
public class GivenStepDefinitions extends BaseStep {

    @Given("^the following users:$")
    public void the_following_users( DataTable examplesTable ) throws Throwable {
        // Converts the data table to a list of users. Note that Field names and column names have to line, but Cucumber
        // will Camel case and remove spaces.
        List<User> users = examplesTable.asList( User.class );
        userDao.save( users );
    }

}
