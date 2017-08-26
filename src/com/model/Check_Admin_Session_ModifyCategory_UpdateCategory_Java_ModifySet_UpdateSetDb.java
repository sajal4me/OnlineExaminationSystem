package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_UpdateSetDb {
	
	public String updateSet(String setId,List<String> setList) throws ClassNotFoundException, SQLException
	{
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.UPDATE_SET);
		int i;
		for(i=0;i<1;i++)
		{
		pstmt.setString(i+1,setList.get(0));
		}
		
		pstmt.setString(2,setId );
		
		int rowEffected=pstmt.executeUpdate();
		if(rowEffected>0)
		{
			System.out.println("SUCCESS");
			return StatusConstants.SUCCESS;
		}
		else
		{
			return StatusConstants.FAIL;
		}
		
		
	}

}
