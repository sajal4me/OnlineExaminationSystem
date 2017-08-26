<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminCategoryModifyUpdateJavaModifyQuestionAddQuestion.css">
<link rel="icon"
	href="${pageContext.request.contextPath}/Image/logo.png"
	type="image/x-icon">
<title>Add Question</title>
</head>
<body>

	<div id="header">
		<img id="headerLogo"
			src="${pageContext.request.contextPath}/IMAGE/adminLogo.png" />
		<p id="headerTitle">Dashboard</p>
	</div>
	<%
	
	HttpSession sess=request.getSession(false);
	
	String update=sess.getAttribute("update").toString();
	
	if(update.equals("set"))
	{
		
	}
	else if(update.equals("topic"))
	{
		
	}
	%>

	<div id="containerOne">
		<div id="option">
			<p>
				<a href="Check_Admin_Session.Admin_Filter"><button>Home</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_ModifyCategory.Admin_Filter"><button>Modify
						Categories</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_ViewFeedback.Admin_Filter"><button>View
						Feedback</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_UserDetails.Admin_Filter"><button>User
						Details</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_UserScore.Admin_Filter"><button>User
						Score</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_ContentView.Admin_Filter"><button>Content
						View</button></a>
			</p>
			</br>
			<p>
				<a href="Admin_Logout"><button>Logout</button></a>
			</p>
			</br>
		</div>
		<div id="adminContent">
			<div id="menu">
				<p>MODIFY CATEGORY > Update Category > Java > Modify Question >
					Add Question</p>
				<form id="categoryForm"
					action="Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestion_StoreQuestion.Admin_Filter"
					method="POST">
					<%
			    			 if(update.equals("question"))
			    			{
			    				 %>
					<select id="regSecurity" name="upQues" onChange="check()">
						<option value="" selected disabled>Choose Question</option>
						<%
										
										if(sess!=null)
										{
											Map<String,ArrayList<String>> setMap=new LinkedHashMap<String,ArrayList<String>>();
											setMap=(LinkedHashMap<String,ArrayList<String>>)sess.getAttribute("questionMap");
											Set<String> keys=setMap.keySet();
											Iterator<String> keyIterator=keys.iterator();
											while(keyIterator.hasNext())
											{
												String key=keyIterator.next();
												ArrayList<String> setList=new ArrayList<String>();
												setList=setMap.get(key);
												System.out.println(setList);
					%>
						<option value=<%= key %>>
							<%= key %>
						</option>
						<% 
											}
										}
			    					%>
					</select>
					<% 			
			    				
			    			}
			    			
			    			
			    			
			    			%>

					<input id="submitButton" type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>
</body>
</html>


</body>
</html>