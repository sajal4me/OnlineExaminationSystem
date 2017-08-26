package com.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.model.Check_User_Session_GiveTestDb;
import com.model.ExamDTO;

public class Check_User_Session_GiveTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comId="";
		System.out.println("**Servlet**-Check_User_Session_GiveTest");
		
		//HashMap to Store Question.
		/*HashMap<Integer,List<String>> questionMap=new LinkedHashMap<Integer,List<String>>();*/
		
		HttpSession sess=request.getSession(false);
		
		String subcatName=request.getParameter("subcatName");
		String catName=(String) sess.getAttribute("categoryName");
		if(subcatName.equalsIgnoreCase("set"))
		{
			 comId=request.getParameter("setId");
		}
		else if(subcatName.equalsIgnoreCase("topic"))
		{
			 comId=request.getParameter("topicId");
		}
		
		
		//Setting DTO For Accessing In Check_User_Session_GiveTest_JsFetch.
		 
		/*Check_User_Session_GiveTestDb bringQuestion=new Check_User_Session_GiveTestDb();*/
		
		
		
		
		
		/*request.setAttribute("questionMap", questionMap);*/
		/*System.out.println(questionMap);*/
		
		
/*		String json = new JSONObject().toJson(questionMap);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", "abcd");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			obj.put("age", new Integer(100));
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONArray list = new JSONArray();
		((List<String>) list).add("msg 1");
		((List<String>) list).add("msg 2");
		((List<String>) list).add("msg 3");
		try {
			obj.put("messages", list);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
		    FileWriter file = new FileWriter("c:\\test.json");
		    file.write(obj.toString());
		    file.flush();
		    file.close();    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		System.out.print(obj);
		
		
		 response.setContentType("application/json");
	        PrintWriter out = response.getWriter();
	        JSONObject jsonObj = (JSONObject) JSONValue.parse(request.getParameter("questionMap"));
	        System.out.println(jsonObj.get("message"));
	        JSONObject obj = new JSONObject();
	        obj.put("message", "hello from server");
	        out.print(obj);*/
		
		/*response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        out.println("{");
        out.println("\"First Name\": \"Devesh\",");
        out.println("\"Last Name\": \"Sharma\"");
        out.println("}");
        out.close();*/
	/*	JSONObject json      = new JSONObject();
		JSONArray  addresses = new JSONArray();
		JSONObject address;
		try
		{
		   int count = 15;

		   for (int i=0 ; i<count ; i++)
		   {
		       address = new JSONObject();
		       address.put("CustomerName"     , "Decepticons" + i);
		       address.put("AccountId"        , "1999" + i);
		       address.put("SiteId"           , "1888" + i);
		       address.put("Number"            , "7" + i);
		       address.put("Building"          , "StarScream Skyscraper" + i);
		       address.put("Street"            , "Devestator Avenue" + i);
		       address.put("City"              , "Megatron City" + i);
		       address.put("ZipCode"          , "ZZ00 XX1" + i);
		       address.put("Country"           , "CyberTron" + i);
		       addresses.put(address);
		   }
		   json.put("Addresses", addresses);
		}
		catch (JSONException jse)
		{ 

		}
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
        
        System.out.println("End Of page"+json.toString());
		*/
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/userOnlineTestGiveTest.jsp");
		rd.forward(request, response);
	}

}
