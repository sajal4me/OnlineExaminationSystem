package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Check_Admin_Session_ModifyCategory_UpdateDb;



public class Check_Admin_Session_UpdateAllGetForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Name like {questionMap,setMap,topicMap}.
		String updateWhatMap= request.getParameter("updateMapName");
		String optionSelected=request.getParameter("update");
		System.out.println(updateWhatMap+"  "+optionSelected);
		Check_Admin_Session_ModifyCategory_UpdateDb getData=new Check_Admin_Session_ModifyCategory_UpdateDb();
		
		//First Make Connection Then Call There Respective Methods.
		try {
			getData.makeConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(updateWhatMap.equalsIgnoreCase("setMap"))
		{
			List<String> setList=new LinkedList<String>();
			try {
				setList=getData.getSetData(optionSelected);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(setList);
			request.setAttribute("setList", setList);
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateCategoryJava_ModifyQuestion_UpdateSet.jsp");
			rd.forward(request,response);
		}
		else if(updateWhatMap.equalsIgnoreCase("questionMap"))
		{
			List<String> questionList=new LinkedList<String>();
			
			try {
				
				
				questionList=getData.getQuestionData(optionSelected);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("questionList", questionList);
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateCategoryJava_ModifyQuestion_UpdateQuestion.jsp");
			rd.forward(request,response);
		}
		else if(updateWhatMap.equalsIgnoreCase("topicMap"))
		{
			List<String> topicList=new LinkedList<String>();
			try {
				topicList=getData.getTopicData(optionSelected);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(topicList);
			request.setAttribute("topicList", topicList);
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateCategoryJava_ModifyTopic_UpdateTopic.jsp");
			rd.forward(request,response);
			
		}
		
	}

}
