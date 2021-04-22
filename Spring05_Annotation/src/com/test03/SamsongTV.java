package com.test03;

import org.springframework.stereotype.Component;

//SamsongTV samsong = new SamsongTV();
//Component가 지정된 이름으로 객체 생성해줌
//해당 클래스를 빈으로 등록 (applicationContext.xml)에
//컨테이너에
//com.test03을 읽어와서 컴포넌트는 객체만들어주고 오토와이어는 넣어주고...
@Component("samsong")
public class SamsongTV implements TV {

	public SamsongTV() {
		System.out.println("samsong tv 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("samsong tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("samsong tv power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("samsong tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("samsong tv volume down");
	}

}
