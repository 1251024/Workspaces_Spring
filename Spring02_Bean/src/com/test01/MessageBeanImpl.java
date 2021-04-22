package com.test01;

public class MessageBeanImpl implements MessageBean{

	private String fruit;
	private int cost;
	
	//기본생성자
	public MessageBeanImpl() {
		this.fruit="바나나";
		this.cost=5000;
		
	}
	
	
	//파라미터 2개짜리 생성자
	public MessageBeanImpl(String fruit, int cost) {
		super();
		this.fruit = fruit;
		this.cost = cost;
	}

	@Override
	public void sayHello() {
		System.out.printf("과일: %s \t 가격 : %d \n", fruit, cost);
	}

	
}
