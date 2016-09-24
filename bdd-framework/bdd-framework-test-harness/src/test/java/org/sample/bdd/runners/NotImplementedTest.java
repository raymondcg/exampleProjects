package org.sample.bdd.runners;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.sample.bdd.profiles.CucumberTestProfile;

import cucumber.api.CucumberOptions;

/*
 * This is the connection class to JUint, configuration type stuff goes in here. This is used to run all tests that have a not_implmented tag, its a way to make sure that tests aren't just getting written but not implemented or ignored. It should be run by hand every once in awhile, hence the ignore.
 */
// TODO make json and html configurable from properties file, so a single runner Can be used.
@Ignore
@RunWith(CucumberTestProfile.class)
@CucumberOptions(plugin = { "json:target/notImplementedTest.json", "html:target/cucumber/notImplementedTest" }, tags = {
        "@not_implemented", "@Ignore" }, glue = { "org.sample.bdd.stepdefinitions",
                "cucumber.api.spring" }, features = { "src/test/resources/features" }, strict = true, monochrome = true)
public class NotImplementedTest {

}
