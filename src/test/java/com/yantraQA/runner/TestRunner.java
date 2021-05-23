package com.yantraQA.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"com.yantraQA.stepdefs"},
        plugin = {"pretty","html:target/cucumber-reports.html"},
        tags = "@new_account",
        dryRun = false

)
public class TestRunner {
}
