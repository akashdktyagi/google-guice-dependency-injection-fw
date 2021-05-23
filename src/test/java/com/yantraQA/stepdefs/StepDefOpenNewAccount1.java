package com.yantraQA.stepdefs;

import com.google.inject.Inject;
import com.yantraQA.base.TestContext;
import com.yantraQA.pageObjects.CommonPageObjects;
import com.yantraQA.pageObjects.LoginPageObjects;
import com.yantraQA.pageObjects.OpenNewAccountPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefOpenNewAccount1 {

    @Inject
    OpenNewAccountPageObjects openNewAccountPageObjects;

    @Then("New account is created is displayed and new account number is generated")
    public void new_account_is_created_is_displayed_and_new_account_number_is_generated() {
        openNewAccountPageObjects.validateNewAccountIsOpened();
    }


}
