package com.ecom.webapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TestNgGroupTest {

	final String amazonURL = "https://www.amazon.in/";
	final String facebookURL = "https://www.facebook.com/";
	
	final String chromePath = "driver/chromedriver";
	final String firefoxPath = "driver/geckodriver";
	
	WebDriver driver1;
	WebDriver driver2;
	
	
	// chrome browser test -> group chrome test	
	@Test(groups="ChromeOnly")
	public void lauchChromeTest() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver1 = new ChromeDriver();
		driver1.get(amazonURL);
	}
	
	@Test(groups="ChromeOnly", dependsOnMethods="lauchChromeTest", priority=1)
	public void testAmazonHomePageTitle() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(expected, driver1.getTitle());
	}
	
	@Test(groups="ChromeOnly", dependsOnMethods="lauchChromeTest",priority=2)
	public void testAmazonSourceURL() {
		assertEquals(amazonURL, driver1.getCurrentUrl());
		driver1.close();
	}
	
	// firefox browser test -> group firefox test	
	@Test(groups="FireFoxOnly")
	public void launchFireFoxTest() {
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		driver2 = new FirefoxDriver();
		driver2.get(facebookURL);
	}

	@Test(groups="FireFoxOnly", dependsOnMethods="launchFireFoxTest", priority=1)
	public void testFacebookHomePageTitle() {
		String expected = "Facebook - Log In or Sign Up";
		assertEquals(expected, driver2.getTitle());
	}
	
	@Test(groups="FireFoxOnly", dependsOnMethods="launchFireFoxTest", priority=1)
	public void testFacebookLogin() {
		
		driver2.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver2.findElement(By.id("pass")).sendKeys("abc@123");
		driver2.findElement(By.name("login")).click();
		driver2.close();
	}
}
