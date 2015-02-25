package com.wujun.jxc.dao;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.Customer;

public interface ICustomerDao {
	Customer queryByID(int id);
	public List<Customer> queryByCndAndPager(Condition cnd, Pager pager);
	List<Customer> queryByName(String name, Condition cnd, Pager pager);
}
