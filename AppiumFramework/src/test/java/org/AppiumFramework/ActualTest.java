package org.AppiumFramework;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.AppiumFramework.pageobjects.android.CartPage;
import org.AppiumFramework.pageobjects.android.FormPage;
import org.AppiumFramework.pageobjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ActualTest extends TestBase{
	
	@Test
	public void checkTest() throws InterruptedException {
		
		
		formPage.sendNameField("Praveen Kumar 76");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		ProductCatalogue productcatalogue = formPage.submitForm();
		productcatalogue.addItemToCartByIndex(0);
		productcatalogue.addItemToCartByIndex(0);
		CartPage cartPage =  productcatalogue.goToCartPage();
		double totalsum =   cartPage.getProductsSum();
		double displayformattedsum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalsum, displayformattedsum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
		Thread.sleep(3000);
		
	}

}
