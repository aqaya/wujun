package com.wujun.jxc.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nutz.lang.Strings;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.RequestPath;

/**
 * Servlet Filter implementation class Login
 */
public class Login implements Filter {
    private static final String IGNORE = "^.+\\.(png|gif|jpg|js|css|jpeg|swf|ico)$";
    private Pattern ignorePtn;
	public void init(FilterConfig config) throws ServletException {
		String regx = Strings.sNull(config.getInitParameter("ignore"), IGNORE);
		if (!"null".equalsIgnoreCase(regx)) {
			ignorePtn = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		}
	}
    /**
     * Default constructor. 
     */
    public Login() {
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if(session != null && session.getAttribute("username")!=null){
			chain.doFilter(request, response);
		}else{
			//如果是登录请求或登录界面，则忽略，否则回到登录界面
			RequestPath path = Mvcs.getRequestPathObject(req);
			String url = path.getUrl();
			if (!url.endsWith("user/login") && !url.endsWith("login.html") && !ignorePtn.matcher(url).find()) {
				String username = (String) session.getAttribute("username");	
				if(username!=null && !username.equals("")){
					chain.doFilter(request, response);
				}else{
					String contextPath = req.getContextPath();
					((HttpServletResponse)response).sendRedirect(contextPath + "/login/login.html");
					//request.getRequestDispatcher("/login/login.html").forward(request, response);;
				}
			}else{
				chain.doFilter(request, response);
			}
		}
	}
}
