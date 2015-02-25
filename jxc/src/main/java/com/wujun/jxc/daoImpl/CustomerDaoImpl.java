package com.wujun.jxc.daoImpl;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.Customer;
import com.wujun.jxc.bean.Price;
import com.wujun.jxc.bean.Product;
import com.wujun.jxc.dao.ICustomerDao;
import com.wujun.jxc.factory.DAOFactory;

public class CustomerDaoImpl implements ICustomerDao {

	private static Dao dao = DAOFactory.getDao();
	@Override
	public Customer queryByID(int id) {
		return dao.fetch(Customer.class, id);
	}
	@Override
	public List<Customer> queryByName(String name,Condition cnd, Pager pager) {
		return dao.query(Customer.class,cnd,pager);
	}
	@Override
	public List<Customer> queryByCndAndPager(Condition cnd, Pager pager) {
		return dao.query(Customer.class, cnd,pager);
	}

}
