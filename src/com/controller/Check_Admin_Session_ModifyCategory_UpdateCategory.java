package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Check_Admin_Session_ModifyCategory_UpdateCategoryDb;


public class Check_Admin_Session_ModifyCategory_UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<Integer,String> categoryMap=new HashMap<Integer,String>();
		HttpSession sess=request.getSession(false);
		if(sess!=null)
		{
			Check_Admin_Session_ModifyCategory_UpdateCategoryDb category=new Check_Admin_Session_ModifyCategory_UpdateCategoryDb();
			try {
				categoryMap=category.getCategory();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("categoryMap", categoryMap);
			
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateCategory.jsp");
			rd.forward(request, response);
		}
		/*else
		{
		    RequestDispatcher rd=request.getRequestDispatcher("adminLoginEncoded.jsp");
			rd.forward(request, response);
		}*/
		
	}

}
