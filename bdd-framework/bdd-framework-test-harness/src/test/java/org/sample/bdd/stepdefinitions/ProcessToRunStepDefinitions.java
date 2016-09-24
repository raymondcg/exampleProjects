package org.sample.bdd.stepdefinitions;

import cucumber.api.java.en.When;

/**
 * Steps should trigger Macro level Application processes. Preference is to use application's API to trigger process in
 * the same manner that it will be triggered in Production. There should be a very limited set of 'processes' and the
 * associated 'when' should be re-used for that process. If there needs to be a tweak to that process then it's likely a
 * different 'given' that needs to be set.
 */
public class ProcessToRunStepDefinitions extends BaseStep {

    @When("^the users are saved to the system$")
    public void the_users_are_saved_to_the_system() throws Throwable {
        // TODO trigger process
    }

}
