package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.FetchUserName;
import com.model.SignUpDb;
import com.model.StatusConstants;
import com.model.UserDAO;
import com.model.UserDTO;
import com.service.CheckParameters;



public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("SignUp servlet");
		//Store Status Returned After Checking Complete List.
		String status="";
		ServletContext context;
		
		//Storing status of all Parameters.
		List<String> statusList=new ArrayList<String>();
		CheckParameters check=new CheckParameters();
		
		
		long mobileNumber=0;
		String name=request.getParameter("nameUp");
		statusList.add(check.checkString(name));
		String email=request.getParameter("emailUp");
		statusList.add(check.checkString(email));
		String pass=request.getParameter("passUp");
		statusList.add(check.checkString(pass));
		String confirmPass=request.getParameter("confirmPassUp");
		statusList.add(check.checkString(confirmPass));
		
		
		String smobileNumber=(request.getParameter("mobileNumberUp"));
		statusList.add(check.checkString(smobileNumber));
		
		 /*if(smobileNumber !=null && !smobileNumber.isEmpty() )  */                //Main Problem-1
		     mobileNumber=Long.parseLong(smobileNumber.trim());
		
		 
		 
		String security=request.getParameter("security");
		statusList.add(check.checkString(security));
		
		String ans=request.getParameter("ansUp");
		statusList.add(check.checkString(ans));
		
		status=check.checkStatus(statusList);
		
		if((pass.equals(confirmPass)) && status.equals(StatusConstants.SUCCESS)){
		    	 try {
		 			
		            SignUpDb db=new SignUpDb();
		             
		  				
		  				String statusDb = null;
						try {
							statusDb = db.data(name,email, pass, mobileNumber, security, ans);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    		 
		    		 	
		    		 	if(statusDb.equals(StatusConstants.SUCCESS))
		    		 	{
		    		 		
		  				FetchUserName fetchName=new FetchUserName();
			             
			            String user_Name = null;
						try {
							user_Name = fetchName.data(email);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		  				HttpSession sess=request.getSession(true);
		  				sess.setAttribute("userName", user_Name);
		  				sess.setAttribute("emailLoggedInUser", email);
		  				
		  				context=getServletContext();
		  				
		  				RequestDispatcher rd=context.getRequestDispatcher("/JSP/OnlineExamination_LoggedIn.jsp");
		  				rd.forward(request, response);
		  				/*response.sendRedirect("/JSP/OnlineExamination_LoggedIn.jsp");*/
		    		 	}
		    		 	
		    		 	else
		    		 	{
		    		 		
		    		 		context=getServletContext();
		    		 		
			  				RequestDispatcher rd=context.getRequestDispatcher("/JSP/404error.jsp");
			  				rd.forward(request, response);
		    		 		/*response.sendRedirect("JSP/404error.jsp");*/
		    		 	}
		  		} catch (SQLException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		} 
		     } //if close
		     else{
		    	 
		    	 context=getServletContext();
		    	 
	  				RequestDispatcher rd=context.getRequestDispatcher("/JSP/404error.jsp");
	  				rd.forward(request, response);
		    	 
		     }
	}

}
