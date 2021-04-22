package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {

	@Autowired
	//값을 자동으로 연결 
	//byType -> byName
	//byType으로 연결할 거 있으면 연결해주고->안되면 byName으로 확인
	//field injection	
	//applicationContext내용을 자동으로 넣어줌
	
	@Qualifier("hong")
	//동일한 타입의 객체가 2개 이상 있을 경우 둘 중에 어떤건지 선택해 줄거야
	
	private Student person;

	private int grade;

	public School() {
	}

	public School(Student person, int grade) {
		super();
		this.person = person;
		this.grade = grade;
	}

	public Student getPerson() {
		return person;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}

}
