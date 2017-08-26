<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminCategoryModifyUpdateCategoryJava.css">
<link rel="icon" href="logo.png" type="image/x-icon">
<title>ModifyQuestion</title>
</head>
<body>

	<%
			String category=request.getParameter("category");
		%>
	<div id="header">
		<img id="headerLogo"
			src="${pageContext.request.contextPath}/IMAGE/adminLogo.png" />
		<p id="headerTitle">Dashboard</p>
	</div>
	<div id="containerOne">
		<div id="option">
			<p>
				<a href="Check_Admin_Session.Admin_Filter"><button>Home</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_ModifyCategory.Admin_Filter"><button>Modify
						Categories</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_ViewFeedback.Admin_Filter"><button>View
						Feedback</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_UserDetails.Admin_Filter"><button>User
						Details</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_UserScore.Admin_Filter"><button>User
						Score</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_ContentView.Admin_Filter"><button>Content
						View</button></a>
			</p>
			</br>
			<p>
				<a href="Admin_Logout"><button>Logout</button></a>
			</p>
			</br>
		</div>
		<div id="adminContent">
			<div id="menu">
				<p>MODIFY CATEGORY > Update Category > java>ModifyQuestion</p>
				<a
					href="Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionOptions.Admin_Filter"><button
						id="modifyQuestion">Add Question</button></a> <a
					href="Check_Admin_Session_Delete.Admin_Filter?deleteIndex=4&category=<%=category%>"><button
						id="addSet">Delete Question</button></a> <a
					href="Check_Admin_Session_ModifyCategory_Update.Admin_Filter?update=question"><button
						id="addTopic">Update Question</button></a>
			</div>
		</div>
	</div>



</body>
</html>