<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="top">
		<a
			href="<%=request.getContextPath()%>/JSP/OnlineExamination_LoggedIn.jsp"><img
			id="logo" src="<%=request.getContextPath() %>/IMAGE/OES.png" /></a> <a
			id="signInReg"
			href="<%=request.getContextPath()%>/logout.User_Filter"
			title="Click here to Logout"><strong>Logout</strong></a>

	</div>

	<div id="menu">
		<ul id="ul_1">


			<li><a
				href="<%=request.getContextPath() %>/Check_User_Session_help">Help</a></li>
			<li><a
				href="<%=request.getContextPath() %>/Check_User_Session_about">About
					Us</a></li>
			<li><a
				href="<%=request.getContextPath() %>/Check_User_Session_Category.User_Filter">Online
					Tests</a></li>
			<li><a
				href="<%=request.getContextPath() %>/Check_User_Session_Dashboard.User_Filter">Dashboard</a></li>


		</ul>
	</div>

</body>
</html>