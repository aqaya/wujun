package com.wujun.jxc.factory;

import com.wujun.jxc.service.ICountService;
import com.wujun.jxc.serviceImpl.CountServiceImpl;

public class CountServiceFactory {
	private static ICountService cs;
	public static ICountService getCountService() {
	    if (cs == null){
	    	synchronized (CountServiceFactory.class) {
	    		if (cs == null){
	    			cs = new CountServiceImpl();
	    		}
			}
	    }   
	    return cs;
	}
}
