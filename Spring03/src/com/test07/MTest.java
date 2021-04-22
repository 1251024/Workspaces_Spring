package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factroy = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		//스프링 ioc컨테이너로 사용
		System.out.println("spring ioc container 준비완료!");
		
		TV tv = (TV) factroy.getBean("samsong");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}
}
