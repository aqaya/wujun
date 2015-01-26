package com.wujun.jxc.dao;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.User;

public interface IUserDao {
	User queryByUsername(String username);
	List<User> queryByPager(Condition cnd, Pager pc);
}
