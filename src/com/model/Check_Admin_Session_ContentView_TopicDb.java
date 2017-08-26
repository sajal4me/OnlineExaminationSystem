package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Check_Admin_Session_ContentView_TopicDb {
	
	public Map<String,List<String>> data() throws SQLException, ClassNotFoundException
	{
		Map<String,List<String>> topicMap=new LinkedHashMap<String,List<String>>();
		List<String> topicList ;
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.SELECT_TOPIC);

		ResultSet rs=pstmt.executeQuery();
		
		ResultSetMetaData metaData=rs.getMetaData();
		int columnCount=metaData.getColumnCount();
		String columnName[]=new String[columnCount];
		
		//Storing ColumnName in List.
				topicList=new ArrayList<String>();
		for(int i=1;i<=columnCount;i++)
		{
			columnName[i-1]=metaData.getColumnLabel(i);
			if(i!=1)
				topicList.add(columnName[i-1]);
		}
		
		topicMap.put(columnName[0],topicList);
		
		while(rs.next())
		{
			topicList=new ArrayList<String>();
			String id=rs.getString(1);
			String categoryRef=rs.getString(2);
			String topicName=rs.getString(3);
			topicList.add(categoryRef);
			topicList.add(topicName);
			topicMap.put(id,topicList);
		}
		
		System.out.println(topicMap);
		
		return topicMap;
		
	}
	
	public Map<String,List<String>> data(String categoryId) throws SQLException, ClassNotFoundException
	{
		Map<String,List<String>> topicMap=new LinkedHashMap<String,List<String>>();
		List<String> topicList ;
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GET_PARTICULAR_TOPIC);
		pstmt.setString(1, categoryId);

		ResultSet rs=pstmt.executeQuery();
		
		ResultSetMetaData metaData=rs.getMetaData();
		int columnCount=metaData.getColumnCount();
		String columnName[]=new String[columnCount];
		
		//Storing ColumnName in List.
				topicList=new ArrayList<String>();
		for(int i=1;i<=columnCount;i++)
		{
			columnName[i-1]=metaData.getColumnLabel(i);
			if(i!=1)
				topicList.add(columnName[i-1]);
		}
		
		topicMap.put(columnName[0],topicList);
		
		while(rs.next())
		{
			topicList=new ArrayList<String>();
			String id=rs.getString("topic_id");
			String categoryRef=categoryId;
			String topicName=rs.getString("topic_name");
			topicList.add(categoryRef);
			topicList.add(topicName);
			topicMap.put(id,topicList);
		}
		
		System.out.println(topicMap);
		
		return topicMap;
		
	}

}


