package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckAnswer_UpdatePassDb {
	
	static PreparedStatement pstmt;	
	   /*public static void data1() throws SQLException {
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
		}*/
	
	
	   public boolean checkAns(String ans,String email) throws SQLException, ClassNotFoundException
	   {
		   
		   
		   boolean ind=false;
		   String answerDb="";
		   /*String query="select ans from user_login where email='"+email+"'";*/
		   CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		   Connection con=commonDAOObject.getConnection();
		   pstmt=con.prepareStatement(SQLConstants.SELECT_ANS_USER);
		   pstmt.setString(1, email);
		   ResultSet rS=pstmt.executeQuery();
		   while(rS.next())
		   {
			   answerDb=rS.getString(1);
		   }
		   if(answerDb.equalsIgnoreCase(ans))
		   {
			   ind=true;
		   }
		   
		   return ind;
	   }

}
