package com.yantraQA.stepdefs;

import com.google.inject.Inject;
import com.yantraQA.pageObjects.CommonPageObjects;
import com.yantraQA.pageObjects.LoginPageObjects;
import com.yantraQA.pageObjects.OpenNewAccountPageObjects;
import com.yantraQA.toBeInjected.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefOpenNewAccount {

    @Inject
    TestContext testContext;

    @Inject
    LoginPageObjects loginPageObjects;

    @Inject
    CommonPageObjects commonPageObjects;

    @Inject
    OpenNewAccountPageObjects openNewAccountPageObjects;

    @Given("I am on the Open New Account Page")
    public void i_am_on_the_open_new_account_page() {
        String u = testContext.getConfig().getUserName();
        String p = testContext.getConfig().getPassword();
        loginPageObjects.enterUserNameAndPasswordAndClickSubmit(u,p);
        loginPageObjects.validateLoginIsSuccess();

        //navigate to the account page
        commonPageObjects.clickOpenNewAccount();
    }

    @When("I select account type as {string} and select base account number as {string}")
    public void i_select_account_type_as_and_select_base_account_number_as(String accType, String accNumber) {
        openNewAccountPageObjects.openNewAccount(accType,accNumber);
    }

    @Then("New account is created is displayed and new account number is generated")
    public void new_account_is_created_is_displayed_and_new_account_number_is_generated() {
        openNewAccountPageObjects.validateNewAccountIsOpened();
    }

    @Then("New account number is displayed in the account overview page")
    public void new_account_number_is_displayed_in_the_account_overview_page() {
        openNewAccountPageObjects.validateAccountNumberIsDisplayedInAccountOverviewPage();
    }

}
