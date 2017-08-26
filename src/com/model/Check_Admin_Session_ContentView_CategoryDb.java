package com.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



public class Check_Admin_Session_ContentView_CategoryDb {
	
	public Map<String,List<String>> data() throws SQLException, ClassNotFoundException
	{
		Map<String,List<String>> categoryMap=new LinkedHashMap<String,List<String>>();
		List<String> categoryList ;
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.SELECT_CATEGORY);

		ResultSet rs=pstmt.executeQuery();
		
		ResultSetMetaData metaData=rs.getMetaData();
		int columnCount=metaData.getColumnCount();
		String columnName[]=new String[columnCount];
		
		//Storing ColumnName in List.
				categoryList=new ArrayList<String>();
		for(int i=1;i<=columnCount;i++)
		{
			columnName[i-1]=metaData.getColumnLabel(i);
			if(i!=1)
				categoryList.add(columnName[i-1]);
		}
		
		categoryMap.put(columnName[0],categoryList);
		
		while(rs.next())
		{
			categoryList=new ArrayList<String>();
			String id=rs.getString(1);
			String name=rs.getString(2);
			categoryList.add(name);
			categoryMap.put(id,categoryList);
		}
		
		
		
		return categoryMap;
		
	}

}
