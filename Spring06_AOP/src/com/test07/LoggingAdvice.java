package com.test07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String method = invocation.getMethod().getName();
		
		StopWatch timer = new StopWatch();
		
		timer.start(method);
		System.out.println("[LOG] METHOD : "+method+"is calling");
		
		Object target = invocation.proceed();
		
		timer.stop();
		System.out.println("[LOG] METHOD : "+method+"was called");
		System.out.println("[LOG] METHOD : "+timer.getTotalTimeSeconds()+" sec");
		
		return target;
	}
}
