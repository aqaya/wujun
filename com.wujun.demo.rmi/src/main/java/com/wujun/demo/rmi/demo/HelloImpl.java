package com.wujun.demo.rmi.demo;

import java.io.Serializable;
import java.rmi.RemoteException;

public class HelloImpl implements Hello, Serializable {

	public String sayHello(String name) throws RemoteException {
		return "Hello,"+name+"!";
	}

}
