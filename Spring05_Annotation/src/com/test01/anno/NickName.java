package com.test01.anno;

import org.springframework.stereotype.Component;

@Component
//객체로 만들어주자
//클래스이름을 첫글자 소문자로 bean객체로 만들어줌

//NickName nickName = new NickName();
//<bean id="NickName" class="com.test01.anno.NickName">
public class NickName {

	@Override
	public String toString() {
		return "bongbong";
	}
	
}
