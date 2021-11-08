package com.ad.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ad.pages.HomePage;
import com.ad.pages.LoginPage;
import com.ad.pages.MyAccountPage;

import utils.IConstants;
import utils.RetryListener;

public class LoginTest extends BaseTest {
	
	LoginPage lp = null;
	HomePage hp = null;
	MyAccountPage myAccPage = null;
	
	@BeforeMethod()
	public void beforeMethod() {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		myAccPage = new MyAccountPage(driver);
		hp.navToLoginPage();
	}
	@Test(description="verify Login with valid credentials",priority=0)
	public void validLogin() {
		lp.login(cfgReader.getValidEmail(), cfgReader.getPwd());
		assertFalse(myAccPage.lnk_signOut.isDisplayed());
	}
	// retryAnalyzer = Retry.class
	@Test(description="verify Login with invalid credentials",priority=1)
	public void invalidLogin() {
		lp.login(cfgReader.getInvalidEmail(), cfgReader.getPwd());
		assertTrue(hp.lnk_signIn.isDisplayed());
	}
	
	@Test(description="verify Login with empty credentials",priority=2)
	public void emptyLogin() {
		lp.login("", "");
		assertTrue(hp.lnk_signIn.isDisplayed());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult iresult) throws IOException {
		try {
			myAccPage.navToLoginPage();
		}catch(Exception e) {
			
		}
		
		if(ITestResult.SUCCESS == iresult.getStatus())
			System.out.println(iresult.getMethod().getMethodName()+" ====> pass");
		else if(ITestResult.FAILURE == iresult.getStatus()) {
			System.out.println(iresult.getMethod().getMethodName()+" ====> fail");
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(IConstants.failedScreenshots));
		}
		else
			System.out.println(iresult.getMethod().getMethodName()+" ====> skipped");

	}
	
	
}
