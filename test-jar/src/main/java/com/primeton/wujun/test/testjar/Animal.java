package com.primeton.wujun.test.testjar;


public class Animal<T> {
	T user;
	public String say(){
		user = (T) new Person();
		return "Ho~!"+user.toString();
	}
	public static void main(String[] args) {
		Animal<Person> a = new Animal<Person>();
		System.out.println(a.say());
	}
}
