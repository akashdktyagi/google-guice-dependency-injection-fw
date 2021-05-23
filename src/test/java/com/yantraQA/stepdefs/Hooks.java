package com.yantraQA.stepdefs;

import com.google.inject.Inject;
import com.yantraQA.toBeInjected.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.sl.In;

public class Hooks {
    @Inject
    TestContext testContext;

    @Before
    public void setUp(Scenario scenario){
        String url = testContext.getConfig().getUrl();
        testContext.invokeDriver();
        testContext.setScenario(scenario);
        testContext.getDriver().get(url);
    }
}