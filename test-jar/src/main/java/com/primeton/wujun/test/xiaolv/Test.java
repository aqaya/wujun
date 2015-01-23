package com.primeton.wujun.test.xiaolv;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		List list = new ArrayList<String>();
		long begin = System.currentTimeMillis();   
		for (int i = 0; i < 10000000; i++) {
			list.add("d"+new Random().nextDouble());
		}
		long end = System.currentTimeMillis();
		System.out.println("一:" + (end - begin));
		
		
		begin = System.currentTimeMillis();   
		for (int i = 0; i < list.size(); i++) {
			//System.out.println(i);
		}
		end = System.currentTimeMillis();
		System.out.println("二:" + (end - begin));
	}

}
