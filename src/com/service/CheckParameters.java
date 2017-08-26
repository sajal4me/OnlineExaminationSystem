package com.service;

import java.util.List;

import com.model.StatusConstants;

public class CheckParameters {
	
	public String checkString(String paraCheck)
	{
		
		if(paraCheck==null || paraCheck.length()==0)
		{
			return StatusConstants.FAIL;
		}
		else
		{
			return StatusConstants.SUCCESS;
		}
		
	}
	
	public String checkInt(String paraCheck)
	{
		
		for (char c : paraCheck.toCharArray())
	        if (c < '0' || c > '9')
	            return StatusConstants.FAIL;
		
	    return StatusConstants.SUCCESS;
	}
	
	public String checkStatus(List<String> statuAllPara)
	{
		for(String status:statuAllPara)
		{
			if(status.equals(StatusConstants.FAIL))
				return StatusConstants.FAIL;
			
		}
		return StatusConstants.SUCCESS;
	}

	
	
	

}
