package com.wujun.jxc.module;

import java.util.Map;

import org.apache.log4j.Logger;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.wujun.jxc.service.IPriceService;
import com.wujun.jxc.serviceImpl.PriceServiceImpl;
import com.wujun.jxc.util.JSON;

@At("/price")
public class PriceModule {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(UserModule.class);
	private static IPriceService ps = new PriceServiceImpl();
	@At("/byproductid")
	@Ok("raw:json")
	public String queryByProductID(@Param("pageIndex")int pageIndex, 
						 @Param("pageSize")int pageSize,
						 @Param("pid")int pid){
		Map<String, Object> map = ps.queryByProductID(pid, pageIndex + 1, pageSize);
		return JSON.Encode(map);
	}
	@At("/bycustomerid")
	@Ok("raw:json")
	public String queryByCustomerID(@Param("pageIndex")int pageIndex, 
						 @Param("pageSize")int pageSize,
						 @Param("pid")int cid){
		Map<String, Object> map = ps.queryByCustomerID(cid, pageIndex + 1, pageSize);
		return JSON.Encode(map);
	}
}
