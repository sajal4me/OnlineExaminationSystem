package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession(false);
		String categoryId=request.getParameter("category");
		System.out.println(categoryId);
		if(categoryId.length()>0 && categoryId.equals("")==false)
		{
		sess.setAttribute("categoryId", categoryId);
		System.out.println("H");
		RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateCategoryJava.jsp");
		rd.forward(request, response);
		}
		
	}

}
