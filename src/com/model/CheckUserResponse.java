package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.json.JSONException;

public class CheckUserResponse {
	
	CommonDAO commonDAOObject;
	Connection con;
	
	List<String> scoreList=new ArrayList<String>();
	
	public List<String> data(Map<Integer,Integer> quesMap,Map<Integer,Integer> solMap,String emailId,String time,String catName,String subcatName,String comId) throws ClassNotFoundException, SQLException, JSONException
	{
		
		String status;
		List<Integer> realSolution=new ArrayList<Integer>();
		commonDAOObject=CommonDAO.getCommonDAOObject();
		con=commonDAOObject.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLConstants.GET_ANSWER);
		ResultSet rs;
		
		
		System.out.println(quesMap+"  "+solMap);
		
		// Finding Real Solution Of Questions.
		for(Integer key:quesMap.keySet())
		{
			
			String val=quesMap.get(key).toString();
			pstmt.setString(1, val);
			rs=pstmt.executeQuery();
			rs.next();
			realSolution.add(rs.getInt(1));
			
		}
		
		System.out.println(realSolution);
		
		//Checking User Solution With The Real Solution.
		int correct=0,wrong=0,unanswered=0;
		
		
		int quesmapSize=quesMap.size();
		int solmapSize=solMap.size();
		unanswered=quesmapSize-solmapSize;
		
		for(Integer key:solMap.keySet())
		{
			Integer val=solMap.get(key);
			
			if(val.equals(realSolution.get(key)))
			{
				correct++;
			}
			else
			{
				wrong++;
			}
		}
		
		System.out.println("Correct= "+correct+"\nUnanswered= "+unanswered+"\nWrong= "+wrong);
		
		status=saveUserResponse(correct,unanswered,wrong,emailId,time,catName,subcatName,comId);
		
		System.out.println(scoreList);
		
		return scoreList;
	
	}
	
	public String saveUserResponse(int correct,int unanswered,int wrong,String emailId,String time,String catName,String subcatName,String comId) throws SQLException
	{
		int setId,topicId;
		System.out.println("***Mujhe Dekho***");
		System.out.println(correct+ " "+ unanswered+ " "+wrong+" "+emailId+" "+time+"  "+catName+" "+subcatName+" "+comId);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String curTimeForDb=(dateFormat.format(date));
		
		
		int curMin = 0,curSec = 0;
		int storeMin,storeSec;
	
		double storeTime;
		
		StringTokenizer timeToken=new StringTokenizer(time,":");
		while(timeToken.hasMoreTokens())
		{
			curMin=Integer.parseInt(timeToken.nextToken());
		    curSec=Integer.parseInt(timeToken.nextToken());
		    System.out.println(curMin+ "  "+curSec);
		}
		
		storeMin=(((correct+unanswered+wrong)*2)-(curMin+1));
		storeSec=60-curSec;
		
		storeMin=Math.abs(storeMin);
		storeSec=Math.abs(storeSec);
		
		storeTime=Double.parseDouble(((storeMin+"."+storeSec)));
		
		System.out.println("StoreTime:"+storeTime+"Curr Time:"+curMin);
		int marks;
		marks=(correct)*2;
		
		//Common Things In SET/TOPIC.
		PreparedStatement pstmtCat=con.prepareStatement(SQLConstants.GET_CATEGORY_ID);
		pstmtCat.setString(1, catName);
		ResultSet rsCat=pstmtCat.executeQuery();
		rsCat.next();
		int catId=Integer.parseInt(rsCat.getString(1));
		
		
		
		
		
		
		if(subcatName.equals("topic"))
		{
			topicId=Integer.parseInt(comId);
			PreparedStatement pstmt=con.prepareStatement(SQLConstants.SAVE_TEST_DATA_BY_TOPIC);
			pstmt.setString(1, emailId);
			pstmt.setInt(2, marks);
			pstmt.setDouble(3,storeTime);
			pstmt.setInt(4,(correct+wrong));
			pstmt.setInt(5,correct );
			pstmt.setInt(6, wrong);
			pstmt.setInt(7, (correct+wrong+unanswered));
			pstmt.setInt(8,topicId);
			pstmt.setInt(9,catId);
			pstmt.setString(10, curTimeForDb);
			int rs=pstmt.executeUpdate();
			if(rs>0)
			{
				String markStr=marks+"";
				String storeTimeStr=storeTime+"";
				String questionAttemptedStr=(correct+wrong)+"";
				String correctStr=correct+"";
				String wrongStr=wrong+"";
				String totalStr=(correct+wrong+unanswered)+"";
				
				
				scoreList.add(markStr);
				scoreList.add(storeTimeStr);
				scoreList.add(questionAttemptedStr);
				scoreList.add(correctStr);
				scoreList.add(wrongStr);
				scoreList.add(totalStr);
				
				
				return StatusConstants.SUCCESS;
			}
			else
			{
				return StatusConstants.FAIL;
			}
			
			
			
			
		}
		else if(subcatName.equals("set"))
		{
			setId=Integer.parseInt(comId);
			PreparedStatement pstmt=con.prepareStatement(SQLConstants.SAVE_TEST_DATA_BY_SET);
			
			pstmt.setString(1, emailId);
			pstmt.setInt(2,marks );
			pstmt.setDouble(3, storeTime);
			pstmt.setInt(4,(correct+wrong));
			pstmt.setInt(5,correct );
			pstmt.setInt(6, wrong);
			pstmt.setInt(7, (correct+wrong+unanswered));
			pstmt.setInt(8,setId);
			pstmt.setInt(9,catId);
			pstmt.setString(10, curTimeForDb);
			int rs=pstmt.executeUpdate();
			if(rs>0)
			{
				String markStr=marks+"";
				String storeTimeStr=storeTime+"";
				String questionAttemptedStr=(correct+wrong)+"";
				String correctStr=correct+"";
				String wrongStr=wrong+"";
				String totalStr=(correct+wrong+unanswered)+"";
				
				
				scoreList.add(markStr);
				scoreList.add(storeTimeStr);
				scoreList.add(questionAttemptedStr);
				scoreList.add(correctStr);
				scoreList.add(wrongStr);
				scoreList.add(totalStr);
				return StatusConstants.SUCCESS;
			}
			else
			{
				return StatusConstants.FAIL;
			}
		}
		
		return StatusConstants.FAIL;
		
		
	}

}
