<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminCategoryModifyUpdateCategoryJavaModifyQuestionAddQuestionOptionsExcel.css">
<link rel="icon" href="logo.png" type="image/x-icon">
<title>AddQuestion</title>
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
				<a href="Check_Admin_Session_ModifyCategory.Admin_Filter"><button>Modify Categories</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_ViewFeedback.Admin_Filter"><button>View Feedback</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_UserDetails.Admin_Filter"><button>User Details</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_UserScore.Admin_Filter"><button>User
						Score</button></a>
			</p>
			</br>
			<p>
				<a href="Check_Admin_Session_ContentView.Admin_Filter"><button>Content View</button></a>
			</p>
			</br>
			<p>
				<a href="Admin_Logout"><button>Logout</button></a>
			</p>
			</br>
		</div>
		<div id="adminContent">
			<div id="menu"><p>MODIFY CATEGORY >UpdateCategory >java>ModifyQuestion >AddQuestion >Options >Excel</p></div>
			<div id="form">
					<form action="Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestionExcelStore.Admin_Filter"
						  method="post" enctype="multipart/form-data">

					Select File:<input type="file" name="fname" /> <br>
					 			<input id="upload" type="submit" value="upload" /><br>
						
					 Set:<select id="regSecurity" name="set" required>
						 	<option value="" selected disabled>Choose Set</option>
							<%-- Accessing Pojo SetTop And Then Its List<Set>. --%>
							<c:forEach var="set" items="${requestScope.settop.set}">
								<option value="${set.setId}">${set.setId}</option>
							</c:forEach>
						</select><br />
					
					Topic: <select id="regSecurity" name="topic" required>
								<option value="" selected disabled>Choose Topic</option>
								<c:forEach var="topic" items="${requestScope.settop.topic}">
								<option value="${topic.topicId}">${topic.topicName}</option>
								</c:forEach>
						  </select><br> 
					<input id="submitButton" type="submit" value="Add"> 
				</form>
			</div>
			
		</div>
	</div>

</body>
</html>