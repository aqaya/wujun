package com.wujun.jxc.serviceImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.sql.Criteria;

import com.wujun.jxc.bean.Customer;
import com.wujun.jxc.bean.Price;
import com.wujun.jxc.dao.ICustomerDao;
import com.wujun.jxc.dao.IPriceDao;
import com.wujun.jxc.daoImpl.CustomerDaoImpl;
import com.wujun.jxc.daoImpl.PriceDaoImpl;
import com.wujun.jxc.factory.CountServiceFactory;
import com.wujun.jxc.factory.DAOFactory;
import com.wujun.jxc.service.ICountService;
import com.wujun.jxc.service.IPriceService;
import com.wujun.jxc.util.DataConversionUtil;

public class PriceServiceImpl implements IPriceService {
	private static IPriceDao priceDao = new PriceDaoImpl();
	private static ICustomerDao customerDao = new CustomerDaoImpl();
	private static Dao dao = DAOFactory.getDao();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> queryByProductID(int pid, int pageIndex, int pageSize) {
		Criteria cri = Cnd.cri();
		cri.where().andEquals("pid", pid);
		List<Price> list = priceDao.queryByCndAndPager(cri,dao.createPager(pageIndex, pageSize));
		int total = CountServiceFactory.getCountService().count(Price.class, cri);
		Map map = new HashMap<String, Object>();
		List resultList =  DataConversionUtil.fromObjListToMapList(list);
		for (Iterator iterator = resultList.iterator(); iterator.hasNext();) {
			Map m = (Map) iterator.next();
			int id = (Integer) m.get("cid");
			Customer c = customerDao.queryByID(id);
			m.put("name", c.getName());
		}
		map.put("data", resultList);
		map.put("total", total);
		return map;
	}

	@Override
	public Map<String, Object> queryByCustomerID(int cid, int pageIndex, int pageSize) {
		Criteria cri = Cnd.cri();
		cri.where().andEquals("cid", cid);
		List<Price> list = priceDao.queryByCndAndPager(cri, dao.createPager(pageIndex, pageSize));
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> queryCustomerPriceByCustomerID(int pid,
			int pageIndex, int pageSize) {
		Criteria cri = Cnd.cri();
		cri.where().andEquals("pid", pid);
		List<Price> list = priceDao.queryByCndAndPager(cri,dao.createPager(pageIndex, pageSize));
		int total = CountServiceFactory.getCountService().count(Price.class, cri);
		Map map = new HashMap<String, Object>();
		map.put("data",  DataConversionUtil.fromObjListToMapList(list));
		map.put("total", total);
		return map;
	}

	@Override
	public Map<String, Object> queryProductPriceByProductID(int pid,
			int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
}
