package com.test03;

public class Person {

	private String name;
	private int age;

	//기본생성자 단축키 ctrl+space
	public Person() {

	}

	//파라미터 생성자 단축키 alt+shift+s, o
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void sayHello() {
		System.out.printf("내 친구는 %s 는 %d 살 입니다.", name, age);
	}

}
