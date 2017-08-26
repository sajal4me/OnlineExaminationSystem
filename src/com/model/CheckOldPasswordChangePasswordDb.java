package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.service.CheckParameters;

public class CheckOldPasswordChangePasswordDb {
	
	public String data(List<String> parameterList) throws ClassNotFoundException, SQLException
	{
		String dbPass="";
		String oldPassword=parameterList.get(0);
		String newPassword=parameterList.get(1);
		String renewPassword=parameterList.get(2);
		String email=parameterList.get(3);
		
		List<String> statusList=new ArrayList<String>();
		
		
		CheckParameters checkAll=new CheckParameters();
		String oldPasswordStatus=checkAll.checkString(oldPassword);
		statusList.add(oldPasswordStatus);
		
		String newPasswordStatus=checkAll.checkString(newPassword);
		statusList.add(newPasswordStatus);
		
		String renewPasswordStatus=checkAll.checkString(renewPassword);
		statusList.add(renewPasswordStatus);
		
		String emailStatus=checkAll.checkString(email);
		statusList.add(emailStatus);
		
		String mainStatus=checkAll.checkStatus(statusList);
		
		
		if(mainStatus.equals(StatusConstants.SUCCESS))
		{
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GET_CURRENT_PASSWORD);
		pstmt.setString(1, email);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			
			 dbPass=rs.getString(1);
			
		}
		
		if(oldPassword.equals(dbPass) && (renewPassword.equals(newPassword)))
		{
			pstmt=con.prepareStatement(SQLConstants.UPDATE_PASS);
			pstmt.setString(1,renewPassword );
			pstmt.setString(2,email );
			int rowEffected=pstmt.executeUpdate();
			if(rowEffected>0)
				return StatusConstants.SUCCESS;
		}
		}
		
		return StatusConstants.FAIL;
		
		
	}

}
