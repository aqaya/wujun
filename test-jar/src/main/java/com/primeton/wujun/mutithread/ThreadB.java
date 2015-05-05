package com.primeton.wujun.mutithread;


public class ThreadB implements Runnable {

	private MyStack ms;
	public void run() {
		System.out.println("B:pop");
		int i = 10;
		while(i-- > 0){
			try {
				ms.pop();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	ThreadB(MyStack ms){
		this.ms = ms;
	}

}
