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

public class Check_User_Session_ScoreCardDb {
	
	public Map<Integer,List<String>> data(String emailId) throws SQLException, ClassNotFoundException
	{
		System.out.println("**Model**-Check_User_Session_ScoreCardDb");
		
		int counterMap=0;
		Map<Integer,List<String>> scoreMap=new HashMap<Integer,List<String>>(); 
		List<String> scoreList=new ArrayList<String>();
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con = null;
		try {
			con = commonDAOObject.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GET_USER_SCORE);
		
		pstmt.setString(1, emailId);
		System.out.println(emailId);
		
		
		ResultSet rs=pstmt.executeQuery();
		ResultSetMetaData rsmetaData=rs.getMetaData();
		
		int columnCount=rsmetaData.getColumnCount();
		
		for(int i=1;i<=columnCount;i++)
		{
			scoreList.add(rsmetaData.getColumnName(i));
		}
		scoreMap.put(counterMap,scoreList);
		
		counterMap++;
		
		
		System.out.println("Outside Of Loop");
		while(rs.next())
		{
			System.out.println("Inside Of Loop");
			scoreList=new ArrayList<String>();
			for(int i=1;i<=10;i++)
			{
				
					if(i!=9)
					scoreList.add(rs.getString(i));
					
					else //Changing For Category Id To CategoryName
					{
						
						PreparedStatement pstmtCat=con.prepareStatement(SQLConstants.GET_CATEGORY_NAME);
						System.out.println(rs.getString((i)));
						pstmtCat.setString(1, rs.getString(i));
						
						ResultSet rsCat=pstmtCat.executeQuery();
						rsCat.next();
						scoreList.add(rsCat.getString(1));
						
					}
			}
			scoreMap.put(counterMap, scoreList);
			counterMap++;
		}
		
		
		
		return scoreMap;
		
		
		
	}

}
