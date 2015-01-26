package com.wujun.jxc.dao;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.Price;

public interface IPriceDao {
	List<Price> queryByCndAndPager(Condition cnd,Pager pager);
}
