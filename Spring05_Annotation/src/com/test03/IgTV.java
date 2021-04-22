package com.test03;

import org.springframework.stereotype.Component;

//IgTV igTV = new IgTV();
//Component는 igTV객체를 만들어줌
@Component
public class IgTV implements TV {

	public IgTV() {
		System.out.println("ig tv 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("ig tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("ig tv powef off");
	}

	@Override
	public void volumeUp() {
		System.out.println("ig tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("ig tv volume down");
	}

}
