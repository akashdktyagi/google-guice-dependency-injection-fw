package com.yantraQA.pageObjects;

import com.google.inject.Inject;
import com.yantraQA.base.TestContext;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonPageObjects extends BasePageObjects
{
	@FindBy(how= How.LINK_TEXT,using="Open New Account")
	private WebElement linkOpenNewAccount;;
	@FindBy(how=How.LINK_TEXT,using="Accounts Overview")
	private WebElement linkAccountOverview;;
	@FindBy(how=How.LINK_TEXT,using="Transfer Funds")
	private WebElement linkTransferFunds;;
	@FindBy(how=How.LINK_TEXT,using="Bill Pay")
	private WebElement linkBillPay;;
	@FindBy(how=How.LINK_TEXT,using="Find Transactions")
	private WebElement linkFindTrx;;
	@FindBy(how=How.LINK_TEXT,using="Update Contact Info")
	private WebElement linkUpdateContactInfo;;
	@FindBy(how=How.LINK_TEXT,using="Request Loan")
	private WebElement linkRequesLoan;;
	@FindBy(how=How.LINK_TEXT,using="Log Out")
	private WebElement linkLogOut;

	@Inject
	public CommonPageObjects(TestContext testContext) {
		super(testContext);
		PageFactory.initElements(driver,this);
	}

	public void clickOpenNewAccount() {
		linkOpenNewAccount.click();
		testContext.getScenario().log("Open new Account is clicked");
	}

	public void clickAccountsOverview() {
		linkAccountOverview.click();
		testContext.getScenario().log("AccountOverview is clicked");
	}

	public void clickTransferFunds()
	{
		linkTransferFunds.click();
	}
	public void clickBillPay()
	{
		linkBillPay.click();
	}
	public void clickFindTx()
	{
		linkFindTrx.click();
	}
	public void clickUpdateContactInfo()
	{
		linkUpdateContactInfo.click();
	}
	public void clickRequestLoan()
	{
		linkRequesLoan.click();
	}
	public void clickLogOut()
	{
		linkLogOut.click();
	}



	 
}