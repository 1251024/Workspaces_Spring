package com.edu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Before("execution(public * *(..))")//포인트컷이 필요
	public void before() {
		System.out.println("도형의 넓이를 구한다.");
	}
	
	@After("execution(* viewSize())")//포인트컷이 필요
	public void after() {
		System.out.println("도형의 넓이를 출력한다.");
	}
}
