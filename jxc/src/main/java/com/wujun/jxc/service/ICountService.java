package com.wujun.jxc.service;

import org.nutz.dao.Condition;

public interface ICountService {
	int count(Class clz);
	int count(Class clz,Condition cnd);
}
