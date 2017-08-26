package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check_Admin_Session_UserScoreDb {
	
	public Map<Integer,List<String>> getScore() throws SQLException, ClassNotFoundException
	{
		Map<Integer,List<String>> userScoreMap=new HashMap<Integer,List<String>>();
		List<String> userScoreList=new ArrayList<String>();
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.ALL_USER_SCORE);
		ResultSet rsScore=pstmt.executeQuery();
		
		int mapCounter=0;
		
		ResultSetMetaData rsScoreMeta=pstmt.getMetaData();
		int columnCount=rsScoreMeta.getColumnCount();
		for(int i=1;i<=columnCount;i++)
		{
			userScoreList.add(rsScoreMeta.getColumnName(i));
		}
		
		userScoreMap.put(mapCounter, userScoreList);
		mapCounter++;
		
		/*int rowSize= 0;
		if (rsScore != null)   
		{  
		  rsScore.beforeFirst();  
		  rsScore.last();  
		  rowSize = rsScore.getRow();  
		}  
		
		System.out.println("Row Size:"+rowSize);*/
		
		
		while(rsScore.next())
		{
			userScoreList=new ArrayList<String>();
			for(int i=1;i<=columnCount;i++)
			{
				userScoreList.add(rsScore.getString(i));
			}
				userScoreMap.put(mapCounter, userScoreList);
				mapCounter++;
		}
		
		return userScoreMap;
		
	}

}
