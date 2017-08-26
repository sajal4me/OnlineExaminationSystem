package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Admin_ViewFeedbackDb;


public class Admin_ViewFeedback extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request , response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Admin_ViewFeedbackDb viewFeedback=new Admin_ViewFeedbackDb();
		
		HashMap<Integer,List<String>> feedbackDataMap=new HashMap<Integer,List<String>>();
		ArrayList<String> feedbackList=new ArrayList<String>();
		try {
			try {
				feedbackDataMap=viewFeedback.data();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Integer sno: feedbackDataMap.keySet()){

            Integer key =sno;
            System.out.println(key);
            
            feedbackList=(ArrayList<String>) feedbackDataMap.get(key);
            System.out.println(feedbackList);
            feedbackList.clear();
} 
		
	}

}
