package com.primeton.wujun.designpattern.lsp;

import java.util.HashMap;


public class Child extends Parent{
	public void doSomething(HashMap map) {
		System.out.println("Child!");
	}
}
