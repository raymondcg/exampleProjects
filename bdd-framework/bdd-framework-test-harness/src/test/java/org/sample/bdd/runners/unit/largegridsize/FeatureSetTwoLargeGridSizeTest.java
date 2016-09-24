package org.sample.bdd.runners.unit.largegridsize;

import org.junit.runner.RunWith;
import org.sample.bdd.profiles.CucumberTestProfileLargeGridSize;

import cucumber.api.CucumberOptions;

/*
 * This is the connection class to JUnit, configuration  type stuff goes in here. This is used to run all tests tagged to FeatureSetTwo that don't have a non_implemented or ignore tag.
 */
// TODO make json and html configurable from properties file, so a single runner Can be used.
@RunWith(CucumberTestProfileLargeGridSize.class)
@CucumberOptions(plugin = { "json:target/featureSetTwoLargeGridSizeTest.json",
        "html:target/cucumber/featureSetTwoLargeGridSizeTest" }, tags = { "@FeatureSetTwo", "~@Ignore",
                "~@not_implemented" }, glue = { "org.sample.bdd.stepDefinitions", "cucumber.api.spring" }, features = {
                        "src/test/resources/features" }, strict = true, monochrome = true)
public class FeatureSetTwoLargeGridSizeTest {

}
