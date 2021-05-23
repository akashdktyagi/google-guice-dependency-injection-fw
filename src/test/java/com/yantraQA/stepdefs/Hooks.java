package com.yantraQA.stepdefs;

import com.google.inject.Inject;
import com.yantraQA.base.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

    @AfterStep
    public void afterEachStepTakeScreenShot(){
        TakesScreenshot scrnShot = (TakesScreenshot)testContext.getDriver();
        byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
        testContext.getScenario().attach(data,"image/png",testContext.getScenario().getName());
    }

    @After
    public void cleanUp(){
        testContext.getDriver().quit();
    }
}
