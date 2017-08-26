package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Check_User_Session_TopicDb {
	
	public Map<Integer,List<String>> topicData(String categoryName) throws SQLException, ClassNotFoundException
	{
		System.out.println("**Model**--Check_User_Session_TopicDb");
		//Data to store Topic Id And name and return to the controller.
		Map<Integer,List<String>> topicIdNameMap=new LinkedHashMap<Integer,List<String>>();
		List<String> topicList=new ArrayList<String>();
		int i=0;
		
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GETTOPIC_ID_NAME);
		pstmt.setString(1, categoryName);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			topicList=new ArrayList<String>();
			String topicId=rs.getString("topic_id");
			String topicName=rs.getString("topic_name");
			System.out.println(topicId+"  "+topicName);
			topicList.add(topicId);
			topicList.add(topicName);
			topicIdNameMap.put(i, topicList);
			i++;
		}
		
		System.out.println(topicIdNameMap);
		
		return topicIdNameMap;
		
	}

}
