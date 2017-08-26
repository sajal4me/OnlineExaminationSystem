package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	
	public String register(AdminDTO aDTO) throws ClassNotFoundException, SQLException
	{
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		PreparedStatement pstmt=null;
		Connection con=commonDAOObject.getConnection();
		
		pstmt=con.prepareStatement(SQLConstants.REGISTER_SQL_ADMIN);
		pstmt.setString(1, aDTO.getName());
		pstmt.setString(2, aDTO.getEmail());
		pstmt.setString(3, aDTO.getEmail());
		
		int recordEffected=pstmt.executeUpdate();
		if(recordEffected>0)
			return StatusConstants.SUCCESS;
		else
			return StatusConstants.FAIL;
		
	}
	
	public String login(AdminDTO aDTO) throws ClassNotFoundException, SQLException
	{
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		pstmt=con.prepareStatement(SQLConstants.LOGIN_SQL_ADMIN);
		pstmt.setString(1, aDTO.getEmail());
		pstmt.setString(2, aDTO.getPassword());
		rs=pstmt.executeQuery();
		
		if(rs.next())
		{
			return StatusConstants.SUCCESS;
		}
		return StatusConstants.FAIL;
		
		
	}

}
