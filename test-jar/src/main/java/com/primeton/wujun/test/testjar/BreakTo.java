package com.primeton.wujun.test.testjar;

import java.math.BigInteger;

public class BreakTo {

	public static void main(String[] args) {
		// ok:
		// for(int i=0;i<10;i++) {
		// for(int j=0;j<10;j++) {
		// System.out.println("i=" + i + ",j=" + j);
		// if(j == 5) break ok;
		// }
		// }
		// System.out.println("= = !");
		// ======================
		long a = Long.MAX_VALUE;
		long b = Long.MAX_VALUE;
		long sum = a + b;
		System.out.println("a=" + a + ",b=" + b + ",sum=" + sum);
		BigInteger bi = new BigInteger("a");
		System.out.println(bi);
	}

}
