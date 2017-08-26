package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_UpdateQuestionDb {
	
	public String updateQuestion(String questionId,List<String> questionList) throws ClassNotFoundException, SQLException
	{
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.UPDATE_QUESTION);
		
		for(int i=0;i<6;i++)
		{
			pstmt.setString(i+1, questionList.get(i));
		}
		
		pstmt.setString(7, questionId);
		
		int rowEffected=pstmt.executeUpdate();
		
		if(rowEffected>0)
			return StatusConstants.SUCCESS;
		else
			return StatusConstants.FAIL;
		
		
		
		
		
		
		
	}

}
