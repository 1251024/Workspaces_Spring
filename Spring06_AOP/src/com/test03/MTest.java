package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Student w = factory.getBean("woman", Student.class);//연결될 수 잇는 시점
		Student m = (Student) factory.getBean("man");//연결될 수 잇는 시점
		
		System.out.println("여학생 입장");
		w.classWork();//연결될 수 잇는 시점 -pointcut
		System.out.println("-----");
		System.out.println("남학생 입장");
		m.classWork();//연결될 수 잇는 시점
		
		//joinpoint : 연결될 수 있는 모든 시점
		//pointcut : 어떤 시점에 proxy에 연결해줄 수 있는지 지정해주는 지점
		//proxy: 해당 포이트컷에 프록시 객체가 만들어져서 CCC before나 after를 연결해준다(target의 전, 후에 연결)
	}
}
