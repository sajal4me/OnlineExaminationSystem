<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminContentViewCategory.css">
<link rel="icon"
	href="${pageContext.request.contextPath}/IMAGE/logo.png"
	type="image/x-icon">
<title>Admin ContentView Category</title>
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
					Map<String,ArrayList<String>> categoryMap=new LinkedHashMap<String,ArrayList<String>>();
					categoryMap=(LinkedHashMap<String,ArrayList<String>>)sess.getAttribute("categoryMap");
					Set<String> keys=categoryMap.keySet();
					Iterator<String> keyIterator=keys.iterator();
					%>

		<div id="adminContent">
			<div id="menu">
				<p>CONTENT VIEW > Category</p>
				<div id="tableDiv">
					<table border="1" width="100%">
						<%
						int count=0;
					while(keyIterator.hasNext())
					{
						String key=keyIterator.next();
						ArrayList<String> categoryList=new ArrayList<String>();
						categoryList=categoryMap.get(key);
						System.out.println(categoryList);
						if(count==0)
						{
							count=count+1;
					%>
						<tr>


							<th><%= key %></th>
							<th><%= categoryList.get(0) %></th>



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
									<%= categoryList.get(0) %>
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
</body>
</html>