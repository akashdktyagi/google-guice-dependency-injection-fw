package com.yantraQA.pageObjects;

import com.google.inject.Inject;
import com.yantraQA.base.TestContext;
import io.cucumber.guice.ScenarioScoped;
import org.junit.Assert;
import org.openqa.selenium.By;

@ScenarioScoped
public class AccountOverviewPageObjects extends BasePageObjects {

	private String accNumberGenericLocator = "//td/a[text()='%s']";

	@Inject
	public AccountOverviewPageObjects(TestContext testContext) {
		super(testContext);
	}

	public void validateAccountNumberDisplayedInAccountOverviewTable(String accNumber) {
		boolean actual = driver.findElement(By.xpath(String.format(accNumberGenericLocator,accNumber))).isDisplayed();
		Assert.assertEquals(true,actual);
		testContext.getScenario().log("New Account number is displayed in the acount overview table");
	}


}
