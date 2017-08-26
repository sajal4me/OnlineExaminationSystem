package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Check_Admin_Session_ModifyCategory_UpdateDb {
	
	CommonDAO commonDAOObject;
	Connection con;
	
	public void makeConnection() throws ClassNotFoundException, SQLException
	{
		commonDAOObject=CommonDAO.getCommonDAOObject();
		con=commonDAOObject.getConnection();
	}
	
	public List<String> getQuestionData(String optionSelected) throws ClassNotFoundException, SQLException
	{
		List<String> questionContainer=new LinkedList<String>();
		
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.SELECT_PARTICULAR_QUESTION);
		pstmt.setString(1,optionSelected );
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			String question=rs.getString(1);
			String option_a=rs.getString(2);
			String option_b=rs.getString(3);
			String option_c=rs.getString(4);
			String option_d=rs.getString(5);
			String answer=rs.getString(6);
			questionContainer.add(question);
			questionContainer.add(option_a);
			questionContainer.add(option_b);
			questionContainer.add(option_c);
			questionContainer.add(option_d);
			questionContainer.add(answer);
		}
		return questionContainer;
	}
	
	public List<String> getSetData(String optionSelected) throws SQLException
	{
		List<String> categorySet=new LinkedList<String>();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.SELECT_PARTICULAR_SET);
		pstmt.setString(1,optionSelected);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			String noOfQuestion=rs.getString(1);
			System.out.println(noOfQuestion);
			categorySet.add(noOfQuestion);
		}
		System.out.println(categorySet+"cvbgcffgb");
		return categorySet;
		
	}
	
	public List<String> getTopicData(String optionSelected) throws SQLException
	{
		List<String> topic=new LinkedList<String>();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.SELECT_PARTICULAR_TOPIC);
		pstmt.setString(1,optionSelected);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			String topicName=rs.getString(1);
			topic.add(topicName);
		}
		return topic;
	}

}
