package com.primeton.wujun.designpattern.lsp;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		Map map = new HashMap();
		p.doSomething(map);
		c.doSomething(map);
	}

}
