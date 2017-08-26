package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyTopic_AddTopic_StoreTopicDb {
	
	public String data(String topicName,int categoryId) throws ClassNotFoundException, SQLException
	{
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.ADD_TOPIC);
		pstmt.setInt(1, categoryId);
		pstmt.setString(2, topicName);
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
