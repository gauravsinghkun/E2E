package com.walmart.astro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AstroOmsSourcingAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(AstroOmsSourcingAppApplication.class, args);
		System.out.println("The IOC Container is :: " +applicationContext.getClass().getName());
	}
}
