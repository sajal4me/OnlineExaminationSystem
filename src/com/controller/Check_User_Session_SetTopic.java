package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Check_User_Session_SetTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Check_User_Session_SetTopic Servlet\n");
		
		HttpSession sess=request.getSession(false);
		String[] catsettopList= request.getParameterValues("catsettopList");
		request.setAttribute("catsettopList", catsettopList );
		
		String categoryName=request.getParameter("categoryName");
		sess.setAttribute("categoryName",categoryName);
		request.setAttribute("categoryName", categoryName);
		
		RequestDispatcher rd=request.getRequestDispatcher("JSP/userOnlineTestSetTopic.jsp");
		rd.forward(request,response);
		
		
	}

}
