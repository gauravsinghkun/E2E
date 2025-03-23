package com.google.aspectClasses;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountAspectClass {

	@Pointcut("execution(* com.google.controller..*(..))")
	public void operation() {
		System.out.println("AccountAspectClass.operation()");

	}

	@Before("operation()")
	public void beforeOperation() {
		System.out.println("Join-point starting");
	}

	@After("operation()")
	public void afterOperation() {
		System.out.println("Join-point executed");
	}
}
