package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Student {

	@Override
	public void classWork() {
		System.out.println("컴퓨터를 켜서 뉴스 본다.");

	}

}
