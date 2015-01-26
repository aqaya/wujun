package com.wujun.jxc.service;

import java.util.List;
import java.util.Map;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.Product;

public interface IProductService {
	List<Product> query(Condition cnd, Pager pager);

	Map query(int pageIndex, int pageSize, String sortField,
			String sortOrder, String tiaoma, String huohao, String name);
	void insert(Product p);
	void update(Product p);
	void delete(int id);
	Product queryByID(int id);
}
