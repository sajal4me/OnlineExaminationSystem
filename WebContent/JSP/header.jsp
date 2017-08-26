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
		<a href="<%=request.getContextPath()%>/JSP/OnlineExamination.jsp"><img
			id="logo" src="<%=request.getContextPath() %>/IMAGE/OES.png" /></a> <a
			id="signInReg"
			href="<%=request.getContextPath()%>/FetchSecurityQuestion"
			title="click here Sign in/Register"><strong>Sign
				In/Register</strong></a>

	</div>

	<div id="menu">
		<ul id="ul_1">
			<li><a
				href="<%=request.getContextPath() %>/Check_User_Session_help">Help</a></li>
			<li><a
				href="<%=request.getContextPath() %>/Check_User_Session_about">About
					Us</a></li>
			<%-- <li><a href="<%=request.getContextPath() %>/JSP/category.jsp">Categories</a></li> --%>
			<li><a
				href="<%=request.getContextPath() %>/Check_User_Session_Category">Online
					Tests</a></li>
		</ul>
	</div>

</body>
</html>