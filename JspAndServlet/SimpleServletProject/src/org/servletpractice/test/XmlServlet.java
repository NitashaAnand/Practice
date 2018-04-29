package org.servletpractice.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello xml servlet called");
		/*PrintWriter writer=response.getWriter();
		writer.println("<h3>Hello in html</h3>");*/
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		ServletContext context=request.getServletContext();
		String userName=request.getParameter("userName");
		if(userName!="" && userName!=null) {
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}
		/*String userId=request.getParameter("userId");*/
		/*out.println("Hello!User!");*/
		/*out.println("Hello! "+userName+" with id:"+userId);*/
		out.println("Hello! GET method called for "+userName);
		out.println("Session parameter has userName as "+ (String)session.getAttribute("savedUserName"));
		out.println("Context parameter has userName as "+ (String)context.getAttribute("savedUserName"));
		out.println("Init parameter has default userName as "+getServletConfig().getInitParameter("defaultName"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello xml post servlet called");
		/*PrintWriter writer=response.getWriter();
		writer.println("<h3>Hello in html</h3>");*/
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");
		/*String userId=request.getParameter("userId");*/
		/*out.println("Hello!User!");*/
		/*out.println("Hello! "+userName+" with id:"+userId);*/
		String fullName=request.getParameter("fullName");
		out.println("Hello! POST method called for "+userName+"!We know your full name is:"+fullName);
		String prof=request.getParameter("prof");
		out.println("You are a "+prof);
		String[] location=request.getParameterValues("location");
		out.println("You are at "+location.length+ " places");
		for(int i=0;i<location.length;i++) {
			out.println(location[i]);
		}
	}

}
