package com.wujun.jxc.service;

import java.util.Map;

public interface IPriceService {
	public Map<String, Object> queryByProductID(int pid,int pageIndex, int pageSize);
	public Map<String, Object> queryByCustomerID(int cid,int pageIndex, int pageSize);
}
