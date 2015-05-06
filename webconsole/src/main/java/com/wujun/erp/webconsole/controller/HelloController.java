package com.wujun.erp.webconsole.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {
	@RequestMapping("hello")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();  
       //添加模型数据 可以是任意的POJO对象  
       mv.addObject("message", "hello world！");  
       //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
       mv.setViewName("hello");  
       return mv;
	}

}
