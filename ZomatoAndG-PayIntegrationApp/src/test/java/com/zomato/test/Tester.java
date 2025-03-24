package com.zomato.test;

import java.lang.annotation.Documented;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import com.zomato.testClassMethods.TestClass;

@DisplayName("Tester class for evaluating I/p's")
public class Tester {

	/*
	       J-Unit internal code will create the objects of the tester class and then it will only call the methods and do 
	         the equality checking .
	       
	 @Test
	 @DisplayName
	 @RepeatedTest
	 @Order
	 @AfterEach
	 @BeforeEach
	 @AfterAll
	 @BeforeAll
	 @Disabled
	 @Documented
	 @ParameterizedTest
	*/
	
	public static TestClass testClass;

	@BeforeEach
	public void doSetUp() {
       testClass= new TestClass();
	}

	@Test
	@DisplayName("testWithSmallInputs")
	public void testWithSmallInputs() throws InterruptedException {
		Integer actualOP = testClass.showNameLength("gaurav");
		Integer expectedOp = 6;
		org.junit.jupiter.api.Assertions.assertEquals(expectedOp, actualOP);
	}

	@Test
	@DisplayName("testWithLargeInputs")
	public void testWithLargeInputs() throws InterruptedException {
		Integer actualOp = testClass.showNameLength("gaurav-singh-kuntal");
		Integer expectedOp = 19;
		Assertions.assertEquals(expectedOp, actualOp);
	}

	@Test
	@DisplayName("testWithException")
	public void testWithException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> testClass.showNameLength(""));
	}
	
	@AfterEach
	public void doCleanUp() {
		testClass=null;
	}
}
