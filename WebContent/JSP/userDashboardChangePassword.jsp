<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/userDashboardChangePassword.css">
<link rel="icon" href="${pageContext.request.contextPath}/logo.png"
	type="image/x-icon">
<title>Reset Password</title>
</head>
<body>

	<div id="header">
		<img id="headerLogo"
			src="${pageContext.request.contextPath}/IMAGE/userLogo.png" />
		<p id="headerTitle">Dashboard</p>
	</div>
	<div id="containerOne">
		<div id="option">
			<p>
				<a href="<%=request.getContextPath()%>/Check_User_Session_MainHome"><button>Home</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_Home.User_Filter"><button>Dashboard</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_Category.User_Filter"><button>Take
						Test</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_ScoreCard.User_Filter"><button>Score
						Card</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_DashboardChangePassword.User_Filter"><button>Change
						Password</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_Feedback.User_Filter"><button>Feedback</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_EditProfile.User_Filter"><button>Edit
						Profile</button></a>
			</p>
			</br>
			<p>
				<a
					href="<%=request.getContextPath()%>/Check_User_Session_LeaderBoard.User_Filter"><button>Leader
						Board</button></a>
			</p>
			</br>
			<p>
				<a href="<%=request.getContextPath()%>/logout.User_Filter"><button>Logout</button></a>
			</p>
			</br>
		</div>

		<div id="viewContent">
			<div id="passwordReset">
				<h3>Password Recovery</h3>
				<hr />
				<p>Enter your details here:</p>
				<form
					action="<%=request.getContextPath() %>/CheckOldPasswordChangePassword.User_Filter"
					method="post">
					<input id="recoveryRmail" type="password" name="currentPassword"
						placeholder="Enter Current Password" required /> <br /> <input
						id="recoveryRmail" type="password" name="newPassword"
						placeholder="Enter New Password" required /> <br /> <input
						id="ans" type="password" name="renewPassword"
						placeholder="Re-enter Password"><br /> <input
						type="submit" value="Submit" />
				</form>
			</div>
		</div>

	</div>


</body>
</html>