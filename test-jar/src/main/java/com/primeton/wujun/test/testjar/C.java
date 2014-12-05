package com.primeton.wujun.test.testjar;

import java.io.UnsupportedEncodingException;


class C extends B{
	public static void main(String[] args) throws UnsupportedEncodingException {
		 String s = new String("�ķ�23�ķ�������3�򷢵�˵�����ÿ����ĺ����������54������34234������ͨ������fdf�ϰ��ķ�����ҷ��ȹ�2324".getBytes(),"utf-8");
		 System.out.println(new String(s.getBytes(),"gbk"));
	}
}

