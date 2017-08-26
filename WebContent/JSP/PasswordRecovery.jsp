<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/passwordRecovery.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/OnlineExamination.css">
</head>
<body>


	<jsp:include page="header.jsp" />

	<% System.out.println("**JSP**-PasswordRecovery.jsp"); %>

	<div id="centerContent">
		<!--center content-->
		<div id="passwordRecovery">
			<h3>Password Recovery</h3>
			<hr />
			<p>Enter your details here:</p>
			<form action="<%=request.getContextPath() %>/UserRecovery"
				method="post">
				<input id="recoveryRmail" type="text" name="recoveryEmail"
					placeholder="Enter email here" required /> <br />
				<!-- <select id="recoverySecurity" name="security" >
										<option selected disabled>Choose security question</option>
										<option>Mother maiden name</option>
										<option>Your first school name</option>
										<option>Place of birth</option>
										<option>Your first phone number</option>
								</select><br/>
								<input id="ans" type="text" name="recoveryAns" placeholder="Enter security answer here"><br/> -->
				<input type="submit" value="Submit" />
			</form>
		</div>
	</div>


	<jsp:include page="footer.jsp" />
</body>
</html>