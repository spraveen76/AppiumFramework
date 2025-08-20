package org.AppiumFramework.pageobjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.organization.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions {
	
	AndroidDriver driver;
	
	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addtocart;
	
	public void addItemToCartByIndex(int index) {
		addtocart.get(index).click();
	}
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	public CartPage goToCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(4000);
		return new CartPage(driver);
	}
	
	
	
	
	
	
}
