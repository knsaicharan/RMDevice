package com.rmdevice.basic;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumController {

	public static OS executionOS = OS.ANDROID;

	public enum OS {
		ANDROID
	}

	public static AppiumController instance = new AppiumController();
	public AppiumDriver<?> driver;


	public void start() throws MalformedURLException {
		if (driver != null) {
			return;
		}
		try {
			switch (executionOS) {
			case ANDROID:
				File classpathRoot = new File(System.getProperty("user.dir"));
				File appDir = new File(classpathRoot, "/app/Android");
				File app = new File(appDir, "react.apk");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("BROWSER_NAME", "Android");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel");
				capabilities.setCapability("VERSION", "8.1.0"); 
				capabilities.setCapability("deviceName","Emulator");
				capabilities.setCapability("platformName","Android");	
				capabilities.setCapability("gpsEnabled", true);
				capabilities.setCapability("autoGrantPermissions", true);
				capabilities.setCapability("app", app.getAbsolutePath());
				capabilities.setCapability("appPackage", "com.dev.react");	
				capabilities.setCapability("appActivity","com.dev.react.MainActivity"); 

				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new AndroidDriver(url, capabilities);
				System.out.println("Argument to driver object : " + url);
				break;
			}
		}
		catch (NullPointerException ex) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			throw new RuntimeException("appium driver could not be initialised for device ");


		}


	}

	public void stop() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
