package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Check_User_Session_UpdateProfileDb;
import com.model.StatusConstants;
import com.service.CheckParameters;


public class Check_User_Session_UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("**Servlet**-Check_User_Session_UpdateProfile");
		
		String updateDbStatus="";
		HttpSession sess=request.getSession(false);
		List<String> statusList=new ArrayList<String>();
		List<String> profileList=new LinkedList<String>();
		if(sess!=null)
		{
		String email=(String) sess.getAttribute("emailLoggedInUser");
		String name=request.getParameter("userName");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		String mobileNumber=request.getParameter("mobileNumber");
		
		
		CheckParameters checkData=new CheckParameters();
		String nameStatus=checkData.checkString(name);
		statusList.add(nameStatus);
		
		String passwordStatus=checkData.checkString(password);
		statusList.add(passwordStatus);
		
		String repasswordStatus=checkData.checkString(repassword);
		statusList.add(repasswordStatus);
		
		String mobileNumberStatus=checkData.checkString(mobileNumber);
		statusList.add(mobileNumberStatus);
		
		String mainStatus=checkData.checkStatus(statusList);
		
		if(mainStatus.equals(StatusConstants.SUCCESS) && password.equals(repassword))
		{
			
			profileList.add(name);
			profileList.add(password);
			profileList.add(mobileNumber);
			profileList.add(email);
			
			Check_User_Session_UpdateProfileDb updateProfile=new Check_User_Session_UpdateProfileDb();
			try {
				updateDbStatus=updateProfile.dataUpdate(profileList);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(updateDbStatus.equals(StatusConstants.SUCCESS))
			{
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/userDashboard.jsp");
				rd.forward(request, response);
			}
			
		}
		}
		else
		{
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/404error.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		
		
	}

}
