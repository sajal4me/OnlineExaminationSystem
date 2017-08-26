package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CheckAnswer_UpdatePassDb;


public class CheckAnswer_UpdatePass extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("**Servlet**-CheckAnswer_UpdatePass");
		
		String answer=request.getParameter("recoveryAns");
		String email=(String)request.getParameter("recoveryEmail");
		boolean ind=false;
		
		CheckAnswer_UpdatePassDb caupDb=new CheckAnswer_UpdatePassDb();
		
			try {
				ind=caupDb.checkAns(answer,email);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		if(ind)
		{
			request.setAttribute("email", email);
			RequestDispatcher rD=request.getRequestDispatcher("JSP/ResetPassword.jsp");
			rD.forward(request, response);
		}
		else
		{
			response.sendRedirect("JSP/404error.jsp");
		}
		
	}

}
