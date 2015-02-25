package com.wujun.jxc.service;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.User;

public interface IUserService {
	boolean login(String username,String password);
	List<User> query(Condition cnd,Pager pager);
	User queryByName(String name);
}
