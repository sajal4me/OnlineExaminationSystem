package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Check_User_Session_TopicDb;


public class Check_User_Session_Topic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryName=request.getParameter("categoryName");
		String catTopic=request.getParameter("catTop");
		System.out.println("**Servlet**-Check_User_Session_Topic");
		System.out.println(categoryName+" "+catTopic);
		
		Map<Integer,List<String>> topicIdNameMap=new HashMap<Integer,List<String>>();
		
		Check_User_Session_TopicDb topic=new Check_User_Session_TopicDb();
		try {
			topicIdNameMap=topic.topicData(categoryName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("topicIdNameMap", topicIdNameMap);
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("subcategoryName", "topic");
		
		RequestDispatcher rd=request.getRequestDispatcher("JSP/userOnlineTestSetTopicDetails.jsp");
		rd.forward(request, response);
		
	}

}
