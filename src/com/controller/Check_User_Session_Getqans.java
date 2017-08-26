package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.model.CheckUserResponse;


public class Check_User_Session_Getqans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<String> scoreList=new ArrayList<String>();
		String status="";
		String comId ="";
		System.out.println("**Servlet**-Check_User_Session_Getqans");
		String catName=request.getParameter("catName");
		System.out.println(catName);
		String subcatName=request.getParameter("subcatName");
		
		if(subcatName.equals("topic"))
		{
			comId=request.getParameter("topicId");
		}
		else if(subcatName.equals("set"))
		{
			comId=request.getParameter("setId");
		}
		
		
		
		
		
		
		HttpSession sess=request.getSession(false);
		String emailId=(String) sess.getAttribute("emailLoggedInUser");
		
		
		/*JSONObject songs= json.getJSONObject("songs");
		Iterator x = songs.keys();
		JSONArray jsonArray = new JSONArray();

		while (x.hasNext()){
		    String key = (String) x.next();
		    jsonArray.put(songs.get(key));
		}*/
		
		Map<Integer,Integer> quesMap=new HashMap<Integer,Integer>();
		Map<Integer,Integer> solMap=new HashMap<Integer,Integer>();
		//Creating Json Array For Question And Solution.
		
		
		int len;
		
		String qArray=request.getParameter("questionArray");
		try {
			JSONObject jsonQObject = new JSONObject(qArray);
			Iterator x = jsonQObject.keys();
			
			while (x.hasNext()){
			    String key = (String) x.next();
			    Integer k=Integer.parseInt(key);
			    Integer val=(jsonQObject.getInt(key));
			    quesMap.put(k,val);
			   
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Creating Map for Solution Array.
		String solutionArray=request.getParameter("solutionArray");
		
		try {
			JSONObject jsonSolObject=new JSONObject(solutionArray);
			Iterator s=jsonSolObject.keys();
			
			while(s.hasNext())
			{
				String key = (String) s.next();
			    Integer k=Integer.parseInt(key);
			    Integer val=(jsonSolObject.getInt(key));
			    solMap.put(k,val);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(qArray+" "+solutionArray);
		String length=request.getParameter("length");
	    len=Integer.parseInt(length);
	    
	    String time=request.getParameter("time");
	    System.out.println(time);
	    CheckUserResponse curObj=new CheckUserResponse();
	    try {
			scoreList=curObj.data(quesMap, solMap,emailId,time,catName,subcatName,comId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println(scoreList);
	    
	    request.setAttribute("scoreList",scoreList);
	    
	    System.out.println("Going To Print Result");
	    
	    JSONObject json=new JSONObject();
	    JSONArray jsonArrayScoreList=new JSONArray(scoreList);
	    
	    
	    try {
			json.put("1",jsonArrayScoreList);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    response.setContentType("application/json");
		response.getWriter().write(json.toString());
		
	}

}
