package com.zomato.testClassMethods;

public class TestClass {

	public Integer showNameLength(String name) throws InterruptedException {
		Thread.sleep(1000);
		if (name.length() == 0)
			throw new IllegalArgumentException("Please enter a valid name");
		return name.length();
	}
}
