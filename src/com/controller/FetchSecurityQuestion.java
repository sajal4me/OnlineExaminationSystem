package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.FetchSecurityQuestionDb;


public class FetchSecurityQuestion extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<Integer,String> questionMap=new HashMap<Integer,String>();
		FetchSecurityQuestionDb fsqDb=new FetchSecurityQuestionDb();
		
			 try {
				questionMap=fsqDb.getSecurityQuestion();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(questionMap+"yahan");
			 
		
		
		request.setAttribute("questionMap", questionMap);
		RequestDispatcher rd=request.getRequestDispatcher("JSP/Register.jsp");
		rd.forward(request, response);
		
	}

}
