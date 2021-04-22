package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Student m = factory.getBean("man", Student.class);//객체를 만드는 시점//조인포인트
		Student w = (Student)factory.getBean("woman");//조인포인트
		
		System.out.println("남학생 입장");
		m.classWork();//호출하는 시점//조인포인트
		System.out.println("-----");
		System.out.println("여학생 입장");
		w.classWork();//조인포인트
		
		//위에서 아래로 프로그램 진행순서
		//객체를 만드는 시점이나 호출하는 시점을 Join Point라고 부른다.
		//Join Point에서 리턴되어 와야하는데
		//proxy:타겟인척 하는 애, 신호를 대신 받아줌, 프록시가 인터셉트 해서 강탈해와서 응답해준다.
		//pointcut : 프록시객체가 어떤 조인포인트에서 신호를 강탈할 것인지 알려주는 애
		//advice: target 전, 후에 공통 관심사 ccc 붙여주는 애
		//advisor(aspect):pointcut+advice
		//weaving:프로그램이 묶여서 잘 실행되게 하는 것
		
		
		
	}
}
