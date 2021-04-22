package com.test01;

public class Person implements Human {

	//변수 저장
    private String name;
    private String job;

    //생성자
    public Person() {
    }

    //세터
    public void setJob(String job) {
        this.job = job;
    }

    public void setName(String name) {
        this.name = name;
    }

    //휴먼 상속
    @Override
    public String sayName(String name) {
//        return "나의 이름은 " + name + " 입니다.";
        return String.format("나의 이름은 %s 입니다.", name);
    }

    @Override
    public String sayJob(String job) {
        return "나의 직업은 " + job + " 입니다.";
    }

}