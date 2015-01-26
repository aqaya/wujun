package com.wujun.jxc.module;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.nutz.lang.Strings;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.wujun.jxc.service.IUserService;
import com.wujun.jxc.serviceImpl.UserServiceImpl;

@At("/user")
public class UserModule {
	private static Logger logger = Logger.getLogger(UserModule.class);
	private static IUserService us = new UserServiceImpl();
	
	//@AdaptBy(type=JsonAdaptor.class)
	@At("/login")
	@Ok("raw:json")
	public boolean login(@Param("username")String username, @Param("password")String password, HttpSession session){
		if(Strings.isBlank(username) || Strings.isBlank(password)){
			return false;
		}else{
			boolean isLogin = us.login(username.trim(), password);
			if(isLogin){
				logger.log(Level.INFO, "[用户："+username+"]登陆成功！");
				session.setAttribute("username", username);
				return true;
			}
			return false;
		}
	}
	
	@At("/logout")
	public void logout(HttpSession session){
		String username = (String) session.getAttribute("username");
		logger.log(Level.DEBUG, "[用户："+username+"]退出登陆！");
		session.invalidate();
	}
}
