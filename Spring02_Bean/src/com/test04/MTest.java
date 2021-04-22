package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		//applicationContext.xml에서 객체생성한걸 applicationContext.xml"에 생성된 bean객체를 가져와서 사용할거야
		//DI는 applicationContext.xml에서 객체 생성할 때 값 넣어주는 것
		Address lee = (Address) factory.getBean("lee");// applicationContext.xml에서 만들때는 Address타입이지만 Object 타입으로 리턴 됨
		//factory.getBean는 오브젝트 타입=> 어떤 객체든 받아주게 하려고 가장 큰값 (오브젝트로) 받아서 Address로 명시적 형변환 해줌
		
		Address hong = (Address) factory.getBean("hong");
		
		System.out.println(lee);
		System.out.println(hong);
		
	}
}
