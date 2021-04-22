package com.test04;

public class Woman implements Student {

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 뉴스본다.");
		return "스프링 연습";
	}

}
