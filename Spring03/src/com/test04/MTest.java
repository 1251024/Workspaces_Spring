package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/beans.xml");
		
		//object로 나와서 형변환해함
		Developer lee = factory.getBean("lee-ss", Developer.class);//"lee-ss",: lee-ss라는 객체를 가져올건데, 
																	//Developer.class: Developer라는 이름을 가진 클래스타입입니다라고 알려주는 것 
		Engineer hong = (Engineer) factory.getBean("hong-gd");//명시적형변환
		
		System.out.println(lee);
		System.out.println(hong);
	}

}
