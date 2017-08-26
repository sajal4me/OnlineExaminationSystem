<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<%@ page import="org.json.JSONObject,org.json.JSONArray"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/userOnlineTestResult.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/OnlineExamination.css">

<!-- <script>
		window.location.hash="no-back-button";
		window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
		window.onhashchange=function(){window.location.hash="no-back-button";}
	</script>  -->

</head>
<body>


	<jsp:include page="loggedinHeader.jsp" />


	<div id="centerContent">

		<%
		    	System.out.println("****JSP*****-userOnlineTestResult.jsp");
		    	String scoreStr=request.getParameter("data");
		    	List<String> scoreList=new ArrayList<String>(Arrays.asList(scoreStr.split(",")));
		    	
		    	
		    	
		    	
		    %>

		<div id="tableDiv">
			<table width="100%">
				<col width="40%">
				<col width="60%">

				<tr>
					<th>Marks Obtained</th>
					<td><%= scoreList.get(0) %></td>
				</tr>
				<tr>
					<th>Time Taken(mm:ss)</th>
					<td><%= scoreList.get(1) %></td>
				</tr>
				<tr>
					<th>Question Attempted</th>
					<td><%= scoreList.get(2) %></td>
				</tr>
				<tr>
					<th>Correctly Answered</th>
					<td><%= scoreList.get(3) %></td>
				</tr>
				<tr>
					<th>Wrongly Answered</th>
					<td><%= scoreList.get(4) %></td>
				</tr>
				<tr>
					<th>Total Question</th>
					<td><%= scoreList.get(5) %></td>
				</tr>
				<tr>


				</tr>

			</table>


		</div>

		<%
		    	System.out.println("I am Here Only");
		    %>


	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>