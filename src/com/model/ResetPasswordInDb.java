package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetPasswordInDb {
	
	 static PreparedStatement pstmt;	
	  /* public static void data1() {
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
	   
	   public int updatePass(String pass,String email) throws SQLException, ClassNotFoundException
	   {
		   
		   CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		   Connection con=commonDAOObject.getConnection();
		   pstmt=con.prepareStatement(SQLConstants.UPDATE_PASS);
		   pstmt.setString(1, pass);
		   pstmt.setString(2, email);
		   System.out.println(pass+"  "+email);
		  
		  int rowEffected= pstmt.executeUpdate();
		  System.out.println(rowEffected);
          return rowEffected;
		   
	   }

}
