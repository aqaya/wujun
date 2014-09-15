package com.primeton.wujun.test.webapp.persist;

import com.primeton.wujun.test.testjar.Animal;

public class Person {
	public String sayHello(){
		return "Hello!";
	}
	public String makeAnimalSay(){
		return new Animal().say();
	}
}
