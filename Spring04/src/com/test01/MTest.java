package com.test01;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		//아래와 같이 객체 생성하기 전까지는 세팅만 한 상태
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext(
						"com/test01/applicationContext.xml");
		//xml의 클래스패스를 읽어서 빈태그의 객체로 만들거야,
		//factory를 인스턴스화해줄때 생성자부터 실행해서 생성자 호출해서 1,2번 호출함
		
		//"com/test01/applicationContext.xml");경로에있는 파일을 읽어들여서
		//today, myclass객체를 만들어서 
		//ClassPathXmlApplicationContext담는다
		//-----------------------------------------생성과 사용의 분리
		//생성!
		//객체화되는 시점은 xml 읽어들일때
		//컨테이너 담을 그릇 만들고
		//빈 객체를 만들어준다.
		
		//사용!
		//사용하는 시점은 factory.getBean
		//-----------------------------------------		
		System.out.println("----------------------------------------------");
		
		Date today = (Date) factory.getBean("today");
		System.out.println(today.toLocaleString());//2번
		//2번 만든거 가지고와서 출력하자
		
		//3번만든거 가지고와서 그안에 메소드 사용할거야
		MyClass myclass = (MyClass) factory.getBean("myclass");//MyClass myclass = new MyClass();로 생성된 객체를 불러오겠다.
		myclass.prn();//prn은 만들어진 객체를 가지고와서 사용하는 것, 메소드 호출
		

		
		//1번은 생성자 생성!---> 생성되는 순간 출력만 해준 것, 
		
		//2,3번은 xml에서 만들어진것을 가지고 와서 사용하는것
		
		/*
		1. MyClass Constructor!!!
		2. 2021. 4. 15. 오후 1:51:52
		3. MyClass.prn();!!!

		*/
	}
}
