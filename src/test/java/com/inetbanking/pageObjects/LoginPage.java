package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name ="uid")
	@CacheLookup
	public WebElement txtUserName;
	
	@FindBy(name ="password")
	@CacheLookup
	public WebElement txtPassword;
	
	@FindBy(name ="btnLogin")
	@CacheLookup
	public WebElement btnLogin;	
	
	@FindBy(xpath="//a[text()='Log out']")
	@CacheLookup
	public WebElement lnkLogout;
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
