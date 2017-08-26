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

public class Check_User_Session_SetDb {
	
	public Map<Integer,List<String>> setData(String categoryName) throws SQLException, ClassNotFoundException
	{
		
		//Map to Store Id And Number of Question In A set.
		Map<Integer,List<String>> setIdQuesMap=new LinkedHashMap<Integer,List<String>>();
		List<String> setList=new ArrayList<String>();
		int i=0;
		
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GETSET_ID_QUES);
		pstmt.setString(1, categoryName);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			setList=new ArrayList<String>();
			String setId=rs.getString("set_id");
			String setQues=rs.getString("no_of_question");
			System.out.println(setId+"  "+setQues);
			setList.add(setId);
			setList.add(setQues);
			setIdQuesMap.put(i, setList);
			i++;
			
		}
		
		System.out.println(setIdQuesMap);
		
		return setIdQuesMap;
		
		
	}

}
