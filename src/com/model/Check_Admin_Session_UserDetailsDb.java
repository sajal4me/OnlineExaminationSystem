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

public class Check_Admin_Session_UserDetailsDb {
	
	public Map<Integer,List<String>> getData() throws SQLException, ClassNotFoundException
	{
		int counter=0;
		Map<Integer,List<String>> userDetailsMap=new HashMap<Integer,List<String>>();
		List<String> userDetailsList=new ArrayList<String>();
		
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GET_USER_DETAILS);
		ResultSet rs=pstmt.executeQuery();
		
		ResultSetMetaData rsMeta=rs.getMetaData();
		int columnSize=0;
		columnSize=rsMeta.getColumnCount();
		for(int i=1;i<=columnSize;i++)
		{
			userDetailsList.add(rsMeta.getColumnName(i));
		}
		
		userDetailsMap.put(counter, userDetailsList);
		
		counter++;
		
		while(rs.next())
		{
			userDetailsList=new ArrayList<String>();
			for(int i=1;i<=7;i++)
			{
				if(i!=6)
				userDetailsList.add(rs.getString(i));
				else
				{
					// Getting SecurityName From Id.
					String security_id=rs.getString(i);
					PreparedStatement pstmtSecurity=con.prepareStatement(SQLConstants.GET_SECURITY_ID);
					pstmtSecurity.setString(1, rs.getString(i));
					ResultSet rsSecName=pstmtSecurity.executeQuery();
					rsSecName.next();
					String securityQuestion=rsSecName.getString(1);
					userDetailsList.add(securityQuestion);
				}
			}
			
			userDetailsMap.put(counter,userDetailsList);
			counter++;
		}
		
		return userDetailsMap;
		
		
		
		
		
	}

}
