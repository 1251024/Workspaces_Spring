package com.test04;

public class Man implements Student {

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 주식본다.");
		//String t = null; //에러 보고 싶을 때
		//t.length();
		return "스프링 연습";
	}

}
