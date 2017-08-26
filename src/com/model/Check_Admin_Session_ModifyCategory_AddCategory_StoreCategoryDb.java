package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Check_Admin_Session_ModifyCategory_AddCategory_StoreCategoryDb {
	
	public String data(String categoryName) throws ClassNotFoundException, SQLException
	{
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.ADD_CATEGORY);
		pstmt.setString(1,categoryName );
		
		int rowEffected=pstmt.executeUpdate();
		if(rowEffected>0)
			return StatusConstants.SUCCESS;
		else
			return StatusConstants.FAIL;
		
	}
	
	

}
