package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check_Admin_Session_DeleteAnyDb {
	
	public String data(String category,String deleteIndex,String optionSelected) throws ClassNotFoundException, SQLException
	{
		String status="";
		
		System.out.println("Here1");
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		System.out.println("Here2");
		
		int rowsEffected=0;
		System.out.println("category :"+category+"optionSelected :"+optionSelected);
		if(deleteIndex.equals("1"))
		{
			/*PreparedStatement pstmtCatId=con.prepareStatement(SQLConstants.GET_CATEGORY_ID);
			pstmtCatId.setString(1,category);
			ResultSet rs=pstmtCatId.executeQuery();
			rs.next();
			String catId=rs.getString(1);*/
			PreparedStatement pstmtCat=con.prepareStatement(SQLConstants.DELETE_CATEGORY);
			pstmtCat.setString(1, optionSelected);
			rowsEffected=pstmtCat.executeUpdate();
		}
		
		else if(deleteIndex.equals(2+""))
		{
			System.out.println("Here3");
			PreparedStatement pstmtSet=con.prepareStatement(SQLConstants.DELETE_SET);
			System.out.println("category :"+category+"optionSelected :"+optionSelected);
			pstmtSet.setString(1, optionSelected);
			rowsEffected=pstmtSet.executeUpdate();
		}
		
		else if(deleteIndex.equals("3"))
		{
			PreparedStatement pstmtTopic=con.prepareStatement(SQLConstants.DELETE_TOPIC);
			pstmtTopic.setString(1, optionSelected);
			rowsEffected=pstmtTopic.executeUpdate();
		}
		
		else if(deleteIndex.equals("4"))
		{
			PreparedStatement pstmtQues=con.prepareStatement(SQLConstants.DELETE_QUESTION);
			pstmtQues.setString(1, optionSelected);
			rowsEffected=pstmtQues.executeUpdate();
		}
		
		
		if(rowsEffected>0)
			return StatusConstants.SUCCESS;
		else
			return StatusConstants.FAIL;
		
	}

}
