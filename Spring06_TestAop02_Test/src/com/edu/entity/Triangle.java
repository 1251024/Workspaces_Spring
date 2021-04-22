package com.edu.entity;

public class Triangle extends Shape {

	public Triangle() {
	}

	public Triangle(String title, int data1, int data2) {//값세개 사용
		super(title, data1, data2);//부모한테 보내서
	}

	@Override
	public void viewSize() {
		System.out.println(title + "의 넓이 : " + ((double)(data1*data2))/2);//부모거랑 같이 사용
	}
}
