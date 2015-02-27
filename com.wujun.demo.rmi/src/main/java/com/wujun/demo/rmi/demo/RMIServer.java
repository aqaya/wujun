package com.wujun.demo.rmi.demo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

	public static void main(String[] args) {

		Registry registry = null;
		try {
			registry = LocateRegistry.getRegistry();// 从本地拿
			registry.list();
			System.out.println("Register the exist server!");// 说明已经有RMIService了不需要在创建一个新的了
		} catch (RemoteException re) {
			try {
				int port = 33333;// RMIService监听的端口，自己指定！
				registry = LocateRegistry.createRegistry(port);// 在本地创建
				System.out.println("Create Registry Server!"); // 创建了一个新的RMIService
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			Hello helloServer = new HelloImpl();
			registry.bind("HelloServer", helloServer); // HelloServer就是对外暴露出的名称
			System.out.println("HelloServer server start!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(300000);// 由于是测试用的因此写在了Main方法中如果正常main执行完毕服务会被关闭，因此需要sleep一会，正常开发过程中这个部分是启动一个新的线程因此不必担心这个问题
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
