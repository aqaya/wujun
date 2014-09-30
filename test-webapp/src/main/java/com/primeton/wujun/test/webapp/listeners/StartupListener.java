package com.primeton.wujun.test.webapp.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
