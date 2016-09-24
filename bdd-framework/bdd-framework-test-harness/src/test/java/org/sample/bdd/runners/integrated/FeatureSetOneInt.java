package org.sample.bdd.runners.integrated;

import org.junit.runner.RunWith;
import org.sample.bdd.profiles.CucumberIntProfile;

import cucumber.api.CucumberOptions;

/*
 * This is the connection class to JUnit, configuration  type stuff goes in here. This is used to run all tests tagged to FeatureSetOne that don't have a non_implemented or ignore tag.
 */
// TODO make json and html configurable from properties file, so a single runner Can be used.
@RunWith(CucumberIntProfile.class)
@CucumberOptions(plugin = { "json:target/featureSetOneInt.json", "html:target/cucumber/featureSetOneInt" }, tags = {
        "@FeatureSetOne", "~@Ignore", "~@not_implemented" }, glue = { "org.sample.bdd.stepdefinitions",
                "cucumber.api.spring" }, features = { "src/test/resources/features" }, strict = true, monochrome = true)
public class FeatureSetOneInt {

}
