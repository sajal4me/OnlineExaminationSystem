package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class getFeedbackDb {
	
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
	   
	   
	   }
	   */
	
	   public String saveFeedbackInDb(String fromServletFeedback, String email,String date) throws SQLException, ClassNotFoundException
	   {
		   /*data1();*/
		   CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		   Connection con=null;
		   con=commonDAOObject.getConnection();
		   pstmt=con.prepareStatement(SQLConstants.SAVE_FEEDBACK);
		   pstmt.setString(1, email);
		   pstmt.setString(2, fromServletFeedback);
		   pstmt.setString(3, date);
		   
		   /*String query="INSERT INTO feedback(email,user_feedback,currentTime) VALUES( '"+email+" ',' " + fromServletFeedback+"','" +date+"')" ;*/
		   		
		   int recordEffected=pstmt.executeUpdate();
		   
		   if(recordEffected>0)
			   
		   {
			   return StatusConstants.SUCCESS;
		   }
		   else
		   {
			   return StatusConstants.FAIL;
		   }
		   
		   
	   }

}
