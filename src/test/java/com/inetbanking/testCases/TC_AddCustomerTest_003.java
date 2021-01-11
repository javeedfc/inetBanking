package com.inetbanking.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		logger.info("URL is opened");
		lp.setUserName(username);
		logger.info("Entered UserName");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Clicked on Submit button");
		
		//Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		WaitUntilElementIsDisplayed(driver,addcust.lnkAddNewCustomer, 20, 5);
		addcust.clickAddNewCustomer();
		addcust.custName("Javeed");
		addcust.custgender("Male");
		addcust.custdob("01", "07", "1970");
		Thread.sleep(3000);
		addcust.custaddress("India");
		addcust.custcity("BNG");
		addcust.custstate("KAR");
		addcust.custpinno("573201");
		addcust.custtelephoneno("7899180788");
		String email = randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcde");
		addcust.custsubmit();

		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		Thread.sleep(3000);
		System.out.println(res);
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Pass");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Test Fail");
		}
	}



}
