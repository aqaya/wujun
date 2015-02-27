package com.wujun.demo.rmi.demo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

	public static void main(String[] args) {
		try {
			String hostName = "localhost";// RMIService的地址这里都是在本地执行
			int port = 33333;// RMIService监听的端口
			Registry registry = LocateRegistry.getRegistry(hostName, port);
			Hello hello = (Hello) registry.lookup("HelloServer");// RMIServer注册时暴露出来的名称
			String message = hello.sayHello("ender");
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
