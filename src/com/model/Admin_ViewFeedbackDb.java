package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class Admin_ViewFeedbackDb {
	
	static Statement stmt;	
	   /*public static void data1() {
		   
		   		
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project_onlineexam","root","sunnyagrawal");
				if(con==null)
					System.out.println("null connection");
				 
			}
			catch (ClassNotFoundException |SQLException e)
	        {
				e.printStackTrace();
			
			}
	   
	   
	   }*/
	   
	   public HashMap<Integer,List<String>> data() throws SQLException, ClassNotFoundException
	   {
		   ResourceBundle rb=ResourceBundle.getBundle("model/db");
		   Class.forName(rb.getString("drivername"));
		   Connection con=DriverManager.getConnection(rb.getString("dburl"),rb.getString("userid"),rb.getString("password"));
		   stmt=con.createStatement();
		   HashMap<Integer,List<String>> feedbackDataMap=new HashMap<Integer,List<String>>();
		  
		   List<String> feedbackList=new ArrayList<String>();
		   String email,feedback,datetime;
		   int sno;
		   
		   String query=SQLConstants.USER_FEEDBACK;
		   
		   ResultSet rS=stmt.executeQuery(query);
		   
		   while(rS.next())
		   {
			   email=rS.getString(1);
			   feedback=rS.getString(2);
			   datetime=rS.getString(3);
			   sno=rS.getInt(4);
			   feedbackList.add(email);
			   feedbackList.add(feedback);
			   feedbackList.add(datetime);
			   feedbackDataMap.put(sno,feedbackList );
			   feedbackList.clear();
		   }
		return feedbackDataMap;
		
		   
		   
		   
	   }

}
