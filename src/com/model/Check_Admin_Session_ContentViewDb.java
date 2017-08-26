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

public class Check_Admin_Session_ContentViewDb {
	
	public Map<String,ArrayList<String>> data() throws ClassNotFoundException, SQLException
	{
		int i=0;
		Map<String,ArrayList<String>> setData=new LinkedHashMap<String,ArrayList<String>>();
		ArrayList<String> setList;
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.SELECT_SET);
		ResultSet rs=pstmt.executeQuery();
		
		// Taking out Column Name From DataBase.
		ResultSetMetaData rsMeta=rs.getMetaData();
		int count=rsMeta.getColumnCount();
		String columnName[]=new String[count];
		setList=new ArrayList<String>();
		for(i=1;i<=count;i++)
		{
			columnName[i-1]=rsMeta.getColumnLabel(i);
			System.out.println(columnName[i-1]);
			if(i!=1)
			setList.add(columnName[i-1]);
			
		}
		
		//Putting Column Name in Map.
		setData.put(columnName[0],setList );
		
		
		while(rs.next())
		{
			setList=new ArrayList<String>();
			Integer i1=rs.getInt("category_ref");
			Integer i2=rs.getInt("no_of_question");
			setList.add(i1.toString());
			setList.add(i2.toString());
			
			Integer mapId=rs.getInt("set_id");
			setData.put(mapId.toString(), setList);
			System.out.println(setData);
			System.out.println(i++);
			
			
		}
		System.out.println(setData.get(0));
		System.out.println(setData.get(1));
		rs.close();
		con.close();
		
		return setData;
		
	}
	
	public Map<String,ArrayList<String>> data(String categoryId) throws ClassNotFoundException, SQLException
	{
		int i=0;
		Map<String,ArrayList<String>> setData=new LinkedHashMap<String,ArrayList<String>>();
		ArrayList<String> setList;
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GET_PARTICULAR_SET);
		pstmt.setString(1, categoryId);
		ResultSet rs=pstmt.executeQuery();
		
		// Taking out Column Name From DataBase.
		ResultSetMetaData rsMeta=rs.getMetaData();
		int count=rsMeta.getColumnCount();
		String columnName[]=new String[count];
		setList=new ArrayList<String>();
		for(i=1;i<=count;i++)
		{
			columnName[i-1]=rsMeta.getColumnLabel(i);
			System.out.println(columnName[i-1]);
			if(i!=1)
			setList.add(columnName[i-1]);
			
		}
		
		//Putting Column Name in Map.
		setData.put(columnName[0],setList );
		
		
		while(rs.next())
		{
			setList=new ArrayList<String>();
			Integer i1=Integer.parseInt(categoryId);
			Integer i2=rs.getInt("no_of_question");
			setList.add(i1.toString());
			setList.add(i2.toString());
			
			Integer mapId=rs.getInt("set_id");
			setData.put(mapId.toString(), setList);
			System.out.println(setData);
			System.out.println(i++);
			
			
		}
		System.out.println(setData.get(0));
		System.out.println(setData.get(1));
		rs.close();
		con.close();
		
		return setData;
		
	}

}
