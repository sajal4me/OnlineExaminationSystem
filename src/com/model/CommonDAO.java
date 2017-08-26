package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CommonDAO {
													// Singleton class
	private static CommonDAO commonDAOObject;
	
	private CommonDAO(){
		
	}
	
	static CommonDAO getCommonDAOObject()
	{
		synchronized(CommonDAO.class)
		{
			if(commonDAOObject==null)
			{
				commonDAOObject=new CommonDAO();
			}
		}
		
		return commonDAOObject;
	}
	
	public static CommonDAO getNewCommonDAOObject()
	{
		return CommonDAO.commonDAOObject;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		ResourceBundle rb=ResourceBundle.getBundle("com.model/db");
		Class.forName(rb.getString("drivername"));
		con=DriverManager.getConnection(rb.getString("dburl"),rb.getString("userid"),rb.getString("password"));
		return con;
	}

}
