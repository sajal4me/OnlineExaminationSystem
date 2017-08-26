<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/resetPassword.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/OnlineExamination.css">
</head>
<body>
	<!--  <div id="top">
		<table id="table_header">
			<tr>
			   <td id="tdtitle">
					<h1><a href="OnlineExamination.html"><img src="Home.png"/></a></h1>
					<h1 id="title"><img src="onlinelogomaker-100516-1534-2386.png" width=""/></h1>
			   </td>				
				<td id="tdSignIn">
					<a id="signInReg" href="SignIn.html" title="click here Sign in/Register" title="Click to sign or register"><strong>Sign In/Register</strong></a>
				</td>
			</tr>	
				
		</table>
				
		<div id="menu">
			<ul id="ul_1">
				<li><a href="help.html">Help</a></li>
				<li><a href="about.html">About Us</a></li>
				<li><a href="dashboard.html">Dashboard</a></li>
				<li><a href="TestCategory.html">Online Tests</a></li>
		   </ul>
		</div> -->


	<jsp:include page="header.jsp" />

	<%
			
			System.out.println("**jsp**-ResetPassword.jsp");
		
		%>


	<div id="centerContent">
		<!--center content-->
		<div id="passwordReset">
			<h3>Password Recovery</h3>
			<hr />
			<p>Enter your details here:</p>
			<form action="<%=request.getContextPath() %>/ResetPassword"
				method="post">
				<input id="recoveryRmail" type="password" name="password"
					placeholder="Enter New Password" required /> <br /> <input id="ans"
					type="password" name="repassword" placeholder="Re-enter Password"><br />
				<input type="hidden" name="email"
					value="<%= request.getAttribute("email") %>"> <input
					type="submit" value="Submit" />
			</form>
		</div>
	</div>
	<!--  <div id="footer_part"> 
			<table id="table_footer">
				<tr id="footerRow">
					<td id="footerList" >
					   <ul id="ul_footer">
							<li><a href="about.html">About us</li></a>
							<li><a href="online.html">Online Tests</a></li>
							<li><a href="help.html">Help</a></li>
							<li><a href="feedback.html">Feedback</a></li>
					   </ul>
					</td>				
					<td id="feedback">
						<p id="parafeedback">Feedback :</p>
						<textarea id="text" placeholder="Not more then 150 words...."></textarea> <br/>
						<input id="textSubmit" type="submit" value="Submit"/>
					</td>	
				</tr>		
			</table>	
	  </div>
	  <div id="developer">
			<table>
				<tr>
					<td><img src="MyPic_new(1).png"/><br/><p>Manish Patel</p></td> 
					<td><img src="MyPic_new(1).png"/><br/><p>Sajal Gupta</p></td>
					<td><img src="MyPic_new(1).png"/><br/><p>Sunny Agarwal</p></td> 
					<td><img src="MyPic_new(1).png"/><br/><p>Umang Kesri</p></td>
				</tr>
			</table>
	  </div> -->

	<jsp:include page="footer.jsp" />

</body>
</html>