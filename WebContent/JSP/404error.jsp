<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/OnlineExamination.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/newOnlineExamination.css">
<title>Error</title>
</head>
<body>
	<%-- <%
				String header="";
				HttpSession sess=request.getSession(false);
				if(sess!=null)
					header="loggedinHeader.jsp";
				else
					header="header.jsp";
					
				System.out.println("*******JSP/404error.jsp********");
			
			%>
	<jsp:include page='<%=header %>' />
 --%>
	<div id="centerContent">

		<div id="containerOne">

			<img class="oops"
				src="<%=request.getContextPath() %>/IMAGE/oops4.gif" />
			<h1 align="middle">Sorry For Inconveneince Please Try Again
				Later.</h1>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>