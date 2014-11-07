package com.primeton.wujun.springtest.demo1;

public class Dog {
	String name;
	int age;
	void speak(){
		System.out.println("Dog:"+name+"½ñÄê"+age+"ËêÁË£¡");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
