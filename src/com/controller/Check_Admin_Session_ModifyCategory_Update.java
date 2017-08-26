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

import com.model.Check_Admin_Session_ContentViewDb;
import com.model.Check_Admin_Session_ContentView_QuestionDb;
import com.model.Check_Admin_Session_ContentView_TopicDb;


public class Check_Admin_Session_ModifyCategory_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession(false);
		if(sess!=null)
		{
			String updateWhat=request.getParameter("update");
			String categoryId=(String)sess.getAttribute("categoryId");
			if(updateWhat.equalsIgnoreCase("set"))
			{
				Check_Admin_Session_ContentViewDb set=new Check_Admin_Session_ContentViewDb();
				try {
					sess.setAttribute("setMap", set.data(categoryId));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sess.setAttribute("update", "set");
				
			}
			else if(updateWhat.equalsIgnoreCase("topic"))
			{
				Check_Admin_Session_ContentView_TopicDb topic=new Check_Admin_Session_ContentView_TopicDb();
				try {
					sess.setAttribute("topicMap", topic.data(categoryId));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sess.setAttribute("update", "topic");
			}
			else if(updateWhat.equalsIgnoreCase("question"))
			{
				Check_Admin_Session_ContentView_QuestionDb question=new Check_Admin_Session_ContentView_QuestionDb();
				try {
					sess.setAttribute("questionMap", question.data(categoryId));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sess.setAttribute("update", "question");
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateAll.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
