package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Check_Admin_Session_DeleteAnyDb;
import com.model.StatusConstants;


public class Check_Admin_Session_DeleteAny extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status="";
		System.out.println("****Servlet*****Check_Admin_Session_DeleteAnyDb");
		
		String category=request.getParameter("category");
		String deleteIndex=request.getParameter("deleteIndex");
		String optionSelected=request.getParameter("delete");
		
		System.out.println(category+"  "+deleteIndex+"  "+optionSelected);
		
		Check_Admin_Session_DeleteAnyDb delete=new Check_Admin_Session_DeleteAnyDb();
		try {
			status=delete.data(category,deleteIndex,optionSelected);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status.equals(StatusConstants.SUCCESS))
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminDashboard.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/404error.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
