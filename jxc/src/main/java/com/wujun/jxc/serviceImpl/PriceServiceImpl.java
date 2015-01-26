package com.wujun.jxc.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.sql.Criteria;

import com.wujun.jxc.bean.Price;
import com.wujun.jxc.dao.IPriceDao;
import com.wujun.jxc.daoImpl.PriceDaoImpl;
import com.wujun.jxc.factory.DAOFactory;
import com.wujun.jxc.service.ICountService;
import com.wujun.jxc.service.IPriceService;
import com.wujun.jxc.util.DataConversionUtil;

public class PriceServiceImpl implements IPriceService {
	private static IPriceDao priceDao = new PriceDaoImpl();
	private static Dao dao = DAOFactory.getDao();
	private static ICountService cs = new CountServiceImpl();
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryByProductID(int pid, int pageIndex, int pageSize) {
		Criteria cri = Cnd.cri();
		cri.where().andEquals("pid", pid);
		List<Price> list = priceDao.queryByCndAndPager(cri,dao.createPager(pageIndex, pageSize));
		int total = cs.count(Price.class, cri);
		Map map = new HashMap<String, Object>();
		map.put("data",  DataConversionUtil.fromObjListToMapList(list));
		map.put("total", total);
		return null;
	}

	@Override
	public Map<String, Object> queryByCustomerID(int cid, int pageIndex, int pageSize) {
		Criteria cri = Cnd.cri();
		cri.where().andEquals("cid", cid);
		List<Price> list = priceDao.queryByCndAndPager(cri, dao.createPager(pageIndex, pageSize));
		return null;
	}

}
