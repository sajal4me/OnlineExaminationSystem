package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Check_Admin_Session_ContentView_QuestionDb {
	
	public Map<String,List<String>> data() throws ClassNotFoundException, SQLException
	{
		int i;
		Map<String,List<String>> questionMap=new LinkedHashMap<String,List<String>>();
		List<String> questionList;
		// Making Connection.
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.SELECT_QUESTION);
		
		ResultSet rs=pstmt.executeQuery();
		
		//Getting ColumnNames.
		
		ResultSetMetaData rsMeta=rs.getMetaData();
		int columnCount=rsMeta.getColumnCount();
		String[] columnName=new String[columnCount];
		
		//Storing ColumnName in List.
		questionList=new ArrayList<String>();
		for(i=1;i<=columnCount;i++)
		{
			columnName[i-1]=rsMeta.getColumnLabel(i);
			if(i!=1)
			questionList.add(columnName[i-1]);
		}
		questionMap.put(columnName[0],questionList);
		
		//Storing Values Of Table In Map.
		
		while(rs.next())
		{
			questionList=new ArrayList<String>();
			String qNo=rs.getString(1);
			String question=rs.getString(2);
			questionList.add(question);
			String optionA=rs.getString(3);
			questionList.add(optionA);
			String optionB=rs.getString(4);
			questionList.add(optionB);
			String optionC=rs.getString(5);
			questionList.add(optionC);
			String optionD=rs.getString(6);
			questionList.add(optionD);
			String answer=rs.getString(7);
			questionList.add(answer);
			String set=rs.getString(8);
			questionList.add(set);
			String topic=rs.getString(9);
			questionList.add(topic);
			String category=rs.getString(10);
			questionList.add(category);
			
			questionMap.put(qNo, questionList);
			
		}
	
		return questionMap;
		
		
	}
	
	public Map<String,List<String>> data(String categoryId) throws ClassNotFoundException, SQLException
	{
		int i;
		Map<String,List<String>> questionMap=new LinkedHashMap<String,List<String>>();
		List<String> questionList;
		// Making Connection.
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GET_PARTICULAR_QUESTION);
		pstmt.setString(1, categoryId);
		
		ResultSet rs=pstmt.executeQuery();
		
		//Getting ColumnNames.
		
		ResultSetMetaData rsMeta=rs.getMetaData();
		int columnCount=rsMeta.getColumnCount();
		String[] columnName=new String[columnCount];
		
		//Storing ColumnName in List.
		questionList=new ArrayList<String>();
		for(i=1;i<=columnCount;i++)
		{
			columnName[i-1]=rsMeta.getColumnLabel(i);
			if(i!=1)
			questionList.add(columnName[i-1]);
		}
		questionMap.put(columnName[0],questionList);
		
		//Storing Values Of Table In Map.
		
		while(rs.next())
		{
			questionList=new ArrayList<String>();
			String qNo=rs.getString(1);
			String question=rs.getString(2);
			questionList.add(question);
			String optionA=rs.getString(3);
			questionList.add(optionA);
			String optionB=rs.getString(4);
			questionList.add(optionB);
			String optionC=rs.getString(5);
			questionList.add(optionC);
			String optionD=rs.getString(6);
			questionList.add(optionD);
			String answer=rs.getString(7);
			questionList.add(answer);
			String set=rs.getString(8);
			questionList.add(set);
			String topic=rs.getString(9);
			questionList.add(topic);
			String category=categoryId;
			questionList.add(category);
			
			questionMap.put(qNo, questionList);
			
		}
	
		return questionMap;
		
		
	}

}
