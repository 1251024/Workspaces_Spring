package com.test06;

public class IgTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("ig tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("ig tv off");
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
