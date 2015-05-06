package com.wujun.jxc.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wujun.jxc.bean.User;
import com.wujun.jxc.service.IUserService;
import com.wujun.jxc.serviceImpl.UserServiceImpl;

public class AuthCheckImpl implements IAuthCheck {
	private static IUserService us = new UserServiceImpl();
	@Override
	public boolean isAdmin(User user) {
		return (user!=null) && "Y".equalsIgnoreCase(user.getIsadmin());
	}

	@Override
	public boolean isAdmin(String username) {
		return "Y".equalsIgnoreCase(us.queryByName(username).getIsadmin());
	}

	@Override
	public boolean isAdmin(HttpSession session) {
		return isAdmin(session.getAttribute("username").toString()) || isAdmin((User)session.getAttribute("user"));
	}

	@Override
	public boolean isAdmin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return isAdmin(session);
	}
}
