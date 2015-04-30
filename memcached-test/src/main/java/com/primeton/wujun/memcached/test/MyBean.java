package com.primeton.wujun.memcached.test;

import java.io.Serializable;

public class MyBean implements Serializable {
	String name ;
	int age;
	public MyBean(String name,int age){
		this.name = name;
		this.age = age;
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
	@Override
	public String toString() {
		return name + "今年" + age + "岁了!";
	}
}
