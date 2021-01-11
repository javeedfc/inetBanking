package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws InterruptedException {

		logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);
		WaitUntilElementIsDisplayed(driver,lp.txtUserName, 20, 5);
		lp.setUserName(username);
		
		logger.info("UserName is entered");
		lp.setPassword(password);
		logger.info("Password is entered");
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");

		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

	}


}
