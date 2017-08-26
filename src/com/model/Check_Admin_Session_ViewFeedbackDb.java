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

public class Check_Admin_Session_ViewFeedbackDb {
	
	public Map<String,List<String>> data() throws SQLException, ClassNotFoundException
	{
		Map<String,List<String>> feedbackMap=new LinkedHashMap<String,List<String>>();
		List<String> feedbackList ;
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.USER_FEEDBACK);

		ResultSet rs=pstmt.executeQuery();
		
		ResultSetMetaData metaData=rs.getMetaData();
		int columnCount=metaData.getColumnCount();
		String columnName[]=new String[columnCount];
		
		//Storing ColumnName in List.
				feedbackList=new ArrayList<String>();
		for(int i=1;i<=columnCount;i++)
		{
			columnName[i-1]=metaData.getColumnLabel(i);
			if(i!=1)
				feedbackList.add(columnName[i-1]);
		}
		
		feedbackMap.put(columnName[0],feedbackList);
		
		while(rs.next())
		{
			feedbackList=new ArrayList<String>();
			String id=rs.getString(1);
			String email=rs.getString(2);
			String feedback=rs.getString(3);
			String time=rs.getString(4);
			feedbackList.add(email);
			feedbackList.add(feedback);
			feedbackList.add(time);
			feedbackMap.put(id,feedbackList);
		}
		
		
		
		return feedbackMap;
		
	}

}

