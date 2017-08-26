<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminModifyUpdate.css">
<link rel="icon" href="logo.png" type="image/x-icon">
<title>Admin Update Category</title>
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
					Map<Integer,String> catMap=new HashMap<Integer,String>();
					catMap=(Map<Integer,String>)request.getAttribute("categoryMap");
					System.out.println(catMap);
			%>


		<div id="adminContent">
			<div id="menu">

				<p>MODIFY CATEGORY > Update Category</p>

				<%
					for(Integer key:catMap.keySet())
					{
					%>

				<a
					href="Check_Admin_Session_ModifyCategory_UpdateCategory_Java.Admin_Filter?category=<%= key %>"><button
						id="java"><%= catMap.get(key) %></button></a>
				<!-- <a href="adminModifyUpdateJava.html"><button id="C">C</button></a>
					<a href="adminModifyUpdateJava.html"><button id="cPlus">C++</button></a> -->
				<%
					}
      				%>
			</div>
		</div>
	</div>




</body>
</html>