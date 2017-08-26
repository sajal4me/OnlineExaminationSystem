package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Check_User_Session_SaveFeedbackDb {
	
	public String saveFeedback(String email,String feedback) throws SQLException, ClassNotFoundException
	{
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.SAVE_FEEDBACK);
		pstmt.setString(1, email);
		pstmt.setString(2, feedback);
		pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		int rowEffected=pstmt.executeUpdate();
		if(rowEffected>0)
		{
			return StatusConstants.SUCCESS;
		}
		else
		{
			return StatusConstants.FAIL;
		}
		
	}

}
