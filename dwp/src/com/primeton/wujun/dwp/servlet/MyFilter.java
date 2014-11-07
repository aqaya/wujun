package com.primeton.wujun.dwp.servlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.primeton.wujun.dwp.util.WrapperResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		System.out.println("Before MyFilter!");
//		PrintWriter pw = response.getWriter();
//		
//		pw.print("1");
		chain.doFilter(request, response);
//		WrapperResponse wp =new  WrapperResponse((HttpServletResponse) response);
//		String content = wp.getContent();
//		System.out.println(content);
//		pw.print("2");
//		System.out.println("After MyFilter!");
		response.setContentType("text/html;charset=utf-8");
		WrapperResponse wp =new  WrapperResponse((HttpServletResponse) response);
		PrintWriter pw = wp.getWriter();
		chain.doFilter(request, wp);
		String content = wp.getContent();
		String newContent = content.replace("·¨ÂÖ¹¦", "Ä³¹¦");
		newContent = newContent.replace("ÌÔ±¦", "Ä³±¦");
		pw = response.getWriter();
		pw.print(newContent);
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
