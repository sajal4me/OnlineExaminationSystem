package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionExcelStoreDb;
import com.model.StatusConstants;
import com.oreilly.servlet.MultipartRequest;
import com.service.GetQuestion;
import com.service.QuestionContainer;

@MultipartConfig()
@WebServlet(
        name = "FileUploadServlet",
        urlPatterns = { "/Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionExcelStore.Admin_Filter"},
        loadOnStartup = 1
)

public class Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionExcelStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MultipartRequest m=new MultipartRequest(request,"C:\\Users\\HP\\Desktop\\Project_OnlineExa\\WebContent");  
		Enumeration en=m.getFileNames();
		String fileName = null;
		while(en.hasMoreElements())
		{
			fileName=m.getFilesystemName((String)en.nextElement());
		}
		
		System.out.println("filename:"+fileName);
	 	/*final Part filePart = request.getPart("fname");
	 	
	 	 for (String content : filePart.getHeader("content-disposition").split(";")) {
		        if (content.trim().startsWith("filename")) {
		            String data= content.substring(
		                    content.indexOf('=') + 1).trim().replace("\"", "");
		            System.out.println(data);
		        }
		    }*/
		
		HttpSession sess=request.getSession(false);
		
		String set=m.getParameter("set");
		String topic=m.getParameter("topic");
		
				
		
		 /*for(Part part : request.getParts()){
		        System.out.println("PN: "+ part.getName());
		        Collection<String> headers = part.getHeaders("content-disposition");
		        if (headers == null)
		            continue;
		        for(String header : headers){
		            System.out.println("CDH: " + header);                  
		        } 
		    }*/
	
	 	 		/*PrintWriter out=response.getWriter();
	 	 		out.print("successfully uploaded"); */ 
		
        
        /*MultipartRequest multi = new MultipartRequest(request, "C:\\Users\\HP\\Desktop\\Project_OnlineExa\\WebContent"); 
        
        while (files.hasMoreElements()) 
         { 
              String name = (String)files.nextElement(); 
              String filename = multi.getFilesystemName(name); 
              String type = multi.getContentType(name); 
              out.println("<BR>name: " + filename); 
              out.println("<BR>filename: " + filename); 
              out.println("<BR>type: " + type); 
           } 
      } 
		
        System.out.println("Here");
        final Part filePart = request.getPart("fname");
        System.out.println("Here");
	 	 for (String content : filePart.getHeader("content-disposition").split(";")) {
	 		System.out.println("Here");

		        if (content.trim().startsWith("filename")) {
		            String data= content.substring(
		                    content.indexOf('=') + 1).trim().replace("\"", "");
		            System.out.println(data);
		            System.out.println("Here");
		        }
		    }
	 	 */
	 	 		
	 	if(sess!=null)
	 	 {
	 			String categoryId=(String)sess.getAttribute("categoryId");
	 	 		System.out.println("Here");
	 	 		String excelFilePath = "C:\\Users\\HP\\Desktop\\Project_OnlineExa\\WebContent\\"+fileName;
		    GetQuestion reader = new GetQuestion();
		    System.out.println("Here");
		    List<QuestionContainer> questionList = reader.getQuestionFromExcel(excelFilePath);
		    
		    Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionExcelStoreDb excelStore=new Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionExcelStoreDb();
		    String status=StatusConstants.FAIL;
		    try {
					status=excelStore.storeQuestion(questionList,set,topic,categoryId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    if(status.equals(StatusConstants.SUCCESS))
		    {
		    	RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/adminCategoryModifyUpdateCategoryJavaModifyQuestionAddQuestionOptionsExcel.jsp");
		    	rd.forward(request, response);
		    }
	 	 
		    else
		    {
		    	RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/404error.jsp");
		    	rd.forward(request, response);
		    }
	 	 }
	 	else
	 	{
	 		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/404error.jsp");
	    	rd.forward(request, response);
	 	}
		    
		   
	}
}


