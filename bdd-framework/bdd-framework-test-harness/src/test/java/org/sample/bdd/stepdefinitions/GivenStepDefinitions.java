package org.sample.bdd.stepdefinitions;

import java.util.List;

import org.sample.domain.model.User;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

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

    @Then("^the system will have the following users:$")
    public void the_system_will_have_the_following_users( DataTable arg1 ) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }
}
