package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.StatusConstants;
import com.model.getFeedbackDb;


public class getFeedback extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status="";
		HttpSession sess=request.getSession(false);
		getFeedbackDb getFeedbackDbObj= new getFeedbackDb();
		String getFeedback=request.getParameter("getFeedback");
		String email = (String) sess.getAttribute("emailLoggedInUser");
		Date d1 = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String formattedDate = df.format(d1);
		System.out.println(formattedDate);
		if(getFeedback.length()>0)
		{
			
				try {
					status=getFeedbackDbObj.saveFeedbackInDb(getFeedback,email,formattedDate);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(status.equals(StatusConstants.SUCCESS))
			{
			RequestDispatcher rd=request.getRequestDispatcher("OnlineExamination_LoggedIn.jsp");
			rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("404error.jsp");
			}
		}

		
		
	}

}
