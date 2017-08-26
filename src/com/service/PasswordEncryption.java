package com.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordEncryption {

	//-----------------------------------------------------------------------
	private  static SecureRandom random = new SecureRandom();
	//  static  String saltNo;
	//private static String salt;
	private static  PasswordEncryption obj;
	private PasswordEncryption() {
		
	}
	public static PasswordEncryption getInstanse(){
		if (obj==null){
			obj=new  PasswordEncryption();
		}
		return obj;
	}
	public Object clone (){
		return this;
	}
	
	public  List<String> hashPassword(String password_plaintext) {
		String salt=genSalt()+"";
		List<String> list = hashpw(password_plaintext, salt);
		return(list);
	}
	
	public static String genSalt() {
		String   saltNo= new BigInteger(130, random).toString(32);
		return saltNo;
	}
	
	protected static List<String> hashpw(String user_password_plaintext,String salt){
		 List<String> ls=new ArrayList<String>();
		 String password_hashCode=  user_password_plaintext.hashCode()+"";
		 String hashCodeSalt= salt.hashCode()+"";
		 String encryptedPassword=password_hashCode+hashCodeSalt;
		 System.out.println("hash code of 2 string with salt "+ encryptedPassword);
		 System.out.println("length of final hash code "+ encryptedPassword.length());
		 ls.add(encryptedPassword);
		 ls.add(salt);
		 return ls;
	
	}
	 
	
	public  boolean checkPassword(String  user_password_plaintext, String EncodedPassInDB,String salt) {
		boolean password_verified = false;

		/*if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");*/
		System.out.println("here12 Password Encryption class in service");
		password_verified = checkpw( user_password_plaintext,EncodedPassInDB,salt);
		System.out.println("user_password_plaintext "+user_password_plaintext);
		System.out.println("EncodedPassInDB "+EncodedPassInDB);
		System.out.println("salt"+salt);
		System.out.println("here15 Password Encryption class in service");
		System.out.println("String match or not true /false :- "+password_verified);
		return(password_verified);
	}
	
	protected static boolean checkpw(String user_password_plaintext,String EncodedPassInDB, String salt){
		System.out.println("here13 Password Encryption class in service");
		List<String> ls= hashpw( user_password_plaintext,salt);
		System.out.println("here14 Password Encryption class in service");
		 if (ls.get(0).equals(EncodedPassInDB)){
			 System.out.println("bc");
			 return true;
		 }
		
		 return false;
	 }
	
	
	
	
	
	
	
	
	

}
