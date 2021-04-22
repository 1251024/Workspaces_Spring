package com.test03;

public class Developer extends Emp{

	//세터로 넣으면 여기에 값이 저장됨
	private String dept;
	
	public Developer() {
	}
	//부모생성자로 파라미터 호출해서 부머의 생성자로 값이 보내짐
	//생성자 2개
	public Developer (String name, int salary) {
		super(name, salary);
	}

	//세터에 기술 하고 값 넣음
	//세터 하나
	public Developer(String dept) {
		this.dept = dept;
	}
	
	
	@Override
	public String toString() {
		//부모의 toString이 리턴되서 부서가 추가되서 리턴됨
		return super.toString()+" 부서: "+dept;
	}
	
	
	
}
