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

import com.model.Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyTopic_AddTopic_StoreTopicDb;
import com.model.StatusConstants;


public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyTopic_AddTopic_StoreTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession(false);
		String topicName=request.getParameter("topicName");
		String categoryId=(String) sess.getAttribute("categoryId");
		int id=Integer.parseInt(categoryId);
		System.out.println(id+"  "+topicName);
		if(topicName.length()>0 && topicName.equals("")==false)
		{
			Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyTopic_AddTopic_StoreTopicDb storetopic=new Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyTopic_AddTopic_StoreTopicDb();
			String status = null;
			try {
				status = storetopic.data(topicName,id);
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
				RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateCategoryJava_ModifyTopic_AddTopic.jsp");
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
