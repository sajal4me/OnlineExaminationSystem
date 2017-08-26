<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/userDashboardGiveFeedback.css">
<link rel="icon" href="${pageContext.request.contextPath}/logo.png"
	type="image/x-icon">
<title>Give Feedback</title>
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
			<div id="feedback">
				<h3>Fill Feedback</h3>
				<hr />
				<p>Enter Not More Than 200 Words:</p>
				<form
					action="<%=request.getContextPath() %>/Check_User_Session_SaveFeedback.User_Filter"
					method="post">

					<textarea id="givefeedback" type="text" name="feedback"
						placeholder="Enter Feedback" rows="10" cols="40" required></textarea>
					</textarea>
					<br /> <input id="feedbacksubmit" type="submit" value="Submit" />
				</form>
			</div>
		</div>

	</div>


</body>
</html>