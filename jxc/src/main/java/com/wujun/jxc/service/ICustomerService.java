package com.wujun.jxc.service;

import java.util.List;
import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;
import com.wujun.jxc.bean.Customer;

public interface ICustomerService {
	List<Customer> query(Condition cnd,Pager pager);
}
