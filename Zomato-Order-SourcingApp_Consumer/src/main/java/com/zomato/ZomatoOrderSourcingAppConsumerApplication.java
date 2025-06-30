package com.zomato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ZomatoOrderSourcingAppConsumerApplication {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ZomatoOrderSourcingAppConsumerApplication.class, args);
		System.out.println(applicationContext.getClass().getName());
		
	}
}
