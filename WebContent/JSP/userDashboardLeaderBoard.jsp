<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/userDashboardLeaderBoard.css">
<link rel="icon" href="<%=request.getContextPath() %>/IMAGE/logo.png"
	type="image/x-icon">
<title>Lead Card</title>
</head>
<body>

	<div id="header">
		<img id="headerLogo"
			src="<%=request.getContextPath() %>/IMAGE/userLogo.png" />
		<p id="headerTitle">leadCard</p>
	</div>
	<div id="containerOne">
		<div id="option">
			<p>
				<a href="<%=request.getContextPath()%>/Check_User_Session_MainHome"><button>Home</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_Home.User_Filter"><button>Dashboard</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_Category.User_Filter"><button>Take
						Test</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_ScoreCard.User_Filter"><button>Score
						Card</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_DashboardChangePassword.User_Filter"><button>Change
						Password</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_Feedback.User_Filter"><button>Feedback</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_EditProfile.User_Filter"><button>Edit
						Profile</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_LeaderBoard.User_Filter"><button>Leader
						Board</button></a>
			</p>
			</br>
			<p>
				<a href="<%=request.getContextPath()%>/logout.User_Filter"><button>Logout</button></a>
			</p>
			</br>
		</div>
		<div id="viewContent">

			<div id="tableDiv">
				<table border="1" width="100%">

					<%
            					HashMap<Integer,List<String>> leadMap=new HashMap<Integer,List<String>>();
            					List<String> leadList=new ArrayList<String>();	
            					leadMap=(HashMap<Integer,List<String>>)request.getAttribute("leadMap");
            					int size=leadList.size();
            					int count=0;
            					
            					
            				%>

					<tr>
						<% 
            					for(Integer i:leadMap.keySet())
            					{
            						leadList=leadMap.get(i);
            						if(count==0)
            						{
            							count++;
    								for(String leadData:leadList)
    								{
    								String temp=leadData;
            						
            						
            				%>

						<th><%= temp %></th>



						<%
            						}
            						}
            						else
            						{
            							for(String leadData:leadList)
        								{
        								String temp=leadData;
            							
            						%>


						<td><div><%=temp %></div></td>



						<% 
            							
            							}
    								}
            						
    							
    						
    						%>

					</tr>
					<%
            					}
    						%>

				</table>
			</div>
		</div>

	</div>



</body>
</html>