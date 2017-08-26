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
	href="<%=request.getContextPath() %>/CSS/help.css">
</head>
<body>

	<%
			String header=(String)request.getAttribute("header");
		%>

	<jsp:include page="<%= header %>" />


	<div id="centerContent">
		<div id="ques1">
			<p>
			<h2>1. How to Start ?</h2>
			</p>
			<br>
			<br>
			<p>There are two way to start, if you are a registered user then
				login directly from the Home page.
				And if you are not a register user then click on hyperlink
				given in Login section for New User.</p>
			<img src="<%=request.getContextPath() %>/IMAGE/signIn.png"
				height="500" width="600">
		</div>

		<div id="ques2">
			<p>
			<h2>2. How to check the test result and review the performance
				of the associated students?</h2>
			</p>
			<br>
			<br>
			<p>The Online Examination System will automatically save the calculated
				test results, that can swiftly be reviewed for further
				forefront analysis. From the Report section, the user can easily
				view results seamlessly.</p>
		</div>
		<div id="ques3">
			<p>
			<h2>3. Is there any limit to add the number of users in a
				system?</h2>
			</p>
			<br>
			<br>
			<p>You can add and manage multiple users to your panel. This will
				help to conduct tests among multiple students depending upon the
				test attempt limit. The limit to test attempts, will be in
				accordance with the subscription purchased that can be increased
				anytime as per the requirements.</p>
		</div>
		<div id="ques4">
			<p>
			<h2>4. Do I need to install any additional software?</h2>
			</p>
			<br>
			<br>
			<p>No. The Online Examination System does not require
				any additional software installation.</p>
		</div>
		<div id="ques5">
			<p>
			<h2>5. Does Online Examination System require plugins such as Flash, Active X
				or Java?</h2>
			</p>
			<br>
			<br>
			<p>Plugins like Flash, Active X or Java are not necessary to be
				installed for accessing OES. 
				</p>
		</div>

	</div>



	<jsp:include page="footer.jsp" />

</body>


</html>