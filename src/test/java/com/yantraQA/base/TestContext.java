package com.yantraQA.base;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@ScenarioScoped
public class TestContext {

    //Browser Specific Control
    @Setter @Getter WebDriver driver;

    //Common Variables
    @Setter @Getter Scenario scenario;
    @Inject @Getter @Setter Config config;

    public void invokeDriver(){
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}
