package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.model.Check_User_Session_GiveTestDb;
import com.model.ExamDTO;


public class Check_User_Session_GiveTest_JsFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("**Servlet**-Check_User_Session_GiveTest_JsFetch");
		Map<Integer,List<String>> questionMap=new LinkedHashMap<Integer,List<String>>();
		
		
		String catName=(request.getParameter("catName"));
		
		String comId="";
		
		String subcatName=(request.getParameter("subcatName"));
		if(subcatName.equalsIgnoreCase("set"))
		{
			comId=request.getParameter("setId");
		}
		else
		{							
			comId=request.getParameter("topicId");
		}
		
		System.out.println("Query Params");
		System.out.println(catName);
		System.out.println(comId);
	
		
		Check_User_Session_GiveTestDb bringQuestion=new Check_User_Session_GiveTestDb();
		try {
			questionMap=bringQuestion.getQuestion(subcatName,comId, catName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(questionMap);
		
		//Creating Json For HashMap.
		
		JSONObject json=new JSONObject();
//		JSONArray questionsArray=new JSONArray();
//		JSONObject questionData = new JSONObject();
		
//		List<String> questionList=new ArrayList<String>();
		Set<Integer> questionSet=questionMap.keySet();
//		
		for(int i=0;i<questionSet.size();i++)
		{
//			questionsArray= (JSONArray) ;
			try {
				json.put(String.valueOf(i), questionMap.get(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		try {
//			json.put("questionData", questionsArray);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
