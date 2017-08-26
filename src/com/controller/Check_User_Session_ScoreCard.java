package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.Check_User_Session_ScoreCardDb;


public class Check_User_Session_ScoreCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<Integer,List<String>> scoreMap=new HashMap<Integer,List<String>>(); 
		List<String> scoreList=new ArrayList<String>();
		
		HttpSession sess=request.getSession(false);
		String emailId=(String) sess.getAttribute("emailLoggedInUser");
		
		Check_User_Session_ScoreCardDb score=new Check_User_Session_ScoreCardDb();
		try {
			scoreMap=score.data(emailId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("scoreMap", scoreMap);
		
		RequestDispatcher rd=request.getRequestDispatcher("JSP/userDashboardScoreCard.jsp");
		rd.forward(request,response);
		
		
	}

}
