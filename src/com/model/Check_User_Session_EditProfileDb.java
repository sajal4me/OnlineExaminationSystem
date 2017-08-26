package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Check_User_Session_EditProfileDb {
	
	Connection con;
	
	public List<String> getProfile(String email) throws ClassNotFoundException, SQLException
	{
		List<String> profileList=new LinkedList<String>();
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		 con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GET_PROFILE);
		
		pstmt.setString(1, email);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			String name=rs.getString("name");
			String mobileNumber=rs.getString("mobileNumber");

			
			profileList.add(name);
			profileList.add(mobileNumber);
			
			
		}
		
		return profileList;
	}
	
	public String getQues(String security_id) throws SQLException
	{
		String ques="";
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GET_PROFILE_QUES);
		pstmt.setString(1, security_id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			ques=rs.getString("question");
		}
		
		return ques;
	}

}
