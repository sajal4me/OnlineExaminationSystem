<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%! String d[]; 
    int i=0;%>
	<td id="regPart" width="500">
		<h3>Register</h3>
		<hr />
		<p>Enter your details here:</p>
		<form action="Security_Que" method="post">
			<input id="name" type="text" name="name"
				placeholder="Enter Name here" required /> <br /> <input id="email"
				type="text" name="email" placeholder="Enter email here" required />
			<br /> <input id="pass" type="text" name="pass"
				placeholder="Enter Password here" required /> <br /> <input
				id="confirmPass" type="text" name="confirmPass"
				placeholder="Re-enter Password here" required /> <br /> <input
				id="contact" type="number" maxlength="10"
				placeholder="Mobile Number" required /> </br>
			<%
	           d=new String [3];
	          // for(int i=0;i<3;i++)
	          String []s= (String[])request.getAttribute("sa");
	           %>

			<!--    String[] s = (String[])request.getAttribute("sa");      -->

			<select name="select">

				<option value="volvo">
					<%for( i=0;i<3;i++) %>
					<%=s %>
				</option>





			</select> </br> </br> <input type="submit" value="Register" />
		</form>
	</td>


</body>
</html>