package com.test01;

public class MyClass {

	//기본생성자-생성해야만 불러오는 함수
	public MyClass() {
		System.out.println("MyClass Constructor!!!");
		//syso는 사용이 아님
		//생성자= 생성함수
		//함수안에 syso넣어서 생성되면 동작하게 할뿐
	}
	
	//메소드-호출해야만 불러오는 함수
	public void prn() {
		System.out.println("MyClass.prn();!!!");
	}
}
