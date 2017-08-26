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

import com.model.Check_User_Session_LeaderBoardDb;


public class Check_User_Session_LeaderBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Map<Integer,List<String>> leadMap=new HashMap<Integer,List<String>>();
		
		
		Check_User_Session_LeaderBoardDb lead=new Check_User_Session_LeaderBoardDb();
		
		try {
			leadMap=lead.data();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("leadMap", leadMap);
		
		RequestDispatcher rd=request.getRequestDispatcher("JSP/userDashboardLeaderBoard.jsp");
		rd.forward(request, response);
		
	}

}
