package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class MyAspect {

	//advisor(aspect)=advice+pointcut(포인트컷과 어드바이스가 합쳐진 관점)
	@Before("execution(public * *(..))")//포인트컷
	public void before(JoinPoint join) {//advice 실제 코드
		System.out.println("출석한다.");
	}
	
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
		
	}
	
	@AfterReturning(pointcut = "execution(public * *(..))", returning = "returnVal")
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal+" 열심히 하는 날이었다.");
	}
	
	@AfterThrowing("execution(public * *(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날이었다...");
	}
	
	/*
	 Before : 실행 전
	 After : 실행 후
 	 After-returning : 성공적으로 실행되면 리턴되는 값 받아서 실행
	 After-throwing : 에러발생했을때 
	 */
}
