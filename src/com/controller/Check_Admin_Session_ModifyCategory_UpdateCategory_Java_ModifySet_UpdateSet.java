package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_UpdateSetDb;
import com.model.StatusConstants;


public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_UpdateSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noOfQuestion=request.getParameter("noOfQuestion");
		String setId=request.getParameter("setId");
		String status="";
		List<String> setList=new LinkedList<String>();
		setList.add(noOfQuestion);
		
		System.out.println(noOfQuestion+" ** "+setId);
		Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_UpdateSetDb updateSet=new Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_UpdateSetDb();
		try {
			status=updateSet.updateSet(setId, setList);
			System.out.println(status);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status.equals(StatusConstants.SUCCESS))
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateCategoryJava_ModifySet.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/404error.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

}
