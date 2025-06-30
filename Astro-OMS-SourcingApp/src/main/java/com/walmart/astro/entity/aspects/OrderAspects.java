package com.walmart.astro.entity.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.walmart.astro.entity.Order;
import com.walmart.astro.entity.errorClass.ErrorClass;

@Aspect
@Component
public class OrderAspects {

	class Display{
	     public void display() {System.out.println("OrderAspects.Display.display()");}	
	 }
	
	@Pointcut("execution()")
	public void doOperation() {
		System.out.println("OrderAspects.doOperation()");
	}

	@Before("doOperation()")
	public void afterOperation() {
		System.out.println("After-Joinpoint executed");
	}
}
