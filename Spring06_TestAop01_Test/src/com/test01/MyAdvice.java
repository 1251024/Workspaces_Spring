package com.test01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAdvice {
	
	//JoinPoint import를  aspectj로 해야하고 
	//aopalliance.intercept.Joinpoint;로 하면 에러-대소문자차이
	//org.aspectj.lang.JoinPoint: 대문자
	//org.aopalliance.intercept.Joinpoint: 소문자
	
	@Before("execution(public * sayName(..))")
	public void beforeSaying(JoinPoint join	) {
		System.out.println("당신의 이름은 무엇입니까?");
		
	}
	
	@After("execution(public * sayJob(..))")
	public void afterSaying(JoinPoint join) {
		System.out.println("이름이 멋지시네요");
	}
	
	@AfterReturning(pointcut = "execution(public * sayJob(..))")
	public void afterReturnSaying(JoinPoint join) {
		System.out.println("직업이 무엇입니까?");
	}
	

}
