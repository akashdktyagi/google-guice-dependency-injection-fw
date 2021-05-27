package com.yantraQA.base;

import java.io.File;
import java.util.List;
import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class Interact {

	@Getter @Setter
	private WebDriver driver;

	public void clickElement(WebElement webElement) {
		Preconditions.checkNotNull(webElement,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
		log.debug("Element is clicked. Element Description: " + webElement.toString());
	}
	
	public WebElement setElement(By by, String text) {
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(text);
		log.debug("Element is Set with text as: " + text + ". Element Description: " + by.toString());
		return element;
	}
	
	public String getAttribute(By by, String attName) {
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		String value = element.getAttribute(attName);
		log.debug("Get Attribute for element: " + by.toString() + " Attribute name: " + attName);
		return value;
	}
	
	public String getText(By by) {
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		String value = element.getText();
		log.debug("Get Text for element: " + by.toString() + " Text : " + value);
		return value;
	}
	
	public List<WebElement> getListOfWebElements(By by){
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		log.debug("List of Elements returned for description: " + by.toString());
		return element.findElements(by);
	}
	
	public boolean validateElementIsDisplayed(By by) {
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		boolean b = driver.findElement(by).isDisplayed();
		log.debug("Element is Displayed status: " + by.toString());
		return b;
	}
	
	public void switchToSecondWindowTab() {
		String [] handles = (String[]) driver.getWindowHandles().toArray();
		driver.switchTo().window(handles[1]);
		log.debug("Browser Switched to second window tab.");
	}
	
	public void switchToDefaultWindowTab() {
		String [] handles = (String[]) driver.getWindowHandles().toArray();
		driver.switchTo().window(handles[0]);
		log.debug("Browser Switched to parent window tab.");
	}
	
	public byte[] takeScreenShot() {

		TakesScreenshot shot = (TakesScreenshot)driver;
		log.debug("Screen Shot taken for full driver. ");
		return shot.getScreenshotAs(OutputType.BYTES);
	}
	
	public byte[] takeScreenShot(By by) {
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		TakesScreenshot shot = (TakesScreenshot)driver.findElement(by);
		log.debug("Screen Shot taken for element: " + by.toString() );
		return shot.getScreenshotAs(OutputType.BYTES);
	}
	
	public File takeScreenShotAsFile() {
		TakesScreenshot shot = (TakesScreenshot)driver;
		log.debug("Screen Shot taken for full driver and returned as a file.");
		return shot.getScreenshotAs(OutputType.FILE);
	}
	
	public File takeScreenShotAsFile(By by) {
		TakesScreenshot shot = (TakesScreenshot)driver.findElement(by);
		log.debug("Screen Shot taken for element and returned as a file. By descp: " + by.toString());
		return shot.getScreenshotAs(OutputType.FILE);
	}

}