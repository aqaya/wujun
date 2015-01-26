package com.wujun.jxc.daoImpl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Criteria;

import com.wujun.jxc.bean.Price;
import com.wujun.jxc.bean.Product;
import com.wujun.jxc.dao.IPriceDao;
import com.wujun.jxc.factory.DAOFactory;

public class PriceDaoImpl implements IPriceDao {
	private static Dao dao = DAOFactory.getDao();
	@Override
	public List<Price> queryByCndAndPager(Condition cnd, Pager pager) {
		List<Price> list = dao.query(Price.class, cnd, pager);
		return list;
	}

}
