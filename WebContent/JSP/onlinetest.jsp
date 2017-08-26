<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/OnlineExamination.css">
</head>
<body>
	<div id="top">
		<table id="table_header">
			<tr>
				<td id="tdtitle">
					<h1>
						<a
							href="${pageContext.request.contextPath}/JSP/OnlineExamination.jsp"><img
							src="${pageContext.request.contextPath}/IMAGE/Home.png" /></a>
					</h1>
					<h1 id="title">
						<img
							src="${pageContext.request.contextPath}/IMAGE/onlinelogomaker-100516-1534-2386.png"
							width="" />
					</h1>
				</td>
				<td id="tdSignIn"><a id="signInReg"
					href="${pageContext.request.contextPath}/FetchSecurityQuestion"
					title="click here Sign in/Register"
					title="Click to sign or register"><strong>Sign
							In/Register</strong></a></td>
			</tr>

		</table>
	</div>

	<div id="menu">
		<ul id="ul_1">
			<li><a href="${pageContext.request.contextPath}/JSP/help.jsp">Help</a></li>
			<li><a href="${pageContext.request.contextPath}/JSP/about.jsp">About
					Us</a></li>
			<li><a href="Check_User_Session_Category">Online Tests</a></li>
		</ul>
	</div>
	<div id="containerOne">
		</br>
	</div>

	<div id="containerThree">

		<div id="quickLink">
			<br>
			<Strong>Quick Links</strong><br>
			<br>
			<p>
				<a
					href="${pageContext.request.contextPath}/JSP/OnlineExamination.jsp">Home</a>
			</p>
			<p>
				<a href="${pageContext.request.contextPath}/JSP/about.jsp">About
					Us</a>
			</p>
			<p>
				<a href="${pageContext.request.contextPath}/JSP/faq.jsp">FAQ</a>
			</p>
			<!-- <p><a href="faculty.html">Faculty</a></p>
				<p><a href="studentZone.html">Student Zone</a></p>
				<p><a href="index.html">News</a></p>	 -->
		</div>

		<div id="followUs">
			<br>
			<Strong>Follow Us</strong><br>
			<br>
			<p id="footerFacebook">
				<a href="https://www.facebook.com/" target="_blank"><img
					src="${pageContext.request.contextPath}/IMAGE/fb.png" width="20px" />
					Facebook</a>
			</p>
			<br>
			<p id="footerTwitter">
				<a href="https://twitter.com/" target="_blank"> <img
					src="${pageContext.request.contextPath}/IMAGE/twitter.png"
					width="20px" /> Twitter
				</a>
			</p>
			<br>
			<p id="footerYoutube">
				<a href="https://www.youtube.com/" target="_blank"> <img
					src="${pageContext.request.contextPath}/IMAGE/youtube.png"
					width="20px" /> Youtube
				</a>
			</p>
		</div>

		<div id="contact">
			<br>
			<Strong>Contact Us</strong><br>
			<br>
			<p>P.O. Box 201003</p>
			<p>Delhi-Meerut Road</p>
			<p>Ghaziabad</p>
			<p>Mob: +91 8587878471</p>
			<p id="footerMail">
				<img src="${pageContext.request.contextPath}/IMAGE/foot_mail.png" />
				onlineexamination.edu@gmail.com
			</p>
			<p id="footerSkype">
				<img src="${pageContext.request.contextPath}/IMAGE/foot_skype.png" />
				Coming soon...
			</p>
		</div>

	</div>
	<div id="copyRight">
		<p>Copyright © 2017 OnlineExamination.in...All Rights
			Reserved.&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Site
			Developer: Manish Patel | Sajal Gupta | Sunny Agarwal | Umang Kesari</p>
	</div>


</body>
</html>