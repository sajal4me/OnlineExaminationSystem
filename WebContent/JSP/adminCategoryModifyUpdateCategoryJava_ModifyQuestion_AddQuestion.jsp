<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminCategoryModifyUpdateJavaModifyQuestionAddQuestion.css">
<link rel="icon"
	href="${pageContext.request.contextPath}/Image/logo.png"
	type="image/x-icon">
<title>Add Question</title>
</head>
<body>

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
				<p>MODIFY CATEGORY > Update Category > Java > Modify Question >
					Add Question</p>
				<form id="categoryForm"
					action="<%=request.getContextPath() %>/Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestion_StoreQuestion.Admin_Filter"
					method="POST">
					Question:
					<textarea rows="4" cols="50" name="question" required></textarea>
					<br /> Option A: <input id="opt" type="text" name="option1" /><br />
					Option B: <input id="opt" type="text" name="option2" /><br />
					Option C: <input id="opt" type="text" name="option3" /><br />
					Option D: <input id="opt" type="text" name="option4" /><br />
					Answer: <input id="entry" name="answer" type="text" required /><br />

					Set: <select id="regSecurity" name="set" required>
						<option value="" selected disabled>Choose Set</option>

						<%-- Accessing Pojo SetTop And Then Its List<Set>. --%>
						<c:forEach var="set" items="${requestScope.settop.set}">

							<option value="${set.setId}">${set.setId}</option>

						</c:forEach>
					</select><br /> Topic: <select id="regSecurity" name="topic" required>
						<option value="" selected disabled>Choose Topic</option>


						<c:forEach var="topic" items="${requestScope.settop.topic}">

							<option value="${topic.topicId}">${topic.topicName}</option>

						</c:forEach>
					</select><br /> <input id="submitButton" type="submit" value="Add">
				</form>
			</div>
		</div>
	</div>
</body>
</html>