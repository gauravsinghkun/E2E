package com.irctc;

import java.lang.annotation.Documented;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@SpringBootApplication
public class RailwaysTicketRegistrationAppApplication {
	public static void main(String[] args) {
		
		/*
		 * Full application flow :--> 
		 *  - We will start the application with the main method and we will pass the configuration class name to the run method . 
		 *  - After that the @SpringBootApplication will start working and internally it contains 3 annotations (component scan , configuration , enableautoconfiguration)
		 *  - based upon the annotations it will do the auto-configuration and it will scan the base packages and the sub-base-packages and will look 
		 *    for the annotations which are used . 
		 *  - After that IOC-container will check for the objects which needs to be created and will create the objects in eager loading style and 
		 *    store in its internal cache (default scope is singleton , choice is prototype )
		 *  - Every time we make a call to the objects it will check the internal caches and will give the same reference for the created objects . 
		 *  - IOC containers used :- 
		 *                          Bean factory 
		 *                          Default Listable bean factory 
		 *                          Classpathapplicationcontext 
		 *                          Classpathxmlapplicationcontext
		 *                          Annotationcconfigapplicationcontext 
		 *                          AnnotationConfigWebServletApplicationContext  
		 *                          
		 *  List Of Annotations which I remember ::

		   @Component - to create object of a user class
		   @Bean - to create object of pre-defined class 
		   @Service - to create object and denote as service class 
		   @Repository -  to create obj and denote as repository  class
		   @Configurable - to configure annotation
		   @Configuration -  to denote any class as a configuration class
		   @EnableAutoConfiguration - it will cover boiler plate config and helps in RAD 
		   @ComponentScan - scan the base package and the sub packages and create the object as per need basis 
		   @Scope - to define scope of a bean 
		   @Qualifier - to denote any class a qualifying bean for autowiring 
		   @Primary - obj will act as a primary key for autowiring 
		   @Autowired - do the dependency injection (byName , byType) , default is byType . 
		   @PreDestroy - destroy after executing 
		   @PostConstruct -  execute before operation
		   @RestController - denote our class as the controller class for the rest clients and the resp will pass directly to client 
		   @RequestMapping - to denote uniform resouce uri for class 
		   @ResponseBody - to bind the method response to the http response 
		   @ResponseStatus - give the response status 
		   @GetMapping - to hit get request 
		   @PostMapping - to hit post request 
		   @DeleteMapping - to hit delete request 
		   @RequestParam - to get the queryString param data as key value pair 
		   @RequestBody - to bind the request body to the entity object 
		   @PathParam - to bind query parameter to the method paramter 
		   @PathVariable - to fetch pathVariable data 
		   @Query - to create user defined query in SpringJPA
		   @Id - to denote as the prrimary key 
		   @GenericGenerator - custom PK generator 
		   @GeneratedValue - to denote the strategy for PK generation
		   @Entity - to tell hibernate the className 
		   @ManyToOne etc ... - association
		   @Table - create table with our choice table name 
		   @Column - create colummn with length 
		   @Version - to inform how many time the object has been modified 
		   @CreationTimestamp - NA
		   @UpdateTimestamp - NA 
		   @Modifying - object is modifying 
		   @Aspect - to denote class as Aspect class
		   @Before - execute anything before target Business method
		   @AfterThrowing - after method throw exception
		   @AfterReturning - after method execute successfully 
		   @Pointcut - seperate Business logic with the normal methods 
		   @Around 
		   @ExceptionHandler
		   @RestControllerAdvice
		   @Deprecated
		   @Documented
		   @PropertySource
		   @ImportResource
		   @org.springframework.beans.factory.annotation.Value
		   @ConfigurationProperties
		   @Getter
		   @Setter
		   @NoArgsConstructor
		   @ToString
		   @AllArgsConstructor
		   @EqualsAndHashCode
		   @Data
		   @EnableWebSecurity
		   @enableswagger2
           @Junit  annotations which work inside test package .		   
           
           */
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(RailwaysTicketRegistrationAppApplication.class, args);
		System.out.println("IOC-Container is :: " + applicationContext.getClass().getName());
	}
}
