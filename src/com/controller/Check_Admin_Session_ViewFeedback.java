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

import com.model.Check_Admin_Session_ContentView_TopicDb;
import com.model.Check_Admin_Session_ViewFeedbackDb;


public class Check_Admin_Session_ViewFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession(false);
		if(sess!=null)
		{
			Check_Admin_Session_ViewFeedbackDb feedbackObj=new Check_Admin_Session_ViewFeedbackDb();
			Map<String,List<String>> feedbackMap=new LinkedHashMap<String,List<String>>();
			try {
				feedbackMap=feedbackObj.data();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sess.setAttribute("feedbackMap",feedbackMap);
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminContentView_ViewFeedback.jsp");
			rd.forward(request, response);
		}
	}

}
