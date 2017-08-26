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
	href="<%=request.getContextPath() %>/CSS/faq.css">
</head>
<body>

	<%
			String header=(String)request.getAttribute("header");
		%>

	<jsp:include page="<%=header %>" />

	<div id="centerContent">
		<div id="ques1">
			<p>
			<h2>1. What is OES?</h2>
			</p>
			<br>
			<br>
			<p>Online Examination System or OES is a professional, internet
				based Testing Platform, using which user can give tests for your
				aspirants. A fast yet easy approach that lets you store your
				questions and tests on an online testing platform seamlessly. Simple
				procedure involved in the creation and assignment of tests with the
				smooth development of reports.</p>
		</div>

		<div id="ques2">
			<p>
			<h2>2. How to check the test result and review the performance
				of the associated students?</h2>
			</p>
			<br>
			<br>
			<p>OES is the online exam website which will save the calculated
				test results, that can swiftly be reviewed and exported for further
				forefront analysis. From the Report section, the user can easily
				view and export results seamlessly.</p>
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
				test attempt limit.</p>
		</div>
		<div id="ques4">
			<p>
			<h2>4. Do I need to install any additional software?</h2>
			</p>
			<br>
			<br>
			<p>No. OES is the Online Assessment Software does not require any
				additional software installation.</p>
		</div>
		<div id="ques5">
			<p>
			<h2>5. Does Think Exam require plugins such as Flash, Active X
				or Java?</h2>
			</p>
			<br>
			<br>
			<p>Plugins like Flash, Active X or Java are not necessary to be
				installed for accessing Think Exam. However, if in case your created
				test contains video or audio files, then it is mandatory for you and
				your users to update their computer with a plugin.</p>
		</div>

	</div>



	<jsp:include page="footer.jsp" />


</body>
</html>