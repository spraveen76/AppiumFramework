package org.AppiumFramework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.AppiumFramework.pageobjects.android.FormPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestBase {
	public AndroidDriver driver;
	public AppiumDriverLocalService service ;
	FormPage formPage;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
	 service = new AppiumServiceBuilder()
			.withAppiumJS(new File("C://Users//spk76//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
			.withIPAddress("127.0.0.1")
			.usingPort(4723)
			.build();
	service.start();
	
	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName("Pixel 6 Pro API 30");

	options.setChromedriverExecutable("D://UDAPPIUM//chromedriver_win32//chromedriver.exe");
	options.setApp("C://Users//spk76//eclipse-workspace//Appium//src//test//java//resources//General-Store.apk");

	 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 formPage = new FormPage(driver);
	//For JAVA 20 use below code
		//AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
	
	}	
	

	@AfterClass
	public void tearDown() {
		
		driver.quit();
		service.stop();
	}
}
