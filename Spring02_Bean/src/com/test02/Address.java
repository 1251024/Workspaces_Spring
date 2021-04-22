package com.test02;

public class Address {

	private String name;
	private String addr;
	private String phone;
	
	//기본생성자
	public Address() {
		
	}
	
	//파라미터 3개짜리 생성자
	public Address(String name, String addr, String phone) {
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	
	//toString
	@Override
	public String toString() {
		return "Address [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
}
