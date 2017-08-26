package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Check_Admin_Session_ModifyCategory_UpdateCategoryDb {
	
	public Map<Integer,String> getCategory() throws SQLException, ClassNotFoundException
	{
		Map<Integer,String> catMap=new HashMap<Integer,String>();
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.SELECT_CATEGORY);
		ResultSet rsCat=pstmt.executeQuery();
		
		while(rsCat.next())
		{
			catMap.put(rsCat.getInt(1), rsCat.getString(2));
		}
		
		
		return catMap;
		
	}

}
