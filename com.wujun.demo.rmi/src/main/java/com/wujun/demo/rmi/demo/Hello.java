package com.wujun.demo.rmi.demo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello(String name) throws RemoteException;
}


