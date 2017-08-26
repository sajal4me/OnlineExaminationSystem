package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserRecoveryDb;


public class UserRecovery extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String question="";
		UserRecoveryDb urDb=new UserRecoveryDb();
		String emailId=request.getParameter("recoveryEmail");
		System.out.println(emailId);
		
			  
				try {
					question=urDb.data(emailId);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		
		request.setAttribute("question", question);
		request.setAttribute("recoveryEmail", emailId);
		RequestDispatcher rD=request.getRequestDispatcher("JSP/DisplayQues_ResetPass.jsp");
		rD.forward(request, response);
		
	}

}
