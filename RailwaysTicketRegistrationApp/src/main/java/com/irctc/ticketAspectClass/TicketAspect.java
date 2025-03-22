package com.irctc.ticketAspectClass;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TicketAspect {

	@Pointcut("executing(* com.irctc.controller..*(..))")
	public void doOperation() {
		System.out.println("TicketAspect.doOperation()");
	}
	
    @Before("doOperation()")
	public void beforeOperation() {
		System.out.println("Joinpoint execution starting ");
	}
    
    @After("doOperation()")
    public void afterOperation() {
    	System.out.println("Joinpoint executed successfully ");
    }
}
