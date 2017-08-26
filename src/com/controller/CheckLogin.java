package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context= getServletContext();
   	 
			
		
		System.out.println("**Servlet**-CheckLoginServlet");
		String saveFeedback="";
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
	
//		saveFeedback=(String)  session.getParameter("feedback");
//		
//		String eMailId=request.getParameter("email");
//		System.out.println(eMailId+" "+saveFeedback);
//		if(saveFeedback!=null)
//		{
//		session.setAttribute("feedBack",saveFeedback);
//		String userEmail=(String) session.getAttribute("emailLoggedInUser");
//		System.out.println(userEmail);
//		
//	
//		}
		if(session!=null)
		{
		RequestDispatcher rd=context.getRequestDispatcher("/JSP/userDashboard.jsp");
		rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd= context.getRequestDispatcher("/FetchSecurityQuestion");
			rd.forward(request, response);
		
		}
	    
		
		
		
		
		
	}

}
