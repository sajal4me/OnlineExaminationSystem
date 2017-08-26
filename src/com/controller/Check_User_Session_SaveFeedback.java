package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Check_User_Session_SaveFeedbackDb;
import com.model.StatusConstants;


public class Check_User_Session_SaveFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession(false);
		if(sess!=null)
		{
			String feedback=request.getParameter("feedback");
			String email=(String) sess.getAttribute("emailLoggedInUser");
			Check_User_Session_SaveFeedbackDb save=new Check_User_Session_SaveFeedbackDb();
			String status="";
			try {
				status = save.saveFeedback(email, feedback);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(status.equals(StatusConstants.SUCCESS))
			{
				ServletContext context=getServletContext();
				RequestDispatcher rd=request.getRequestDispatcher("/JSP/userDashboard.jsp");
				rd.forward(request,response);
			}
		}
		
		else
		{
			ServletContext context=getServletContext();
			RequestDispatcher rd=request.getRequestDispatcher("/JSP/404error.jsp");
			rd.forward(request,response);
		}
		
		
	}

}
