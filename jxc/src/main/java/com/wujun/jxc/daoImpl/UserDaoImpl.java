package com.wujun.jxc.daoImpl;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;

import com.wujun.jxc.bean.User;
import com.wujun.jxc.dao.IUserDao;
import com.wujun.jxc.factory.DAOFactory;

public class UserDaoImpl implements IUserDao {
	private static Dao dao = DAOFactory.getDao();
	@Override
	public User queryByUsername(String username) {
		return dao.fetch(User.class,username);
	}

	@Override
	public List<User> queryByPager(Condition cnd, Pager pager) {
		return dao.query(User.class, cnd, pager);
	}

}
