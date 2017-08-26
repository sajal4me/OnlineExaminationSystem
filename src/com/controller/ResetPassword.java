package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ResetPasswordInDb;


public class ResetPassword extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("**servlet**-ResetPassword");
		String pass=request.getParameter("password");
		String repass=request.getParameter("repassword");
		String email=request.getParameter("email");
		int rowEffected=0;
		if(pass.equals(repass))
		{
			ResetPasswordInDb rpDb=new ResetPasswordInDb();
			
				try {
					rowEffected=rpDb.updatePass(pass,email);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} //if close
		else
		{
			response.sendRedirect("JSP/404error.jsp");
		}
			System.out.println(rowEffected);
			if(rowEffected==1)
			{
				RequestDispatcher rD=request.getRequestDispatcher("FetchSecurityQuestion");
				rD.forward(request, response);
			}
			else
			{
				response.sendRedirect("JSP/404error.jsp");
			}
				
		
		
	}

}
