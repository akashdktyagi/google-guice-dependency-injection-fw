package com.yantraQA.pageObjects;

import com.google.inject.Inject;
import com.yantraQA.base.TestContext;
import io.cucumber.guice.ScenarioScoped;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects extends BasePageObjects{

    @FindBy(how= How.NAME,using="username")
    private WebElement txtbx_username;

    @FindBy(how=How.XPATH,using="//input[@name='password']")
    private WebElement txtbx_password;

    @FindBy(how=How.XPATH,using="//input[@class='button']")
    private WebElement btn_Login;

    @Inject
    public LoginPageObjects(TestContext testContext) {
        super(testContext);
        PageFactory.initElements(driver,this);
    }

    public void SetUsername(String Username) {
        txtbx_username.sendKeys(Username);
        testContext.getScenario().log("Username is set as : " + Username);

    }

    public void SetPassword(String password) {
        txtbx_password.sendKeys(password);
        testContext.getScenario().log("password set as : " + password);
    }

    public void ClickSubmit() {
        btn_Login.click();
        testContext.getScenario().log("Submit button Clicked");
    }

    public void enterUserNameAndPasswordAndClickSubmit(String u, String p) {
        SetUsername(u);
        SetPassword(p);
        ClickSubmit();
    }

    public void validateLoginIsSuccess(){
        Assert.assertEquals("ParaBank | Accounts Overview",driver.getTitle());
        testContext.getScenario().log("Login is sucess. Title matches.");
    }
}



