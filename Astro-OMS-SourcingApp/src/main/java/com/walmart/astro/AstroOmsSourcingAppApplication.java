package com.walmart.astro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AstroOmsSourcingAppApplication {

	/*
	 *  The application context IOC conatainers are :: 
	 *   1. xmlbeanfactory()
	 *   2. defaultlistablebeanfactory()
	 *   3. classpathxmlapplicationcontext()
	 *   4. AnnotationconfigAppliicationContext()
	 *   5. AnnotationConfigWebServletApplicationContext()
	 */
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(AstroOmsSourcingAppApplication.class, args);
		System.out.println("The IOC Container is :: " +applicationContext.getClass().getName());
	}
}
