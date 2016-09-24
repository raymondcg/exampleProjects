package org.sample.bdd.runners;

import org.junit.runner.RunWith;
import org.sample.bdd.profiles.CucumberTestProfile;

import cucumber.api.CucumberOptions;

// TODO make json and html configurable from properties file, so a single runner Can be used.
@RunWith(CucumberTestProfile.class)
@CucumberOptions(plugin = { "json:target/wipCucumber.json", "html:target/cucumber/wipCucumber" }, tags = {
        "@wip" }, glue = { "org.sample.bdd.stepdefinitions",
                "cucumber.api.spring" }, features = { "src/test/resources/features" }, strict = true, monochrome = true)
public class WorkInProgress {

}
