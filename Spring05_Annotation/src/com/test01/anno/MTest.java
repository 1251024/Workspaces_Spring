package com.test01.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/anno/applicatationContext.xml");
		
		MyNickNamePrn my = factory.getBean("myNickName", MyNickNamePrn.class);
		System.out.println(my);
		//bean으로 등록안하고 context:component-scan base-package="경로"
		//경로아래 모든 클래스를 스캔
		//@component로 되있는거 <bean>으로 등록
		
		
	}
}
