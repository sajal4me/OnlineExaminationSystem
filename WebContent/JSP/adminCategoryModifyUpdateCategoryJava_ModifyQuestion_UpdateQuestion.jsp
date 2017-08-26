<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminCategoryModifyUpdateJavaModifyQuestionUpdateQuestion.css">
<link rel="icon"
	href="${pageContext.request.contextPath}/Image/logo.png"
	type="image/x-icon">
<title>Update Question</title>
</head>
<body>

	<div id="header">
		<img id="headerLogo"
			src="${pageContext.request.contextPath}/IMAGE/adminLogo.png" />
		<p id="headerTitle">Dashboard</p>
	</div>

	<%
			System.out.println(request.getAttribute("questionList"));
			List<String> questionList=new LinkedList<String>();
			questionList=(List<String>)request.getAttribute("questionList");
			System.out.println(questionList.get(0));
			String questionId=request.getParameter("update");
		%>

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
					Update Question</p>
				<form id="categoryForm"
					action="Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_UpdateQuestion.Admin_Filter?questionId=<%=questionId %>"
					method="POST">
					<input id="entry" value="<%=questionList.get(0) %>" name="question"
						type="text" required /><br /> <input id="opt"
						value="<%=questionList.get(1) %>" type="text" name="option1" /><br />
					<input id="opt" value="<%=questionList.get(2) %>" type="text"
						name="option2" /><br /> <input id="opt"
						value="<%=questionList.get(3) %>" type="text" name="option3" /><br />
					<input id="opt" value="<%=questionList.get(4) %>" type="text"
						name="option4" /><br /> <input id="entry"
						value="<%=questionList.get(5) %>" name="answer" type="text"
						required /><br /> </select><br /> <input id="submitButton" type="submit"
						value="Update">
				</form>
			</div>
		</div>
	</div>
</body>
</html>

