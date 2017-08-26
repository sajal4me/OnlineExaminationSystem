<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/OnlineTestSetTopic.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/OnlineExamination.css">
<title>Online Test SetTopic</title>
</head>
<body>

	<jsp:include page="loggedinHeader.jsp" />


	<div id="centerContent">

		<!-- Fetch Map Data Which Stores All The Category DATA. -->
		<%
				String categoryName=(String)request.getAttribute("categoryName");
				System.out.println("userOnlineTestSetTopic.jsp");
				
				
				
				String[] catsettopList=(String[])request.getAttribute("catsettopList");
				
				
					
					
				%>

		<div id="comcategory">
			<p id="Lang">Set</p>
			<p>
				Number Of Set:<%=catsettopList[0] %></p>
			<a
				href="Check_User_Session_Set.Exam_Filter?catSet=<%=catsettopList[0] %>&categoryName=<%= categoryName%>">
				<button id="StartTest">START TEST</button>
			</a>
		</div>
		<div id="comcategory">
			<p id="Lang">Topic</p>
			<p>
				Number Of Set:<%=catsettopList[1] %></p>
			<a
				href="Check_User_Session_Topic.Exam_Filter?catTop=<%=catsettopList[1] %>&categoryName=<%= categoryName%>">
				<button id="StartTest">START TEST</button>
			</a>
		</div>




	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>