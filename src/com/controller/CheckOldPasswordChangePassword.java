package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CheckOldPasswordChangePasswordDb;
import com.model.StatusConstants;


public class CheckOldPasswordChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status="";
		List<String> parameterList=new LinkedList<String>();
		HttpSession sess=request.getSession(false);
		if(sess!=null)
		{
		String currentPassword=request.getParameter("currentPassword");
		String newPassword=request.getParameter("newPassword");
		String renewPassword=request.getParameter("renewPassword");
		String email=(String) sess.getAttribute("emailLoggedInUser");
		
		parameterList.add(currentPassword);
		parameterList.add(newPassword);
		parameterList.add(renewPassword);
		parameterList.add(email);
		
		CheckOldPasswordChangePasswordDb updatePass=new CheckOldPasswordChangePasswordDb();
		try {
			status=updatePass.data(parameterList);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status.equals(StatusConstants.SUCCESS))
		{
			ServletContext context=getServletContext();
			
			RequestDispatcher rd=context.getRequestDispatcher("/FetchSecurityQuestion");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Reaching Here");
			ServletContext context=getServletContext();
			RequestDispatcher rd=context.getRequestDispatcher("/JSP/userDashboardChangePassword.jsp");
			rd.forward(request, response);
		}
		
		
		}
		
	}

}
