package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.service.PasswordEncryption;

public class UserDAO {
	
	public String register(UserDTO uDTO) throws ClassNotFoundException, SQLException
	{
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		Connection con=commonDAOObject.getConnection();
		PreparedStatement pstmt=null;
		pstmt=con.prepareStatement(SQLConstants.Register_SQL_USER);
		pstmt.setString(1, uDTO.getName());
		pstmt.setString(2, uDTO.getEmail());
		pstmt.setString(3, uDTO.getPass());
		pstmt.setString(4,uDTO.getSalt());
		pstmt.setLong(5, uDTO.getMobileNumber());
		pstmt.setString(6, uDTO.getSecurity_id());
		pstmt.setString(7, uDTO.getAnswer());
		
		
		int recordEffected=pstmt.executeUpdate();
		if(recordEffected>0)
		{
			return StatusConstants.SUCCESS;
		}
		else
		{
			return StatusConstants.FAIL;
		}
		
	}
	
	public String login(UserDTO uDTO) throws ClassNotFoundException, SQLException
	{
		System.out.println("here7");
		ResultSet rs=null;
		Connection con=null;
		CommonDAO commonDAOObject=CommonDAO.getCommonDAOObject();
		con=commonDAOObject.getConnection();
		System.out.println("here8");
		PreparedStatement pstmtSalt=con.prepareStatement(SQLConstants.GET_SALT);
		pstmtSalt.setString(1, uDTO.getEmail());
		ResultSet rsSalt=pstmtSalt.executeQuery();
		rsSalt.next();
		System.out.println("here9");
		String salt=rsSalt.getString(1);
	   System.out.println("salt "+salt);
		PreparedStatement pstmt=null;
		pstmt=con.prepareStatement(SQLConstants.LOGIN_SQL_USER);
		pstmt.setString(1, uDTO.getEmail());
	//	pstmt.setString(2, uDTO.getPass());
		rs=pstmt.executeQuery();
		String EncodedPassInDB="";
		System.out.println("here10");
		while (rs.next()){
			
		 EncodedPassInDB=rs.getString(2);
		}// return encoded password which is store in Database 
		String user_password_plaintext=uDTO.getPass();
		
		System.out.println("user_password_plaintext "+user_password_plaintext);
		System.out.println("EncodedPassInDB"+EncodedPassInDB);
		// Call PasswordEncryption class in Service Method To generate hashCode of salt and match with user's password at SignIn time
		System.out.println("here11");
				PasswordEncryption obj=PasswordEncryption.getInstanse();
				boolean b =obj.checkPassword( user_password_plaintext, EncodedPassInDB, salt);
				System.out.println("here16 in User Dao Class");	
		if(b)
		{
			return StatusConstants.SUCCESS;
		}
		return StatusConstants.FAIL;
	}

}
