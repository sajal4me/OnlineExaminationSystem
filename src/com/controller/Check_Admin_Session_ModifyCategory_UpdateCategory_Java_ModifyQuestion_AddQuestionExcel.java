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

import com.model.Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionDb;
import com.model.SetTop;


public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SetTop st=new SetTop();
		HttpSession sess=request.getSession(false);
		if(sess!=null)
		{
			String categoryId=(String) sess.getAttribute("categoryId");
			Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionDb settop=new Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionDb();
			
			try {
				st=settop.getSetTop(categoryId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("settop", st);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/adminCategoryModifyUpdateCategoryJavaModifyQuestionAddQuestionOptionsExcel.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/404error.jsp");
			rd.forward(request, response);
		}
		
	}

}
