package com.rmdevice.pages;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.rmdevice.basic.AppiumHelper;
import com.rmdevice.basic.Configreader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPageAndroid extends AppiumHelper implements LoginPage {

	Configreader configFileReader;
	List<MobileElement> editText;

	@FindBy(className = "android.widget.EditText")
	public  List<MobileElement> user_pass;
	@FindBy(xpath = "//*[contains(@content-desc, 'SIGN')]")
	public static MobileElement  Signin;
	@FindBy(xpath = "//*[contains(@content-desc,  'LOG IN     log in ')]")
	public static MobileElement login;


	public LoginPageAndroid(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void login() {

		configFileReader= new Configreader();
		//Entering the username and password
		editText = (user_pass);
		editText.get(0).sendKeys(Configreader.getEmail());
		editText.get(1).sendKeys(Configreader.getPassword());			

	}
	
	public boolean isSigninPageLoaded() {
		return isVisible(Signin);
		
	}
	
	
	public void clickSigninBtn() {
		wait.until(ExpectedConditions.visibilityOf(Signin));
		clickElement(Signin);
		
	}
	
	public boolean isloginPageLoaded() {
		return isVisible(login);
	}
	
	public void clickLoginBtn(){
		wait.until(ExpectedConditions.visibilityOf(login));
		clickElement(login);
		System.err.println("********Waiting for Login*********");
		

	}
}



