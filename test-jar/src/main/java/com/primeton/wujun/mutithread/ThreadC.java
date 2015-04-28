package com.primeton.wujun.mutithread;


public class ThreadC implements Runnable {

	private MyStack ms;
	public void run() {
		int i = 10;
		while(i-- > 0){
			try {
				ms.pop();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	ThreadC(MyStack ms){
		this.ms = ms;
	}

}
