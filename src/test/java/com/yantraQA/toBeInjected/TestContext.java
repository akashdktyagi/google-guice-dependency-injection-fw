package com.yantraQA.toBeInjected;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@ScenarioScoped
public class TestContext {

    @Setter @Getter
    WebDriver driver;

    @Setter @Getter
    Scenario scenario;

    @Inject
    @Getter @Setter Config config;

    public void invokeDriver(){
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}
