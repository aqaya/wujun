package com.wujun.jxc.daoImpl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Criteria;

import com.wujun.jxc.bean.Product;
import com.wujun.jxc.dao.IProductDao;
import com.wujun.jxc.factory.DAOFactory;
import com.wujun.jxc.util.StringUtil;

public class ProductDAOImpl implements IProductDao {
	private static Dao dao = DAOFactory.getDao();
	@Override
	public List<Product> query(Condition cnd,Pager pager) {
		return dao.query(Product.class, cnd, pager);
	}
	@Override
	public List<Product> query(int pageIndex, int pageSize,
			String sortField, String sortOrder, String tiaoma, String huohao, String name) {
		Criteria cri = Cnd.cri();
		if("asc".equalsIgnoreCase(sortOrder)){
			cri.getOrderBy().asc(sortField);
		}else if("desc".equalsIgnoreCase(sortOrder)){
			cri.getOrderBy().desc(sortField);
		}
		if(!StringUtil.isNullOrEmpty(tiaoma)){
			cri.where().andLike("tiaoma", "%"+tiaoma+"%");
		}
		if(!StringUtil.isNullOrEmpty(huohao)){
			cri.where().andLike("huohao", "%"+huohao+"%");
		}
		if(!StringUtil.isNullOrEmpty(name)){
			cri.where().andLike("name", "%"+name+"%");
		}
		List<Product> list = dao.query(Product.class, cri, dao.createPager(pageIndex, pageSize));
		return list;
	}
	public void insert(Product p) {
		dao.insert(p);
	}
	@Override
	public void update(Product p) {
		dao.update(p);	
	}
	@Override
	public void delete(int id) {
		dao.delete(Product.class,id);
	}
	@Override
	public Product queryByID(int id) {
		return dao.fetch(Product.class, id);
	}

}
