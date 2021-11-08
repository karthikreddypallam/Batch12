package com.ad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement txtFld_email;
	
	@FindBy(id="passwd")
	private WebElement txtFld_pwd;
	
	@FindBy(id="SubmitLogin")
	private WebElement btn_signIn;
	
	public void login(String user, String pass) {
		txtFld_email.sendKeys(user);
		txtFld_pwd.sendKeys(pass);
		btn_signIn.click();
	}

}
