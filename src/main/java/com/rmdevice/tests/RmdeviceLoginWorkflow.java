package com.rmdevice.tests;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RmdeviceLoginWorkflow extends BaseTestClass{

	@Test
	public void cal_add() throws MalformedURLException
	{
		try {


			Assert.assertEquals(true, loginpage.isSigninPageLoaded());
			loginpage.clickSigninBtn();
			Assert.assertEquals(true, loginpage.isloginPageLoaded());
			loginpage.login();	 // Log in using the credentials		
			loginpage.clickLoginBtn();
			createalaram.clickAddBtn();
			createalaram.selectLocation(); //selecting location
			extramenu.clickSignout(); //signing out

		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}


}
