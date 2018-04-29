package org.servletpractice.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "This is the simple servlet class", urlPatterns = { "/SimpleServletPath" },
			initParams= {@WebInitParam(name="defaultUserName",value="Nitasha Anand")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello from GET Method");
		PrintWriter writer=response.getWriter();
		writer.println("<h3>Hello in html</h3>");
		writer.println("Init parameter has default userName as "+getServletConfig().getInitParameter("defaultUserName"));
	}

}
