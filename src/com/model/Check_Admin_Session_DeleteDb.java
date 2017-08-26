package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Check_Admin_Session_DeleteDb {
	
	public HashMap<Integer,List<String>> deleteAny(String deleteIndex,String category) throws ClassNotFoundException, SQLException
	{
		System.out.println("**Check_Admin_session_DeleteDb**");
		HashMap<Integer,List<String>> deleteAnyMap=new HashMap<Integer,List<String>>();
		List<String> deleteAnyList;
		int x=new Integer(deleteIndex);
		int categoryIndex=new Integer(category);
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		
		
		if(x==1)
		{
			PreparedStatement pstmtCat=con.prepareStatement(SQLConstants.SELECT_CATEGORY);
			ResultSet rsCat=pstmtCat.executeQuery();
			while(rsCat.next())
			{
				deleteAnyList=new ArrayList<String>();
				deleteAnyList.add(rsCat.getString(2));
				deleteAnyMap.put(rsCat.getInt(1),deleteAnyList );
				
			}
		}
		else if(x==2)
		{
			PreparedStatement pstmtSet=con.prepareStatement(SQLConstants.GET_SET_FOR_CATEGORY);
			pstmtSet.setString(1, category);
			ResultSet rsSet=pstmtSet.executeQuery();
			int counter=0;
			while(rsSet.next())
			{
				deleteAnyList=new ArrayList<String>();
				deleteAnyList.add(rsSet.getString(1));
				
				deleteAnyMap.put(rsSet.getInt(1), deleteAnyList);
				
			}
			
			System.out.println(deleteAnyMap);
			
		}
		
		
		else if(x==3)
		{
			PreparedStatement pstmtTopic=con.prepareStatement(SQLConstants.GET_TOPIC_FOR_CATEGORY);
			pstmtTopic.setString(1, category);
			ResultSet rsTopic=pstmtTopic.executeQuery();
			while(rsTopic.next())
			{
				
				deleteAnyList=new ArrayList<String>();
				deleteAnyList.add(rsTopic.getString(2));
				deleteAnyMap.put(rsTopic.getInt(1), deleteAnyList);
			}
			
		}
		
		else if(x==4)
		{
			PreparedStatement pstmtQuestion=con.prepareStatement(SQLConstants.GET_QUESTION_FOR_CATEGORY);
			pstmtQuestion.setString(1, category);
			ResultSet rsQuestion=pstmtQuestion.executeQuery();
			while(rsQuestion.next())
			{
				deleteAnyList=new ArrayList<String>();
				deleteAnyList.add(rsQuestion.getString(2));
				
				deleteAnyMap.put(rsQuestion.getInt(1), deleteAnyList);
			}
			
		}
		
		return deleteAnyMap;
		
	}

}
