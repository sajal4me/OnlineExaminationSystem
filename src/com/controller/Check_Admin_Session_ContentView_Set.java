package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Check_Admin_Session_ContentViewDb;
import com.model.CommonDAO;


public class Check_Admin_Session_ContentView_Set extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession(false);
		
		Check_Admin_Session_ContentViewDb getSet=new Check_Admin_Session_ContentViewDb();
		
		Map<String,ArrayList<String>> setData=new LinkedHashMap<String,ArrayList<String>>();
		try {
			setData=getSet.data();
			System.out.println(setData.get(1));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(sess!=null)
		{
			sess.setAttribute("setMap", setData);
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminContentView_Set.jsp");
			rd.forward(request,response);
		}
		else
		{
			response.sendRedirect("JSP/404error.jsp");
		}
		
		
		
	}

}
