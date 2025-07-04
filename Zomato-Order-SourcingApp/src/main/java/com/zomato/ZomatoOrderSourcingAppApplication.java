package com.zomato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class ZomatoOrderSourcingAppApplication {
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication
				.run(ZomatoOrderSourcingAppApplication.class, args);
		System.out.println(applicationContext.getClass().getName());

	}
}
