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

import com.model.Check_User_Session_SetDb;



public class Check_User_Session_Set extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("**Servlet**--Check_User_Session_Set");
		
		Map<Integer,List<String>> setIdQuesMap=new LinkedHashMap<Integer,List<String>>();
		String categoryName=(request.getParameter("categoryName"));
		String catSet=request.getParameter("catSet");
		System.out.println("**Servlet**-Check_User_Session_Set");
		System.out.println(categoryName+" "+catSet);
		
		Check_User_Session_SetDb set=new Check_User_Session_SetDb();
		
			try {
				setIdQuesMap=set.setData(categoryName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		request.setAttribute("setIdQuesMap", setIdQuesMap);
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("subcategoryName","set");
		RequestDispatcher rd=request.getRequestDispatcher("JSP/userOnlineTestSetTopicDetails.jsp");
		rd.forward(request, response);
		
	}

}
