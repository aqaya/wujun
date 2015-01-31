package com.wujun.jxc.module;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.wujun.jxc.bean.Product;
import com.wujun.jxc.service.IProductService;
import com.wujun.jxc.serviceImpl.ProductServiceImpl;
import com.wujun.jxc.util.DataConversionUtil;
import com.wujun.jxc.util.JSON;

@At("/product")
public class ProductModule {
	private static Logger logger = Logger.getLogger(UserModule.class);
	private static IProductService ps = new ProductServiceImpl();
	@SuppressWarnings("rawtypes")
	@At("/query")
	@Ok("raw")
	public String query(@Param("pageIndex")int pageIndex, 
						 @Param("pageSize")int pageSize, 
						 @Param("sortField")String sortField,
						 @Param("sortOrder")String sortOrder,
						 @Param("tiaoma")String tiaoma,
						 @Param("huohao")String huohao,
						 @Param("name")String name){
		Map map = ps.query(pageIndex + 1, pageSize, sortField, sortOrder ,tiaoma, huohao, name);
		return JSON.Encode(map);
	}
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@At("/save")
	@Ok("raw")
	public void save(@Param("data")String data) throws InstantiationException, IllegalAccessException{
		List<Map> list = (List) JSON.Decode(data);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Map row = (Map) iterator.next();
			String state = row.get("_state") != null ? row.get("_state")
					.toString() : "";
			if (state.equals("added")) // 新增：id为空，或_state为added
			{	
				Product product = (Product) DataConversionUtil.mapToEntity(Product.class, row);
				ps.insert(product);
			}
			if (state.equals("removed") || state.equals("deleted")) {
				int id = (Integer) row.get("id");
				ps.delete(id);
			} else if (state.equals("modified") || state.equals("")){ // 更新：_state为空，或modified
				Product product = (Product) DataConversionUtil.mapToEntity(Product.class, row);
				ps.update(product);
			}
		}
	}
	
	@At("/churuku")
	@Ok("raw")
	public boolean save(@Param("id")int id,@Param("num")float num,@Param("op")String op){
		Product p = ps.queryByID(id);
		if("in".equals(op)){
			p.setKucun(p.getKucun() + num);
		}else{
			if(p.getKucun() < num)
				return false;
			p.setKucun(p.getKucun() - num);
			p.setXiaoliang(p.getXiaoliang() + num);
		}
		ps.update(p);
		return true;
	}
	
}
