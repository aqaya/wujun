package com.wujun.jxc.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wujun.jxc.bean.User;

public interface IAuthCheck {
	boolean isAdmin(User user);
	boolean isAdmin(String username);
	boolean isAdmin(HttpSession session);
	boolean isAdmin(HttpServletRequest req);
}
