package com.yantraQA.pageObjects;

import com.google.inject.Inject;
import com.yantraQA.base.Interact;
import com.yantraQA.base.TestContext;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

public class BasePageObjects extends Interact {

    TestContext testContext;
    WebDriver driver;

    @Inject
    public BasePageObjects(TestContext testContext){
        this.testContext = testContext;
        driver = testContext.getDriver();
    }

}
