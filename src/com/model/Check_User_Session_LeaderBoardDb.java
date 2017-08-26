package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check_User_Session_LeaderBoardDb {
	
	public Map<Integer,List<String>> data() throws ClassNotFoundException, SQLException
	{
		Map<Integer,List<String>> leadMap=new HashMap<Integer,List<String>>();
		
		List<String> leadList=new ArrayList<String>();
		int counter=0;
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.TOP5_USER);
		ResultSet rsLead=pstmt.executeQuery();
		
		//Getting MetaData of Table.
		ResultSetMetaData rsMetaData = rsLead.getMetaData();
	    int numberOfColumns = rsMetaData.getColumnCount();
	    for (int i = 1; i < numberOfColumns + 1; i++) {
	      String columnName = rsMetaData.getColumnName(i);
	      leadList.add(columnName);
	    }
		
	    leadMap.put(counter, leadList);
	    counter++;
		
		while(rsLead.next())
		{
			leadList=new ArrayList<String>();
			leadList.add(rsLead.getString(1));
			leadList.add(rsLead.getString(2));
			leadList.add(rsLead.getString(3));
			
			leadMap.put(counter, leadList);
			
			counter++;
			
		}
		
		
		return leadMap;
	}

}
