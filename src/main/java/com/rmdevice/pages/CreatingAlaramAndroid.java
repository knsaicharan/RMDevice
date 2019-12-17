package com.rmdevice.pages;

import java.util.List;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.rmdevice.basic.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreatingAlaramAndroid extends AppiumHelper implements CreateAlaram{
	List<MobileElement> buttons,sectionList;
	String Selected_alaram;

	@FindBy(xpath = "//*[contains(@content-desc, 'close add')]")
	public  MobileElement  add_btn;

	@FindBy(xpath = " //*[@class='android.widget.CheckBox']")
	public static List<MobileElement> checkbox;

	@FindBy(xpath = "//*[@class='android.widget.Button']")
	public
	static List<MobileElement> button;




	public CreatingAlaramAndroid(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	public void clickAddBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(add_btn)).click();   
		//Clicking on next button
		buttons =(CreatingAlaramAndroid.button);
		buttons.get(0).click();
	}



	public void selectLocation() {
		try {

			sectionList= (CreatingAlaramAndroid.checkbox);

			//selecting the location 'Primary Area'
			if(!sectionList.get(1).isSelected())
			{
				sectionList.get(1).click();
				Selected_alaram =sectionList.get(1).getAttribute("content-desc");
				Assert.assertEquals("Primary Area", Selected_alaram);


			}	

			System.err.println("**********Location " +Selected_alaram + " is selected sucessfully**********");
			wait.until(ExpectedConditions.elementToBeClickable(button.get(1))).click(); // clicking on next after selecting location
			Thread.sleep(1000);	
			wait.until(ExpectedConditions.elementToBeClickable(button.get(1))).click();	//Setting the Alaram	
			Thread.sleep(3000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}	

		
	}




}
