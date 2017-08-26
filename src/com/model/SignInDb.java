package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignInDb {
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
	 public boolean data(String email, String pass)  throws SQLException{
		System.out.println("here1");
		 	String status="";
		 	UserDAO uDAO=new UserDAO();
			UserDTO uDTO=new UserDTO();
			uDTO.setEmail(email);
			uDTO.setPass(pass);
			try {
				status=uDAO.login(uDTO);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   
			System.out.println("here2");
		    if(status.equals(StatusConstants.SUCCESS)){
			 
				  return true;
			  }
		return false;
	}
}
