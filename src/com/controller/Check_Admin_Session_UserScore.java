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

import com.model.Check_Admin_Session_UserScoreDb;


public class Check_Admin_Session_UserScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<Integer,List<String>> userScoreMap=new HashMap<Integer,List<String>>();
		Check_Admin_Session_UserScoreDb userScore=new Check_Admin_Session_UserScoreDb();
		
		try {
			userScoreMap=userScore.getScore();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("userScoreMap",userScoreMap);
		
		RequestDispatcher rd=request.getRequestDispatcher("JSP/userDashboardUserScore.jsp");
		rd.forward(request, response);
		
	}

}
