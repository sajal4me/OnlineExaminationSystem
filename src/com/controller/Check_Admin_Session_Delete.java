package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Check_Admin_Session_DeleteDb;


public class Check_Admin_Session_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("****Servlet****-Check_Admin_Session_Delete");
		
		
		HashMap<Integer,List<String>> deleteMap=new HashMap<Integer,List<String>>();
		String deleteIndex=request.getParameter("deleteIndex");
		int deleteIntIndex=new Integer(deleteIndex);
		String categoryIndex=request.getParameter("category");
		
		Check_Admin_Session_DeleteDb delData=new Check_Admin_Session_DeleteDb();
		try {
			deleteMap=delData.deleteAny(deleteIndex,categoryIndex);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(deleteMap);
		
		request.setAttribute("deleteMap", deleteMap);
		request.setAttribute("deleteIndex", deleteIndex);
		request.setAttribute("categoryIndex", categoryIndex);
		
		RequestDispatcher rd=request.getRequestDispatcher("JSP/adminDeleteAny.jsp");
		rd.forward(request,response);
		
		
		
	}

}
