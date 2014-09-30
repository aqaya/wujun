package com.primeton.wujun.j2se.reflect;

import java.lang.reflect.Field;

public class ClassInfo {

	public static void main(String[] args) {
		Person p = new Person();
		Class clazz = p.getClass();
		Field fields[] = clazz.getDeclaredFields();
		for(Field f : fields){
			System.out.print(f.getName()+" " );
		}
	}

}

class Person{
	private int age;
	public String name;
	public void setAge(int age){
		this.age = age;
	}
 }
