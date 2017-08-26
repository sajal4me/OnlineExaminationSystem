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

	<div id="containerThree">

		<div id="quickLink">
			<br>
			<Strong>Quick Links</strong><br>
			<br>
			<p>
				<a href="<%=request.getContextPath() %>/Check_User_Session_MainHome">Home</a>
			</p>
			<p>
				<a href="<%=request.getContextPath() %>/Check_User_Session_about">About
					Us</a>
			</p>
			<p>
				<a href="<%=request.getContextPath() %>/Check_User_Session_faq">FAQ</a>
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
					src="<%=request.getContextPath() %>/IMAGE/fb.png" width="20px" />
					Facebook</a>
			</p>
			<br>
			<p id="footerTwitter">
				<a href="https://twitter.com/" target="_blank"> <img
					src="<%=request.getContextPath() %>/IMAGE/twitter.png" width="20px" />
					Twitter
				</a>
			</p>
			<br>
			<p id="footerYoutube">
				<a href="https://www.youtube.com/" target="_blank"> <img
					src="<%=request.getContextPath() %>/IMAGE/youtube.png" width="20px" />
					Youtube
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
				<img src="<%=request.getContextPath() %>/IMAGE/foot_mail.png" />
				onlineexamination.edu@gmail.com
			</p>
			<p id="footerSkype">
				<img src="<%=request.getContextPath() %>/IMAGE/foot_skype.png" />
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