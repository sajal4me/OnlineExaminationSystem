package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.FetchUserName;
import com.model.SignInDb;
import com.model.StatusConstants;
import com.model.UserDAO;
import com.model.UserDTO;
import com.service.CheckParameters;

public class SignIn extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status="";
		//Storing status of All Parameters.
		List<String> statusList=new ArrayList<String>();
		
		System.out.println("SignIn Servlet");
		
		boolean b=false;String userName="";
		String email=request.getParameter("email");
		//System.out.println(email);
		String pass=request.getParameter("pass");
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
	
		CheckParameters check=new CheckParameters();
		
		
		statusList.add(check.checkString(email));
		statusList.add(check.checkString(pass));
		
		status=check.checkStatus(statusList);
		System.out.println("Status:"+status);
		if(status.equals(StatusConstants.SUCCESS))
		{
		
		SignInDb sid=  new SignInDb();
		try {
				// b is boolean value checking whether data is there in Db or not.
			 b=sid.data(email, pass);
			 System.out.println("b:"+b);
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                  
		if (b)
		{
			FetchUserName fetchName=new FetchUserName();
			
				 try {
					userName=fetchName.data(email);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
				 
			
			
			HttpSession sess=request.getSession(true);
			sess.setAttribute("userName", userName);
			sess.setAttribute("emailLoggedInUser", email);
			RequestDispatcher rd=request.getRequestDispatcher("CheckLogin.Exam_Filter");
			rd.forward(request, response);
		}
		
		else 
		{
			ServletContext context= getServletContext();
	    	 
				RequestDispatcher rd= context.getRequestDispatcher("/FetchSecurityQuestion");
				rd.forward(request, response);
			
		}
		}
		else
		{
			ServletContext context= getServletContext();
	    	 System.out.println("Reaching Here");
				RequestDispatcher rd= context.getRequestDispatcher("/JSP/404error.jsp");
				rd.forward(request, response);
		}
			
	}

}
