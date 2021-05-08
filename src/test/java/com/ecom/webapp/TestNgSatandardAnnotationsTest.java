package com.ecom.webapp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgSatandardAnnotationsTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("--  Before suite is executed ! --");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("--  After suite is executed ! --");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("--  Before class is executed ! --");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("--  After class is executed ! --");
	}

	@BeforeMethod
	public void setUpBeforeEachTest() {
		System.out.println("--  Before method is executed ! --");
	}

	@AfterMethod
	public void tearDownAfterEachTest() {
		System.out.println("--  After method is executed ! --");
	}

	@Test
	public void testOne() {
		System.out.println("-- Test 1 method is executed ! --");
	}

	@Test
	public void testTwo() {
		System.out.println("-- Test 2 method is executed ! --");
	}

	@Test
	public void testThree() {
		System.out.println("-- Test 3 method is executed ! --");
	}
}
