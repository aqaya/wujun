package com.primeton.wujun.springtest.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class MainApp {
    public static void main(String[] args) {
 
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
 
        Person obj = (Person) context.getBean("person");
 
        obj.say();
    }
}

