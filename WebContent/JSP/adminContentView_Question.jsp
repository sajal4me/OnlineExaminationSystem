<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminContentViewQuestion.css">
<link rel="icon" href="${pageContext.request.contextPath}/logo.png"
	type="image/x-icon">
<title>View Question</title>
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
		<%
				HttpSession sess=request.getSession(false);
				if(sess!=null)
				{
					Map<String,ArrayList<String>> questionMap=new LinkedHashMap<String,ArrayList<String>>();
					questionMap=(LinkedHashMap<String,ArrayList<String>>)sess.getAttribute("questionMap");
					Set<String> keys=questionMap.keySet();
					Iterator<String> keyIterator=keys.iterator();
					%>

		<div id="adminContent">
			<div id="menu">
				<p>CONTENT VIEW > Question</p>
				<div id="tableDiv">
					<table border="1" width="100%">
						<%
						int count=0;
					while(keyIterator.hasNext())
					{
						String key=keyIterator.next();
						ArrayList<String> questionList=new ArrayList<String>();
						questionList=questionMap.get(key);
						if(count==0)
						{
							count=count+1;
					%>
						<tr>


							<th><%= key %></th>
							<th><%= questionList.get(0) %></th>
							<th><%= questionList.get(1) %></th>
							<th><%= questionList.get(2) %></th>
							<th><%= questionList.get(3) %></th>
							<th><%= questionList.get(4) %></th>
							<th><%= questionList.get(5) %></th>
							<th><%= questionList.get(6) %></th>
							<th><%= questionList.get(7) %></th>
							<th><%= questionList.get(8) %></th>

						</tr>
						<%
						}
						else
						{
							%>
						<tr>

							<td><div><%= key %>
								</div></td>
							<td><div>
									<%= questionList.get(0) %>
								</div></td>
							<td><div>
									<%= questionList.get(1) %>
								</div></td>
							<td><div>
									<%= questionList.get(2) %>
								</div></td>
							<td><div>
									<%= questionList.get(3) %>
								</div></td>
							<td><div>
									<%= questionList.get(4) %>
								</div></td>
							<td><div>
									<%= questionList.get(5) %>
								</div></td>
							<td><div>
									<%= questionList.get(6) %>
								</div></td>
							<td><div>
									<%= questionList.get(7) %>
								</div></td>
							<td><div>
									<%= questionList.get(8) %>
								</div></td>
						</tr>
						<%
						}
					}
						%>


						<%
								
					
					
				}
				 %>

					</table>
				</div>
			</div>
		</div>
	</div>