<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="adminLoginEncoded.css">
<title>Insert title here</title>
</head>
<body>
	<div id="adminLogin">
		<form id="form" action="CheckLogin_Admin" method="post">
			<table id="table">
				<tr>
					<h2>Login</h2>
				</tr>
				<tr>
					<td>E-mail id :</td>
					<td><input type="text" name="email_admin" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password_admin" /></td>
				</tr>
			</table>
			<a href="adminPasswordRecovery.html" name="Recovery"
				style="text-decoration: none">Forget Pasword?/Click here</a> <input
				id="submit" type="submit" />

		</form>
	</div>


</body>
</html>