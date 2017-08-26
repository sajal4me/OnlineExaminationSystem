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

import com.model.Check_Admin_Session_ContentView_CategoryDb;


public class Check_Admin_Session_ContentView_Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession(false);
		if(sess!=null)
		{
			Check_Admin_Session_ContentView_CategoryDb categoryObj=new Check_Admin_Session_ContentView_CategoryDb();
			Map<String,List<String>> categoryMap=new LinkedHashMap<String,List<String>>();
			try {
				categoryMap=categoryObj.data();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sess.setAttribute("categoryMap",categoryMap);
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminContentView_Category.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
