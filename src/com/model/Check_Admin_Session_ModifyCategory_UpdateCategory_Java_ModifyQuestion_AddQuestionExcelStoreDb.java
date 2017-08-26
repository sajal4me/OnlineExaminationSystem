package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.service.QuestionContainer;

public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionExcelStoreDb {
	
	public String storeQuestion(List<QuestionContainer> questionList,String set,String topic,String categoryId) throws ClassNotFoundException, SQLException
	{
		int rowEffected=0;
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.ADD_QUESTION);
		
		System.out.println(questionList);

		for(int i=0;i<questionList.size();i++)
		{
			System.out.println(questionList.get(i));
			pstmt.setString(1, questionList.get(i).getQuestion());
			pstmt.setString(2, questionList.get(i).getOptionA());
			pstmt.setString(3, questionList.get(i).getOptionB());
			pstmt.setString(4, questionList.get(i).getOptionC());
			pstmt.setString(5, questionList.get(i).getOptionD());
			pstmt.setString(6, questionList.get(i).getAnswer().toString());
			pstmt.setString(7, set);
			pstmt.setString(8, topic);
			pstmt.setString(9, categoryId);
			rowEffected=pstmt.executeUpdate();
		}
			
			if(rowEffected>0)
				return StatusConstants.SUCCESS;
			else
				return StatusConstants.FAIL;
	}

}
