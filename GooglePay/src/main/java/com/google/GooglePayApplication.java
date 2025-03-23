package com.google;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GooglePayApplication {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(GooglePayApplication.class, args);
		System.out.println("The implementation class for the IOC-Container is :: " + applicationContext.getClass().getName());
	}
}
