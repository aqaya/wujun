package com.wujun.jxc.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.Product;
import com.wujun.jxc.dao.IProductDao;
import com.wujun.jxc.daoImpl.ProductDAOImpl;
import com.wujun.jxc.service.ICountService;
import com.wujun.jxc.service.IProductService;
import com.wujun.jxc.util.DataConversionUtil;

public class ProductServiceImpl implements IProductService {
	private static IProductDao pDao = new ProductDAOImpl();
	private static ICountService cs = new CountServiceImpl();
	@Override
	public List<Product> query(Condition cnd, Pager pager) {
		return pDao.query(cnd, pager);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map query(int pageIndex, int pageSize,
			String sortField, String sortOrder, String tiaoma, String huohao, String name) {
		List<Product> list = pDao.query(pageIndex, pageSize, sortField, sortOrder,tiaoma,huohao,name);
		Map map = new HashMap<>();
		map.put("data", DataConversionUtil.fromObjListToMapList(list));
		map.put("total", cs.count(Product.class));
		return map;
	}
	public Product queryByID(int id){
		return pDao.queryByID(id);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(Product p) {
		pDao.insert(p);
	}
	
	public void update(Product p){
		pDao.update(p);
	}
	@Override
	public void delete(int id) {
		pDao.delete(id);
		
	}
}
