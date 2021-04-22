package com.test06;

public class BeanFactory {

	//factory 패턴
	//이름과 맞는 객체를 찾아서 리턴해준다
	public Object getBean(String beanName) {
		if (beanName.equals("samsong")) {

			return new SamsongTv();

		} else if (beanName.equals("ig")) {
			return new IgTv();

		}

		return null;
	}
}
