package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class FetchSecurityQuestionDb {
	
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
	   
	   public HashMap<Integer,String> getSecurityQuestion() throws SQLException, ClassNotFoundException 
	   {
		   Connection con=null;
		   CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		   con=commonDAOObject.getConnection();
		   pstmt=con.prepareStatement(SQLConstants.SELECT_SECURITY_QUESTION);
		   HashMap<Integer,String> questionMap=new HashMap<Integer,String>();
		   /*String query="select * from security_question";*/
		   ResultSet rs =  pstmt.executeQuery();
		    while(rs.next())
		    {
		    	
		    
			   Integer question_id=rs.getInt(1);
			   String question=    rs.getString(2);
			   questionMap.put(question_id, question);
			   
		    }
		    System.out.println(questionMap);
		    return questionMap;
	   }
	   
	   

}
