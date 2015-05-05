package com.primeton.wujun.mutithread;

import java.util.Random;

public class ThreadA implements Runnable {
	private MyStack ms;
	public void run() {
		int i = 10;
		while(i-- > 0){
			ms.push(new String("ss"+new Random().nextDouble()));
		}
	}
	ThreadA(MyStack ms){
		this.ms = ms;
	}
}
