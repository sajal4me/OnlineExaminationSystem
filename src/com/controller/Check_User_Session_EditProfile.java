package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Check_User_Session_EditProfileDb;


public class Check_User_Session_EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("\n**Servlet**-Check_User_Session_EditProfile");
		String email="";
		HttpSession sess=request.getSession(false);
		List<String> profileData=new LinkedList<String>();
		if(sess!=null)
		{
			 email=(String) sess.getAttribute("emailLoggedInUser");
			 Check_User_Session_EditProfileDb profile=new Check_User_Session_EditProfileDb();
			 try {
				profileData=profile.getProfile(email);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 System.out.println(profileData);
			 request.setAttribute("profileData", profileData);
			 RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/userDashboardChangeProfile.jsp");
			 rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/404error.jsp");
			 rd.forward(request, response);
		}
		
	}

}
