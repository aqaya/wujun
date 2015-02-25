package com.wujun.jxc.serviceImpl;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.Customer;
import com.wujun.jxc.dao.ICustomerDao;
import com.wujun.jxc.daoImpl.CustomerDaoImpl;
import com.wujun.jxc.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {
	private static ICustomerDao customerDao = new CustomerDaoImpl();
	@Override
	public List<Customer> query(Condition cnd, Pager pager) {
		return customerDao.queryByCndAndPager(cnd, pager);
	}

}
