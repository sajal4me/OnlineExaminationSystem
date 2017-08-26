package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_AddSet_StoreSetDb {
	
	public String data(String noOfQues,String categoryId) throws ClassNotFoundException, SQLException
	{
		String status = null;
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		int questionSize=Integer.parseInt(noOfQues);
		int idCategory=Integer.parseInt(categoryId);
		
		System.out.println("Id Of Category"+idCategory);
		
		if(con!=null)
		{
			PreparedStatement pstmt=con.prepareStatement(SQLConstants.ADD_SET);
			pstmt.setInt(1,idCategory );
			pstmt.setInt(2,questionSize );
			int rowEffected=pstmt.executeUpdate();
			if(rowEffected>0)
			{
				
				status=StatusConstants.SUCCESS;
			}
			else
			{
				status=StatusConstants.FAIL;
			}
		}
		
		return status;
		
		
		
	}

}
