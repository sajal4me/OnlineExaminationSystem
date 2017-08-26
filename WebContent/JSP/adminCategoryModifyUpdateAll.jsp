<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<%@ page import="com.model.StatusConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminCategoryModifyUpdateAll.css">
<link rel="icon"
	href="${pageContext.request.contextPath}/IMAGE/logo.png"
	type="image/x-icon">
<title>adminCategoryModifyUpdateCategoryUpdateAll</title>
</head>
<body>

	<div id="header">
		<img id="headerLogo"
			src="${pageContext.request.contextPath}/IMAGE/adminLogo.png" />
		<p id="headerTitle">Dashboard</p>
	</div>
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


			<%
				HttpSession sess=request.getSession(false);
				if(sess!=null)
				{
					String updateWhat=sess.getAttribute("update").toString();
					Map<String,ArrayList<String>> updateMap=new LinkedHashMap<String,ArrayList<String>>();
					String s="";
					if(updateWhat.equalsIgnoreCase("set"))
					{
							s="setMap";
					}
					else if(updateWhat.equalsIgnoreCase("topic"))
					{
						s="topicMap";
					}
					else if(updateWhat.equalsIgnoreCase("question"))
					{
						s="questionMap";
					}
					
						int count=0;
						
						updateMap=(LinkedHashMap<String,ArrayList<String>>)sess.getAttribute(s);
						Set<String> keys=updateMap.keySet();
						Iterator<String> keyIterator=keys.iterator();
						
						
		%>
			<div id="menu">


				<form id="categoryForm"
					action="Check_Admin_Session_UpdateAllGetForm.Admin_Filter?updateMapName=<%=s %>"
					method="Post">

					<select name="update">

						<%
							
					while(keyIterator.hasNext())
					{
						String key=keyIterator.next();
						ArrayList<String> updateList=new ArrayList<String>();
						updateList=updateMap.get(key);
					
					%>
						<%
								if(count==0)
								{
									count++;
								
							%>
						<option value="" selected disabled>&emsp;
							<%=key %>&emsp;
						</option>
						<%
								}
								else
								{
							%>
						<option name="option" value=<%= key %>><%=key%></option>
						<%
								}
								%>

						<%
			    	
						}
					
					}
			    	
			    	%>

					</select> <input id="submitButton" type="submit" value="Submit">
				</form>



			</div>
		</div>
	</div>



</body>
</html>