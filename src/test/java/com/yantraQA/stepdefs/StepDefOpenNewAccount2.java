package com.yantraQA.stepdefs;

import com.google.inject.Inject;
import com.yantraQA.base.TestContext;
import com.yantraQA.pageObjects.CommonPageObjects;
import com.yantraQA.pageObjects.LoginPageObjects;
import com.yantraQA.pageObjects.OpenNewAccountPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefOpenNewAccount2 {

    @Inject
    OpenNewAccountPageObjects openNewAccountPageObjects;

    @Then("New account number is displayed in the account overview page")
    public void new_account_number_is_displayed_in_the_account_overview_page() {
        openNewAccountPageObjects.validateAccountNumberIsDisplayedInAccountOverviewPage();
    }

}
