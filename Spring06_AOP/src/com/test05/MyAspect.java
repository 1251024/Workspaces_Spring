package com.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

	@Pointcut("execution(public * *(..))")
	public void myClass() {
		
	}
	
	@Before("myClass()")
	public void beforeTarget() {
		System.out.println("출석한다.");
	}
	
	@After("myClass()")
	public void afterTarget() {
		System.out.println("집에 간다.");
	}
	
}
