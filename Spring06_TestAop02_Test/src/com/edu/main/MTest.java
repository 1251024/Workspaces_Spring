package com.edu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.entity.Rectangle;
import com.edu.entity.Shape;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/edu/main/beans.xml");

		Shape rect = factory.getBean("rect",Shape.class);//beans에서 rect와 tri라는 이름이 필요
		rect.viewSize();

		Shape tri = factory.getBean("tri",Shape.class);
		tri.viewSize();
		
	}
}
