package com.primeton.wujun.mutithread;

import java.util.ArrayList;
import java.util.List;

public class MyStack {  
    private List<String> list = new ArrayList<String>();  
  
    public synchronized void push(String value) {  
        synchronized (this) {  
            list.add(value);  
            System.out.println("add:"+value);
            notify();  
        }  
    }  
  
    public synchronized String pop() throws InterruptedException {  
        synchronized (this) {  
            if (list.size() <= 0) {  
                wait();  
            }  
            String s = list.remove(list.size() - 1);
            System.out.println("remove:" + s);
            return s;
        }  
    }  
}
