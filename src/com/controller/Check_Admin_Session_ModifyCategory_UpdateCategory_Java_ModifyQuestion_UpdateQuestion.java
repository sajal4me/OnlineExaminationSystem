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

import com.model.Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_UpdateQuestionDb;
import com.model.StatusConstants;


public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_UpdateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status="";
		
		String question=request.getParameter("question");
		String option1=request.getParameter("option1");
		String option2=request.getParameter("option2");
		String option3=request.getParameter("option3");
		String option4=request.getParameter("option4");
		String answer=request.getParameter("answer");
		String questionId=request.getParameter("questionId");
		
		//Creating Question List.
		List<String> questionList=new LinkedList<String>();
		questionList.add(question);
		questionList.add(option1);
		questionList.add(option2);
		questionList.add(option3);
		questionList.add(option4);
		questionList.add(answer);
		
		
		System.out.println(questionId+" -- "+answer);
		Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_UpdateQuestionDb update=new Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_UpdateQuestionDb();
		try {
			status=update.updateQuestion(questionId, questionList);
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
			request.setAttribute("status", status);
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateAll.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/404error.jsp");
			rd.forward(request, response);
			
		}
			
		
		
	}

}
