package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Check_Admin_Session_ContentView_QuestionDb;

public class Check_Admin_Session_ContentView_Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,List<String>> questionMap=new LinkedHashMap<String,List<String>>();
		
		HttpSession sess=request.getSession(false);
		if(sess!=null)
		{
			Check_Admin_Session_ContentView_QuestionDb questionContainer=new Check_Admin_Session_ContentView_QuestionDb();
			try {
				questionMap=questionContainer.data();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sess.setAttribute("questionMap", questionMap);
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminContentView_Question.jsp");
			rd.forward(request,response);
			
		}
		
	}

}
