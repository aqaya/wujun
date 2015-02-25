package com.wujun.jxc.dao;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.Product;

public interface IProductDao {
	List<Product> query(Condition cnd, Pager pager);

	List<Product> query(int pageIndex, int pageSize, String sortField,
			String sortOrder, String tiaoma, String huohao, String name);
	Product queryByID(int id);
	void insert(Product p);
	void update(Product p);
	void delete(int id);
}
