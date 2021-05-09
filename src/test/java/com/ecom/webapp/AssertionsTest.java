package com.ecom.webapp;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {

	// hard assert : Hard Assert throws an AssertException immediately when an
	// assert statement fails and test suite continues with next @Test

	@Test
	void hardAssert() {
		System.out.println("--- Hard Assert method was started.. --");
		// assertEquals(true, false); /// Assertion Error
		System.out.println("-- Hard Assert is completed. ---");
	}

	// soft assert :- Soft Assert collects errors during @Test.
	// Soft Assert does not throw an exception when an assert fails
	@Test
	public void softAssert() {

		SoftAssert softAssert = new SoftAssert();
		System.out.println("--- Soft Assert method was started. ---");
		softAssert.assertEquals(true, false);
		softAssert.assertTrue(false);
		System.out.println(" -- SOft Assert method was completed. ---");
	}
}
