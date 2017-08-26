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

import com.model.Check_User_Session_CategoryDb;



public class Check_User_Session_Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// For Fetching The Set,Category And Topic To Make Our "userOnlineTestCategory.jsp" page Dynamic.
		System.out.println("Check_User_Session_Category Servlet");
		
		Check_User_Session_CategoryDb fetchCategory=new Check_User_Session_CategoryDb();
		
		Map<Integer,List<String>> catsettopMap=new LinkedHashMap<Integer,List<String>>();
		
		
		try {
			catsettopMap=fetchCategory.fetchData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("catsettopMap", catsettopMap);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("JSP/userOnlineTestCategory.jsp");
		rd.forward(request, response);
		
	}

}
