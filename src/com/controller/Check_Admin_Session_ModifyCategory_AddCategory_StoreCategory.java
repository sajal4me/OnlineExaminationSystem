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

import com.model.Check_Admin_Session_ModifyCategory_AddCategory_StoreCategoryDb;
import com.model.StatusConstants;


public class Check_Admin_Session_ModifyCategory_AddCategory_StoreCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession(false);
		if(sess!=null)
		{
			String categoryName=request.getParameter("categoryName");
			Check_Admin_Session_ModifyCategory_AddCategory_StoreCategoryDb storecategory=new Check_Admin_Session_ModifyCategory_AddCategory_StoreCategoryDb();
			String status = null;
			try {
				status = storecategory.data(categoryName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(status.equals(StatusConstants.SUCCESS))
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyAddCategorySuccessStore.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("JSP/404error.jsp");
				rd.forward(request, response);
				
			}
				
		}
		
	}

}
