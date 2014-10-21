package com.primeton.wujun.test.webapp.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse res){
		try {
			BufferedReader  reader = req.getReader();
			String line;
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine())!=null){
				sb.append(line);
			}
			sb.append("\n=====================\n");
			reader =req.getReader();
			while((line = reader.readLine())!=null){
				sb.append(line);
			}
			
			PrintWriter pw = res.getWriter();
			pw.write(sb.toString());
			pw.write("hello");
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
