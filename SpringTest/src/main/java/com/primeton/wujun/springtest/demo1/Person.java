package com.primeton.wujun.springtest.demo1;

public class Person {
	int age;
	String name;
	Dog myDog;
	public Dog getMyDog() {
		return myDog;
	}
	public void setMyDog(Dog myDog) {
		this.myDog = myDog;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	void say(){
		
		System.out.println(this.name+"ΩÒƒÍ"+this.age+"ÀÍ¡À£°");
		myDog.speak();
	}
}
