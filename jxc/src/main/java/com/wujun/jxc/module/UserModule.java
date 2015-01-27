package com.wujun.jxc.module;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.sql.Criteria;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.wujun.jxc.bean.Customer;
import com.wujun.jxc.bean.User;
import com.wujun.jxc.factory.CountServiceFactory;
import com.wujun.jxc.factory.DAOFactory;
import com.wujun.jxc.service.IUserService;
import com.wujun.jxc.serviceImpl.UserServiceImpl;
import com.wujun.jxc.util.DataConversionUtil;
import com.wujun.jxc.util.JSON;
import com.wujun.jxc.util.StringUtil;

@At("/user")
public class UserModule {
	private static Logger logger = Logger.getLogger(UserModule.class);
	private static IUserService us = new UserServiceImpl();
	private static Dao dao = DAOFactory.getDao();
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@At("/query")
	@Ok("raw:json")
	public String query(@Param("pageIndex")int pageIndex, 
					  @Param("pageSize")int pageSize,
					  @Param("username")String username,
					  @Param("name")String name,
					  @Param("minAge")int minAge,
					  @Param("maxAge")int maxAge,
					  HttpSession session){
		String curUserName = (String) session.getAttribute("username");
		if (StringUtil.isNullOrEmpty(curUserName)) {
			return "";
		}
		User curUer = us.queryByName(curUserName);
		if (!User.YES.equalsIgnoreCase(curUer.getIsadmin())) {
			return "";
		}
		Criteria cri = Cnd.cri();
		if (minAge != 0) {
			cri.where().andGTE("age", minAge);
		}
		if(maxAge != 0){
			cri.where().andLTE("age", maxAge);
		}
		if(!StringUtil.isNullOrEmpty(name)){
			cri.where().andLike("name", "%"+ name +"%");
		}
		if(!StringUtil.isNullOrEmpty(username)){
			cri.where().andLike("name", "%"+ username +"%");
		}
		List<User> list = us.query(cri,dao.createPager(pageIndex + 1, pageSize));
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			user.setPassword("*");
		}
		int total = CountServiceFactory.getCountService().count(User.class, cri);
		Map map = new HashMap<String, Object>();
		List resultList =  DataConversionUtil.fromObjListToMapList(list);
		map.put("data", resultList);
		map.put("total", total);
		return JSON.Encode(map);
	}
}
