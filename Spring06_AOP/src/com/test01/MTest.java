package com.test01;

public class MTest {

	public static void main(String[] args) {
		Woman w = new Woman();
		Man m = new Man();
		
		System.out.println("여학생 입장");
		w.classWork();
		System.out.println("-----");
		System.out.println("남학생 입장");
		m.classWork();
		
		
		//여학생 입장
		//출석한다.//ccc
		//컴퓨터를 켜서 주식본다.//cc
		//집에간다.//ccc
		//-----
		//남학생 입장
		//출석한다.//ccc
		//컴퓨터를 켜서 뉴스본다.//cc
		//집에간다.//ccc

		//cc: 클래스별로 각각인것
		//ccc: 클래스끼리 겹치는 것
	}
}
