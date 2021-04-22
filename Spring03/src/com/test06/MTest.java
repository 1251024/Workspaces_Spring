package com.test06;

public class MTest {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		//빈팩토리에서 이름과 맞는 객체를 찾아서 리턴해준다 /어플리케이션 콘텍스트와 같은역할
		TV tv = (TV) factory.getBean("samsong");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}
}
