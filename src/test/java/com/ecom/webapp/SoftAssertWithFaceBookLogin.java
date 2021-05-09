package com.ecom.webapp;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertWithFaceBookLogin {

	final String siteURL = "https://www.facebook.com/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	// firefox browser test -> group firefox test
	@Test(groups = "FireFoxOnly")
	public void launchFireFoxTest() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}

	@Test(groups = "FireFoxOnly", dependsOnMethods = "launchFireFoxTest", priority = 1)
	public void testFacebookHomePageTitle() {
		String expected = "Facebook - Log In or Sign Up";
		softAssert.assertEquals(expected, driver.getTitle());
	}

	@Test(groups = "FireFoxOnly", dependsOnMethods = "launchFireFoxTest", priority = 1)
	public void testFacebookLogin() {

		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("abc@123");

		softAssert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
		softAssert.assertTrue(driver.findElement(By.id("pass")).isDisplayed());
		softAssert.assertTrue(driver.findElement(By.name("login")).isDisplayed());

		driver.findElement(By.name("login")).click();
		driver.close();
	}
}
