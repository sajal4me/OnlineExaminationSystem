package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestion_StoreQuestionDb;
import com.model.StatusConstants;
import com.service.CheckParameters;

public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestion_StoreQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String statusQuesDb="";
		// List to store ALL status of Parameters.
		
		List<String> storeStatus=new ArrayList<String>();
		//List to store All Parameters.
		
		List<String> storeParameters=new ArrayList<String>();
		
		CheckParameters checkPara=new CheckParameters();
		String question=request.getParameter("question");
		storeStatus.add(checkPara.checkString(question));
		
		String optionA=request.getParameter("option1");
		storeStatus.add(checkPara.checkString(optionA));
		
		String optionB=request.getParameter("option2");
		storeStatus.add(checkPara.checkString(optionB));
		
		String optionC=request.getParameter("option3");
		storeStatus.add(checkPara.checkString(optionC));
		
		String optionD=request.getParameter("option4");
		storeStatus.add(checkPara.checkString(optionD));
		
		String answer=request.getParameter("answer");
		storeStatus.add(checkPara.checkInt(answer));
		
		String set=request.getParameter("set");
		storeStatus.add(checkPara.checkInt(set));
		
		String topic=request.getParameter("topic");
		storeStatus.add(checkPara.checkInt(topic));
		
		String category=request.getParameter("category");
		storeStatus.add(checkPara.checkInt(category));
		
		//Checking List
		String status=checkPara.checkStatus(storeStatus);
		
		if(status.equals(StatusConstants.SUCCESS))
		{
			storeParameters.add(question);
			storeParameters.add(optionA);
			storeParameters.add(optionB);
			storeParameters.add(optionC);
			storeParameters.add(optionD);
			storeParameters.add(answer);
			storeParameters.add(set);
			storeParameters.add(topic);
			storeParameters.add(category);
			Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestion_StoreQuestionDb storeQuestion=
					new Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestion_StoreQuestionDb();
			
			try {
				 statusQuesDb=storeQuestion.questionStore(storeParameters);
				 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(statusQuesDb.equals(StatusConstants.SUCCESS))
			{
				RequestDispatcher rd=request.getRequestDispatcher("JSP/adminCategoryModifyUpdateCategoryJava_ModifyQuestion_AddQuestion.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("JSP/adminCategoryModifyUpdateCategoryJava_ModifyQuestion_AddQuestion.jsp");
			}
			
		}
		else
		{
			
			response.sendRedirect("JSP/adminCategoryModifyUpdateCategoryJava_ModifyQuestion_AddQuestion.jsp");
			
		}
		
		
		
		
		

		
	}

}
