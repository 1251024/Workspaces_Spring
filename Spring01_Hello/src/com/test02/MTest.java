package com.test02;

public class MTest {
	
	public static void main(String[] args) {
		MessageBean korean = new MessageBeanKo();
		korean.sayHello("스프링");
		
		MessageBean english = new MessageBeanEn();
		english.sayHello("Spring");
	}
}
