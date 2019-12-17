package com.rmdevice.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.rmdevice.basic.AppiumHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class extramenuAndroid extends AppiumHelper implements extraMenu {
	@FindBy(className = "android.view.View")
	public static  List<WebElement> view_list;
	@FindBy(xpath = "//*[contains(@content-desc, ' Signout')]")
	public static MobileElement  Signout;

	
	

	public extramenuAndroid(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void clickSignout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(view_list.get(0))).click();
		wait.until(ExpectedConditions.elementToBeClickable(Signout));
		clickElement(Signout);
		System.err.println("**********Signout Sucessfull***********");
	}


	@Override
	public void clickOnProfile() {
		// TODO Auto-generated method stub
		
	}

}
