package com.test06;

public class SamsongTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("samsong tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("samsong tv off");
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
