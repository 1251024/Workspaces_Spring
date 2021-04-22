package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//<bean id="myNickName" class="com.test01.anno.MyNickNamePrn">
@Component("myNickName")
//객체로 만들자
public class MyNickNamePrn {

	@Autowired
	//값을 연결해주자
	private NickName nickName;

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "제 별명은 " + nickName + "입니다.";
	}

}
