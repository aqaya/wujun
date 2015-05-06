package com.wujun.jxc.factory;

import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DAOFactory {
	private static Ioc ioc;
	public static Dao getDao() {
		
	    if (ioc == null){
	    	synchronized (DAOFactory.class) {
	    		if (ioc == null){
	    			ioc = new NutIoc(new JsonLoader("datasource2.json"));
	    		}
//	    		if (ioc == null){
//	    			ioc = new NutIoc(new JsonLoader("datasource.json"));
//	    		}
			}
	    }   
	    return ioc.get(Dao.class);
	}
}
