package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Check_User_Session_GiveTestDb {
	
	String subcatName="";
	String comId="";
	String categoryName="";
	
	
	public HashMap<Integer,List<String>> getQuestion(String subcatName,String comId,String categoryName) throws ClassNotFoundException, SQLException
	{
		
		System.out.println(subcatName+" "+comId+" "+categoryName);
		String setId="",topicId="";
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		HashMap<Integer,List<String>> questionMap=new LinkedHashMap<Integer,List<String>>();
		List<String> questionList;
		
		PreparedStatement pstmtCat=con.prepareStatement(SQLConstants.GET_CATEGORY_ID);
		pstmtCat.setString(1, categoryName);
		ResultSet rsCat=pstmtCat.executeQuery();
		rsCat.next();
		String catId=rsCat.getString("category_id");
		int i=0;
		PreparedStatement pstmtSetTopicQues;
		if(subcatName.equalsIgnoreCase("set") || subcatName.equalsIgnoreCase("topic"))
		{
			
			
			if(subcatName.equalsIgnoreCase("set") )
			{
				setId=comId;
				pstmtSetTopicQues=con.prepareStatement(SQLConstants.GET_SET_QUES);
				pstmtSetTopicQues.setString(1, setId);
			}
			
			else
			{
				topicId=comId;
				pstmtSetTopicQues=con.prepareStatement(SQLConstants.GET_TOPIC_QUES);
				pstmtSetTopicQues.setString(1, topicId);
			}
			pstmtSetTopicQues.setString(2, catId);
			ResultSet rsSetTOpicQues=pstmtSetTopicQues.executeQuery();
			while(rsSetTOpicQues.next())
			{
				questionList=new ArrayList<String>();
				String question_no=rsSetTOpicQues.getString(1);
				questionList.add(question_no);
				
				String question=rsSetTOpicQues.getString(2);
				questionList.add(question);
				
				String option_a=rsSetTOpicQues.getString(3);
				questionList.add(option_a);
				
				String option_b=rsSetTOpicQues.getString(4);
				questionList.add(option_b);
				
				String option_c=rsSetTOpicQues.getString(5);
				questionList.add(option_c);
				
				String option_d=rsSetTOpicQues.getString(6);
				questionList.add(option_d);
				
				String answer=rsSetTOpicQues.getString(7);
				questionList.add(answer);
				
				
				questionMap.put(i, questionList);
				i++;
				
			}
			
		}
		
		return questionMap;
		
		
	}
	

}
