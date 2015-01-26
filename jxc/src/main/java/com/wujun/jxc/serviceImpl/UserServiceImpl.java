package com.wujun.jxc.serviceImpl;

import com.wujun.jxc.bean.User;
import com.wujun.jxc.dao.IUserDao;
import com.wujun.jxc.daoImpl.UserDaoImpl;
import com.wujun.jxc.service.IUserService;

public class UserServiceImpl implements IUserService {
	private static IUserDao ud = new UserDaoImpl();
	@Override
	public boolean login(String username, String password) {
		User user = ud.queryByUsername(username);
		if(user!=null && password.equals(user.getPassword())){
			return true;
		}
		return false;
	}

}