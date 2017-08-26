package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_AddSet_StoreSetDb;
import com.model.StatusConstants;


public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_AddSet_StoreSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status="";
		
		HttpSession sess=request.getSession(false);
		String noOfQues=request.getParameter("noOfQues");
		int quesSize=Integer.parseInt(noOfQues);
		if(sess!=null && noOfQues.length()>0)
		{
			
			String categoryId=(String) sess.getAttribute("categoryId");
			System.out.println(categoryId);
			if(categoryId!=null)
			{
			Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_AddSet_StoreSetDb storeSet=
					new Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_AddSet_StoreSetDb();
			 
			try {
				System.out.println(categoryId);
				status = storeSet.data(noOfQues,categoryId);
				System.out.println(categoryId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(categoryId);
			if(status.equals(StatusConstants.SUCCESS))
			{
				RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateCategoryJava_ModifySet_AddSet.jsp");
				rd.forward(request,response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("JSP/404error.jsp");
				rd.forward(request,response);
			}
			}
		}
		
		
	}

}
