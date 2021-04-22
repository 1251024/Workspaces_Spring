package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		//ClassPathXmlApplicationContext: xml이 있는 경로를 찾아서 객체를 만들어서 객체를 가져와서 사용할 거야
		Address lee=(Address) factory.getBean("lee");
		Address hong=(Address) factory.getBean("hong");
		
		System.out.println(lee);
		System.out.println(hong);
	}
}
