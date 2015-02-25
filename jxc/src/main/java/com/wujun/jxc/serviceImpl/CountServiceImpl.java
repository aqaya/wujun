package com.wujun.jxc.serviceImpl;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;

import com.wujun.jxc.factory.DAOFactory;
import com.wujun.jxc.service.ICountService;

public class CountServiceImpl implements ICountService {
	private static Dao dao = DAOFactory.getDao();
	@Override
	public int count(Class clz) {
		return dao.count(clz);
	}
	@Override
	public int count(Class clz, Condition cnd) {
		return dao.count(clz,cnd);
	}

}
