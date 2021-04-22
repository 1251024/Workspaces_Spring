package com.test01;

import org.springframework.stereotype.Component;

@Component
public interface Human {
//property로 해보기 숙제!!
	String sayName(String name);
	String sayJob(String job);
}
