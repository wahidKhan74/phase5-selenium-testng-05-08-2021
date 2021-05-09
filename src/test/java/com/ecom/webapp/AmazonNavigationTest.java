package com.ecom.webapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class AmazonNavigationTest {

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

	@Test(description="Test for mobile link verification" )
	public void testMobileLinkNavigation() {
		
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		assertEquals(mobileLink.isDisplayed(), true);
		assertEquals(mobileLink.isEnabled(), false);
		mobileLink.click();
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(driver.getTitle(), expected);
	}
	
	@Test(description="Test for todays deal link verification" , dependsOnMethods="testMobileLinkNavigation", alwaysRun=true)
	public void testTodaysDealNavigation() {
		
		WebElement todaysLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		assertEquals(todaysLink.isDisplayed(), true);
		assertEquals(todaysLink.isEnabled(), true);
		todaysLink.click();

	}

}
