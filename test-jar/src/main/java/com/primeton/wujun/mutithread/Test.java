package com.primeton.wujun.mutithread;

public class Test {
	public static void main(String[] args) {
		MyStack ms = new MyStack();
		ThreadA ta = new ThreadA(ms);
		ThreadB tb = new ThreadB(ms);
		ThreadC tc = new ThreadC(ms);
		new Thread(ta).start();
		new Thread(tb).start();
		new Thread(tc).start();
	}
}
