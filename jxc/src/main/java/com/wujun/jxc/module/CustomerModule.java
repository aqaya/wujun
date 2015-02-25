package com.wujun.jxc.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.sql.Criteria;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.wujun.jxc.bean.Customer;
import com.wujun.jxc.factory.CountServiceFactory;
import com.wujun.jxc.factory.DAOFactory;
import com.wujun.jxc.service.ICustomerService;
import com.wujun.jxc.serviceImpl.CustomerServiceImpl;
import com.wujun.jxc.util.DataConversionUtil;
import com.wujun.jxc.util.JSON;

@At("/customer")
public class CustomerModule {
	private static Logger logger = Logger.getLogger(UserModule.class);
	private static ICustomerService customerService = new CustomerServiceImpl();
	private static Dao dao = DAOFactory.getDao();
	@SuppressWarnings("unchecked")
	@At("/query")
	@Ok("raw:json")
	public String queryByProductID(@Param("pageIndex")int pageIndex, 
						 		   @Param("pageSize")int pageSize){
		Criteria cri = Cnd.cri();
		List<Customer> list = customerService.query(cri, dao.createPager(pageIndex+1, pageSize));
		int total = CountServiceFactory.getCountService().count(Customer.class, cri);
		Map map = new HashMap<String, Object>();
		map.put("data", DataConversionUtil.fromObjListToMapList(list));
		map.put("total", total);
		return JSON.Encode(map);
	}
}
