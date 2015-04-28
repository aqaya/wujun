package com.wujun.demo.rmi.demo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject  implements Hello, Serializable {

	protected HelloImpl() throws RemoteException {
		super();
	}

	public String sayHello(String name) throws RemoteException {
		System.out.println("---------被调用！----------");
		return "Hello,"+name+"--!";
	}

}
