package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionDb {
	
	public SetTop getSetTop(String categoryId) throws SQLException, ClassNotFoundException
	{
		int mapCounter=0;
		List<Set> setList=new ArrayList<Set>();
		List<Topic> topicList=new ArrayList<Topic>();
		
		
		
		
		SetTop sT=new SetTop();
		
		
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmtSet=con.prepareStatement(SQLConstants.GET_SET_FOR_CATEGORY);
		PreparedStatement pstmtTopic=con.prepareStatement(SQLConstants.GET_TOPIC_FOR_CATEGORY);
		
		pstmtSet.setString(1, categoryId);
		pstmtTopic.setString(1, categoryId);
		
		ResultSet rsSet=pstmtSet.executeQuery();
		ResultSet rsTopic=pstmtTopic.executeQuery();
		
		while(rsSet.next())
		{
			Set   setData=new Set();
			setData.setSetId(rsSet.getInt(1));
			setList.add(setData);
		}
		
		//Add Set List To SetTop POJO.
		sT.setSet(setList);
		
		while(rsTopic.next())
		{
			Topic topicData=new Topic();
			topicData.setTopicId(rsTopic.getInt(1));
			topicData.setTopicName(rsTopic.getString(2));
			topicList.add(topicData);
		}
		
		sT.setTopic(topicList);
		
		
		
		return sT;
		
		
		
		
		
	}

}
