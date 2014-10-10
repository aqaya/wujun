package com.primeton.wujun.test.webapp.listeners;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
public class StartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
	ServletContext sc = null;
    public StartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletConfig sc = new ServletConfig() {
			
			public String getServletName() {
				return null;
			}
			
			public ServletContext getServletContext() {
				return null;
			}
			
			public Enumeration<String> getInitParameterNames() {
				return null;
			}
			
			public String getInitParameter(String arg0) {
				return null;
			}
		};
    	this.sc = sce.getServletContext();
    	String username = (String) sc.getInitParameter("username");
    	System.out.println("system startup!");
    	System.out.println("username:"+username);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	if (this.sc!=null) {
			sc =null;
		}
    }
	
}
