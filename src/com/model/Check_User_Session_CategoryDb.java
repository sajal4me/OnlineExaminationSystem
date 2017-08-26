package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Check_User_Session_CategoryDb {
	
	public Map<Integer,List<String>> fetchData() throws ClassNotFoundException, SQLException
	{
		Map<Integer,List<String>> catsettopMap=new LinkedHashMap<Integer,List<String>>();
		List<String> catsettopList=new ArrayList<String>();
		int i=0;
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.CATEGORY_DETAILS);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			catsettopList=new ArrayList<String>();
			catsettopList.add(rs.getString(1));
			catsettopList.add(rs.getString(2));
			catsettopList.add(rs.getString(3));
			
			catsettopMap.put(i, catsettopList);
			i++;
			
			
		}
		
		System.out.println(catsettopList);
		
		
		
		
		
		
		return catsettopMap;
		
	}

}
