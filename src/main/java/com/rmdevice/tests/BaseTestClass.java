package com.rmdevice.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.rmdevice.basic.AppiumController;
import com.rmdevice.pages.CreateAlaram;
import com.rmdevice.pages.CreatingAlaramAndroid;
import com.rmdevice.pages.LoginPage;
import com.rmdevice.pages.LoginPageAndroid;
import com.rmdevice.pages.extraMenu;
import com.rmdevice.pages.extramenuAndroid;


public class BaseTestClass extends com.rmdevice.basic.AppiumBaseClass {

	protected CreateAlaram createalaram;
	protected LoginPage loginpage;
	protected extraMenu extramenu;

	@BeforeSuite
	public void setUp() throws Exception {
		AppiumController.instance.start();
		switch (AppiumController.executionOS) {
		case ANDROID:

			createalaram = new CreatingAlaramAndroid(driver());
			loginpage = new LoginPageAndroid(driver());
			extramenu = new extramenuAndroid(driver());			
			break;

		}
	}

	@AfterSuite
	public void tearDown() {
		AppiumController.instance.stop();
	}
}

