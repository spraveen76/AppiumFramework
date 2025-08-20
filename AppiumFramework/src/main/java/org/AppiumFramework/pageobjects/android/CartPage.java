package org.AppiumFramework.pageobjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.organization.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
AndroidDriver driver;


	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//List<WebElement> productprizes = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    public List<WebElement> productprizes;
	
	//String displaysum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement displaysum;
	
	//WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	public WebElement terms;
	
	//driver.findElement(By.id("android:id/button1"))
	@AndroidFindBy(id="android:id/button1")
	public WebElement acceptButton;
	
	//driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
	@AndroidFindBy(className="android.widget.CheckBox")
			public WebElement checkBox;	
	
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
	public List<WebElement> getProductList()
	{
		return productprizes;
	}
	
	public void acceptTermsConditions() {
		longPressActions(terms);
		acceptButton.click();
	}
	public void submitOrder() {
		checkBox.click();
		//acceptButton.click();
	}
	public double getProductsSum()
	{
		int count = productprizes.size();
				double totalsum = 0;
				for(int i=0;i<count;i++) {
					String amountString = productprizes.get(i).getText();
					//double price = Double.parseDouble(text.substring(1)); 
				  //or
					Double price = getFormattedAmount(amountString);
					totalsum = totalsum + price;
				}
	return totalsum;
	}	
	

	public Double getTotalAmountDisplayed() {
		return getFormattedAmount(displaysum.getText());
		
	}
	
	
	
	
}	
		
	
	

