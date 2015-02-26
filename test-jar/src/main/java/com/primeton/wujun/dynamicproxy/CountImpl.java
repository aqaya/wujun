package com.primeton.wujun.dynamicproxy;

public class CountImpl implements ICount {

	public void queryCount() {
		System.out.println("queryCount");
	}

	public void updateCount() {
		System.out.println("updateCount");
	}

}
