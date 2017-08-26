package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchUserName {
	
	static PreparedStatement pstmt;	
	  /* public static void data1() throws SQLException {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project_onlineexam","root","sunnyagrawal");
				if(con==null)
					System.out.println("null connection");
				 stmt=con.createStatement();
			}
			catch (ClassNotFoundException |SQLException e)
	        {
				e.printStackTrace();
			
			}
	      
	   
	   }*/
	   
	   public String data(String email) throws SQLException, ClassNotFoundException
	   {
		   CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		   Connection con=null;
		   con=commonDAOObject.getConnection();
		   pstmt=con.prepareStatement(SQLConstants.FETCH_USERNAME);
		   pstmt.setString(1, email);
		  /* String query="select name from user_login where email='" + email + "'";*/
		 
		   ResultSet rs = pstmt.executeQuery();
		   
		       rs.next();
		       
			   String user_name=rs.getString("name");
			   
			   
			   
		      return user_name;
		   
	   }

}
