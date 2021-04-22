package com.edu.entity;

public abstract class Shape {//부모클래스는 추상클래스로 객체로 만들기 힘듦(interface/abstract class 는 new 사용불가 -><bean> = 객체 = new)

	public String title;
	public int data1;
	public int data2;
	
	public Shape() {
	}
	public Shape(String title, int data1, int data2) {
		this.title = title;
		this.data1 = data1;
		this.data2 = data2;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setData1(int data1) {
		this.data1 = data1;
	}
	public void setData2(int data2) {
		this.data2 = data2;
	}
	
	public abstract void viewSize();
}
