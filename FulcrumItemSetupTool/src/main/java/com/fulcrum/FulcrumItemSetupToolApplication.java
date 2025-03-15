package com.fulcrum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FulcrumItemSetupToolApplication {

	/*
	 * Control flow --> 
	 *     when we start the application IOC-container will be created based upon the application developement approach . 
	 *     1. xmlbeanfactory 
	 *     2. defaultlistablebeanfactoty 
	 *     3. classpathxmlapplicationcontext 
	 *     4. annotationconfigapplicationcontext 
	 *     5. annotationconifgwebapplicationcontext 
	 *     6. annotationconfigwebservletapplicationcontext  
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(FulcrumItemSetupToolApplication.class, args);
	}

}
