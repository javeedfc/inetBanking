package com.inetbanking.testCases;


import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password= readconfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver= new ChromeDriver();
			System.out.println(br);
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver= new FirefoxDriver();
		}
		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver= new InternetExplorerDriver();
		}
		driver.get(baseURL);
	}

	public String randomestring()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(7);
		return (generatedstring);
	}
	public String randomeNum()
	{
		String generatedstring1 = RandomStringUtils.randomNumeric(6);
		return (generatedstring1);
	}
	
	protected WebElement WaitUntilElementIsDisplayed(WebDriver driver, WebElement locator, int maxtimeout, int polltimeout)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,maxtimeout);
			return wait.ignoring(NoSuchElementException.class)
					.pollingEvery(Duration.ofSeconds(polltimeout))
					.until(ExpectedConditions.visibilityOf(locator));
		}
		catch (Exception ex)
		{
			System.out.println("Exception while waiting {ex.Message}" + ex.getMessage());
			return null;
		}
	} 

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}
