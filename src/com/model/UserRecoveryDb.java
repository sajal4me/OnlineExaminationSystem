package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UserRecoveryDb {
	
	 static PreparedStatement pstmt;	
	   /*public static void data1() {
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
		   String question="";
		   CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		   Connection con=commonDAOObject.getConnection();
		   pstmt=con.prepareStatement(SQLConstants.USER_RECOVERY_SECURITY_QUESTION);
		   pstmt.setString(1, email);
		   /*String query="select question from security_question where question_id=(select security_id from user_login where email='"+email+"')";*/
		   ResultSet rS=pstmt.executeQuery();
		   while(rS.next())
		   {
			   question=rS.getString(1);
			  
		   }
		   
		   return question;
	   }
	   
	   

}
