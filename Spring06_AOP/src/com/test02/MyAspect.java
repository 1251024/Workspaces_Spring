package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//aopalliance.intercept.MethodInterceptor;상속받기
//proxy객체
//intercept 할 것임
public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object target = null;

		//타겟 실행전
		System.out.println("출석한다.");//ccc

		try {
			target = invocation.proceed();

			//타겟 실행 후
		} catch (Exception e) {
			System.out.println("쉬는날이었다.");//ccc
		} finally {
			System.out.println("집에 간다.");//ccc : 해당 클래스의 공통관심사
		}

		//타겟을 리턴
		return target;
	}

}
