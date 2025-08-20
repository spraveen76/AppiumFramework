package org.AppiumFramework.pageobjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.organization.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) 
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Praveen Kumar 76");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	public void sendNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
		}
	
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement female;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement male;
	
	public void setGender(String gender)
		{
			if (gender.contains("female"))
				female.click();
			else
				male.click();		
		}
		
	//Country selection
	
	//driver.findElement(By.id("android:id/text1")).click();
	@AndroidFindBy(id="android:id/text1")
		public WebElement countrySelection;
	
	public void setCountrySelection(String countryName) {
		countrySelection.click();
		scrollToText(countryName);
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	//Final click on form Page
	//driver.findElement(By.id("com.androidsample.generalstore:id/tnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	WebElement shopbutton;
	
	public  ProductCatalogue submitForm() {
		
		shopbutton.click();
		return new ProductCatalogue(driver);
	}
	
	
		
	}

