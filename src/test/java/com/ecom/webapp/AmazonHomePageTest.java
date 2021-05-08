package com.ecom.webapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class AmazonHomePageTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// setup up
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}

	@AfterMethod
	public void afterMethod() {
		// close driver
		driver.close();
	}

	@Test
	public void testAmazonHomePageTitleTest() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(expected, driver.getTitle());
	}
	
	@Test
	public void testAmazonSourceURL() {
		assertEquals(siteURL, driver.getCurrentUrl());
	}
		
	// TODO :: WAT for testng based on previous junit.
	
}
