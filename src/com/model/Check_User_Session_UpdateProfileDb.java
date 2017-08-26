package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



public class Check_User_Session_UpdateProfileDb {
	
	public String dataUpdate(List<String> profileList) throws SQLException, ClassNotFoundException
	{
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.UPDATE_USER_PROFILE);
		pstmt.setString(1, profileList.get(0));
		pstmt.setString(2, profileList.get(1));
		pstmt.setString(3, profileList.get(2));
		pstmt.setString(4, profileList.get(3));
		
		int rowEffected=pstmt.executeUpdate();
		
		if(rowEffected>0)
			return StatusConstants.SUCCESS;
		else
			return StatusConstants.FAIL;
	}

}
