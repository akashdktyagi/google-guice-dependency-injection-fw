package com.yantraQA.stepdefs;

import com.google.inject.Inject;
import com.yantraQA.pageObjects.LoginPageObjects;
import com.yantraQA.toBeInjected.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefsLoginPage {

    @Inject
    TestContext testContext;

    @Inject
    LoginPageObjects loginPageObjects;

    @Given("I am on the landing page of the app")
    public void i_am_on_landing_page() {
        Assert.assertEquals("No on the landing page",testContext.getDriver().getTitle(),"ParaBank | Welcome | Online Banking");
    }

    @Then("I am able to login in the app")
    public void i_am_able_to_login_in_the_app() {
        loginPageObjects.validateLoginIsSuccess();
        System.out.println(testContext.getConfig().getTimeOut());
    }

    @When("I enter username and password")
    public void i_enter_username_and_password() {
        loginPageObjects.enterUserNameAndPasswordAndClickSubmit("john","demo");
    }

}
