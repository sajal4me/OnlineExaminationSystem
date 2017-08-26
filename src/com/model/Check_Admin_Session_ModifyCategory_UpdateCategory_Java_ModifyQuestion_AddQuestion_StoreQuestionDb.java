package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestion_StoreQuestionDb {
	
	public String questionStore(List<String> allPara) throws ClassNotFoundException, SQLException
	{
		
		String question=allPara.get(0);
		String optionA=allPara.get(1);
		String optionB=allPara.get(2);
		String optionC=allPara.get(3);
		String optionD=allPara.get(4);
		int answer=Integer.parseInt(allPara.get(5));
		int set=Integer.parseInt(allPara.get(6));
		int topic=Integer.parseInt(allPara.get(7));
		int category=Integer.parseInt(allPara.get(8));
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.ADD_QUESTION);
		pstmt.setString(1,question);
		pstmt.setString(2,optionA);
		pstmt.setString(3, optionB);
		pstmt.setString(4,optionC);
		pstmt.setString(5, optionD);
		pstmt.setInt(6, answer);
		pstmt.setInt(7, set);
		pstmt.setInt(8, topic);
		pstmt.setInt(9, category);
		
		
		int rowEffected=pstmt.executeUpdate();
		if(rowEffected>0)
		{
			System.out.println(allPara+" ");
			return StatusConstants.SUCCESS;
		}
		else
		{
			return StatusConstants.FAIL;
		}
		
	}

	

}
