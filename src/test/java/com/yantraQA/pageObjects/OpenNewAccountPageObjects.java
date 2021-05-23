package com.yantraQA.pageObjects;

import com.google.inject.Inject;
import com.yantraQA.toBeInjected.TestContext;
import io.cucumber.guice.ScenarioScoped;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@ScenarioScoped
public class OpenNewAccountPageObjects extends BasePageObjects {

	@FindBy(id = "type")
	private WebElement accountType;

	@FindBy(id = "fromAccountId")
	private WebElement fromAccountType;

	@FindBy(xpath = "//input[@value='Open New Account']")
	private WebElement btnOpenNewAccount;

	@FindBy(xpath = "//h1[text()='Account Opened!']")
	private WebElement txtNewAccountIsOpenedMessage;

	@FindBy(xpath = "//a[@id='newAccountId']")
	private WebElement linkNewAccountNumber;

	//In case page object methods is to be used with in the another page object.
	CommonPageObjects commonPageObjects;
	AccountOverviewPageObjects accountOverviewPageObjects;

	@Inject
	public OpenNewAccountPageObjects(TestContext testContext) {
		super(testContext);
		PageFactory.initElements(driver, this);
		commonPageObjects = new CommonPageObjects(testContext);
		accountOverviewPageObjects = new AccountOverviewPageObjects(testContext);
	}

	private void selectAccountType(String accType) {
		Select actype = new Select(accountType);
		actype.selectByVisibleText(accType);
		testContext.getScenario().log("Account type is selected: " + accType);
	}

	private void selectBaseAccountNumber(String val) {
		Select accType = new Select(fromAccountType);
		accType.selectByValue(val);
		testContext.getScenario().log("base account number is selected: " + val);
	}

	private void clickSubmit() {
		btnOpenNewAccount.click();
		testContext.getScenario().log("Submit button is clicked");
	}

	public void openNewAccount(String accType, String accNumber){
		selectAccountType(accType);
		selectBaseAccountNumber(accNumber);
		clickSubmit();
		testContext.getScenario().log("New Account Opened with AccType as : " + accType + " and acc number: " + accNumber);
	}

	public void validateNewAccountIsOpened() {
		Assert.assertEquals(true,txtNewAccountIsOpenedMessage.isDisplayed());
		testContext.getScenario().log("New account Opened message is Displayed");
	}

	public void validateAccountNumberIsDisplayedInAccountOverviewPage(){
		//Fetch the account number
		String newAccountNumber = linkNewAccountNumber.getText();
		testContext.getScenario().log("new Account number created and fetched: " +  newAccountNumber);

		//Navigate to account service page
		commonPageObjects.clickAccountsOverview();

		//check the existence
		accountOverviewPageObjects.validateAccountNumberDisplayedInAccountOverviewTable(newAccountNumber);

	}
}
