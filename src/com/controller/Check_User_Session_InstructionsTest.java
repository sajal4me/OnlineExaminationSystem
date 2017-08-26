package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Check_User_Session_InstructionsTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("**Servlet**-Check_User_Session_InstructionsTest");
		String subcatName=request.getParameter("subcategory");
		request.setAttribute("subcatName", subcatName);
		if(subcatName.equalsIgnoreCase("set"))
		{
			String setId=request.getParameter("setId");
			request.setAttribute("setId", setId);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/userOnlineTestInstructions.jsp");
			rd.forward(request, response);
		}
		else if(subcatName.equalsIgnoreCase("topic"))
		{
			String topicId=request.getParameter("topicId");
			request.setAttribute("topicId", topicId);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/userOnlineTestInstructions.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/404error.jsp");
			rd.forward(request, response);
		}
	}

}
