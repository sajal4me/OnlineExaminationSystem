package com.model;

import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

import com.service.PasswordEncryption;

public class SignUpDb {

	 static Statement stmt;	
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
 public String data(String name, String email,String pass,long mobileNumber,String security,String ans) throws SQLException, ClassNotFoundException
	 		{
	 System.out.println("here3");
	 			UserDAO uDAO=new UserDAO();
	 			UserDTO uDTO=new UserDTO();
	 	
	 			PasswordEncryption obj=PasswordEncryption.getInstanse();
	 			List<String> finalPassNdSalt=obj.hashPassword(pass);
	 			System.out.println("here4");
	 	// Encrypted Password
	 			String password=finalPassNdSalt.get(0);
	 	// salt a random String value without any encryption
	 			String salt=finalPassNdSalt.get(1);
	 			System.out.println("here5");
	 			uDTO.setName(name);
	 			uDTO.setEmail(email);
	 			uDTO.setPass(password);
	 			uDTO.setSalt(salt);
	 			uDTO.setMobileNumber(mobileNumber);
	 			uDTO.setSecurity_id(security);
	 			uDTO.setAnswer(ans);
	 			
	 			System.out.println("here6");	
	 			String status=uDAO.register(uDTO);
	 			if(status.equals(StatusConstants.SUCCESS))
	 			{
	 				return StatusConstants.SUCCESS;
	 		    } 
	 			
	 			return StatusConstants.FAIL;
	   
	 		}
	
	 		}
