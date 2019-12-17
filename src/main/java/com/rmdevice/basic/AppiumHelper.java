package com.rmdevice.basic;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
public class AppiumHelper {

	//wait for maximum 30 seconds before any operation
	public WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 120);
	

	protected String getPageSource() {
		return AppiumController.instance.driver.getPageSource();
	}

	protected void inputString(MobileElement mobileElement, String stringToBeEntered) {
		mobileElement = waitTillElementVisible(mobileElement);
		mobileElement.sendKeys(stringToBeEntered);
		AppiumController.instance.driver.hideKeyboard();
	}

	protected void clickElement(MobileElement mobileElement) {
		mobileElement = waitTillElementVisible(mobileElement);
		mobileElement.click();
	}
	
	protected void clickElements(List<WebElement> mobileElement) {
		mobileElement = (List<WebElement>) waitTillElementVisible(mobileElement);
		((WebElement) mobileElement).click();
	}


	protected String getAttribute(MobileElement mobileElement, String attr) {
		mobileElement = waitTillElementVisible(mobileElement);
		return mobileElement.getAttribute(attr);
	}

	protected void goBack() {
		AppiumController.instance.driver.navigate().back();
	}

	protected boolean isVisible(MobileElement mobileElement) {

		boolean status = false;
		try {
			mobileElement = waitTillElementVisible(mobileElement);
			status = true;
		} catch (Exception e) {
			System.out.println(e);

		}
		return status;
	}

	private MobileElement waitTillElementVisible(List<WebElement> mobileElement) {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOfAllElements(mobileElement));

	}

	
	private MobileElement waitTillElementVisible(MobileElement mobileElement) {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(mobileElement));

	}

}
