package com.ad.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utils.ConfigReader;
import utils.IConstants;

public class BaseTest {
	ConfigReader cfgReader = null;
	static WebDriver driver = null;
	
	@BeforeSuite
	public void init() {
		// read config
		cfgReader = new ConfigReader();
		cfgReader.readConfig();
	}

	@BeforeTest
	public void launchBrowser() {
		openChromeBrowser();
		driver.get(cfgReader.getURL()); // load a new web page
		driver.manage().window().maximize(); // maximize
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", IConstants.chromeDriverPath);
		driver = new ChromeDriver(); // It will open chrome browser
	}
	
	public static void openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", IConstants.firefoxDriverPath);
		driver = new ChromeDriver(); // It will open chrome browser
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}
	

}
