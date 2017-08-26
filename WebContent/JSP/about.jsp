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
	href="${pageContext.request.contextPath}/CSS/about.css">
</head>
<body>


	<%
	 	System.out.println("**JSP****-about.jsp");
	 	String header=(String)(request.getAttribute("header"));
	 %>

	<jsp:include page="<%=header %>" />


	<div id="containerTwo">
		<div id="message">
			<p id="titleVision">About Us</p>
			<p id="visionContent">
				<i>"About Online Examination System.in website: Online
					Examination System is a leading website which provides useful and
					important questions regarding Java, C++, C and many more. We can
					say it is a completely useful for all the aspirants who is
					preparing for Competitive Exams. Here we provide lots of online
					test along with solution and report page. Inception of Online
					Examination System: Online Examination System is started to provide
					easy to tough level questions to the aspirants. The main difference
					between Online Examination System and other websites is quality of
					the questions, easy navigations to the links, many number of
					questions are available, time spent on each questions, in detailed
					report page and many more. We are a group of people working for
					this site to help the students who will be preparing for
					competitive exams, or frequently facing problems with the exam
					methodology, time management and the way of solving out the
					answers. We make sure that whoever is attending these exams can get
					a better experience to face the original competitive exams. Apart
					from website, We are an IT engineer and love to spend time on
					internet."</i>
			</p>
		</div>
		<div id="image">
			<div id="titleFirst">
				<p>Website Developer</p>
			</div>

			<div id="imgOne">
				<center>
					<img src="<%=request.getContextPath() %>/IMAGE/manish.jpg" />
				</center>
				<p id="name">&emsp;Manish Patel</p>
				<p id="data">
					B.Tech(Computer Science)<br>AKTU(RKGIT)<br>Delhi-NCR
				</p>
			</div>
			<div id="imgTwo">
				<center>
					<img src="<%=request.getContextPath() %>/IMAGE/sajal.jpg" />
				</center>
				<p id="name">&emsp;Sajal Gupta</p>
				<p id="data">
					B.Tech(Computer Science)<br>AKTU(RKGIT)<br>Delhi-NCR
				</p>
			</div>
			<div id="imgThree">
				<center>
					<img src="<%=request.getContextPath() %>/IMAGE/sunny.jpg" />
				</center>
				<p id="name">&emsp;Sunny Agarwal</p>
				<p id="data">
					&emsp;B.Tech(Computer Science)<br>&emsp;AKTU(RKGIT)<br>&emsp;Delhi-NCR
				</p>
			</div>
			<div id="imgFour">
				<center>
					<img src="<%=request.getContextPath() %>/IMAGE/umang.JPG" />
				</center>
				<p id="name">&emsp;Umang Kesari</p>
				<p id="data">
					&emsp;B.Tech(Computer Science)<br>&emsp;AKTU(RKGIT)<br>&emsp;Delhi-NCR
				</p>
			</div>
		</div>

	</div>



	<jsp:include page="footer.jsp" />

</body>
</html>