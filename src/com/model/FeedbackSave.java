package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FeedbackSave {
	
	   static Statement stmt;	
	   public static void data1() throws SQLException {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project_onlineexam","root","sunnyagrawal");
				if(con==null)
					System.out.println("null connection");
				 stmt=con.createStatement();
			}
			catch (ClassNotFoundException |SQLException e){
				  e.printStackTrace();
			}
		}
	
	void saveFeedbackInDb(String feedBack) throws SQLException
	{
		data1();
		
//		String query="insert into user_login values('"+name+"','"+ email+"','"+ pass+"','"+ mobileNumber+"','"+security+"','"+ans+"')";
//        int result=stmt.executeUpdate(query);
		
		
	}

}
