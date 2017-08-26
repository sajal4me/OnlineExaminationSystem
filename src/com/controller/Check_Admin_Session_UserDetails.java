package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Check_Admin_Session_UserDetailsDb;


public class Check_Admin_Session_UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Map<Integer,List<String>> userDetailsMap=new HashMap<Integer,List<String>>();
		Check_Admin_Session_UserDetailsDb userData=new Check_Admin_Session_UserDetailsDb();
		try {
			userDetailsMap=userData.getData();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("userDetailsMap", userDetailsMap);
		
		RequestDispatcher rd=request.getRequestDispatcher("JSP/adminDashboardUserDetails.jsp");
		rd.forward(request, response);
		
		
		
	}

}
