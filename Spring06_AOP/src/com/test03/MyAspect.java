package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	//ccc = advice
	//aspectj의 JoinPoint 임포트
	public void before(JoinPoint join) {
		System.out.println("출석한다.");
		//어떤 조인포인트에 연결되어있는지 출력
		System.out.println(join.getTarget().getClass());
		//조인포인트이름 출력
		System.out.println(join.getSignature().getName());
	}
	
	public void after() {
		System.out.println("집에 간다.");
	}
	
}
