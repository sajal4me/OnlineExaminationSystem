<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminCategoryModifyUpdateJavaModifyQuestionUpdateSet.css">
<link rel="icon"
	href="${pageContext.request.contextPath}/Image/logo.png"
	type="image/x-icon">
<title>Update SET</title>
</head>
<body>

	<div id="header">
		<img id="headerLogo"
			src="${pageContext.request.contextPath}/IMAGE/adminLogo.png" />
		<p id="headerTitle">Dashboard</p>
	</div>

	<%
			System.out.println(request.getAttribute("setList"));
			List<String> setList=new LinkedList<String>();
			setList=(List<String>)request.getAttribute("setList");
			System.out.println(setList.get(0)+"dfs" );
			String setId=request.getParameter("update");
			
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
				<p>MODIFY CATEGORY > Update Category > Java > Modify Set >
					Update Set</p>
				<form id="categoryForm"
					action="Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_UpdateSet.Admin_Filter?setId=<%=setId %>"
					method="POST">
					<input id="entry" value="<%=setList.get(0) %>" name="noOfQuestion"
						type="text" required /><br /> </select><br /> <input id="submitButton"
						type="submit" value="Update">
				</form>
			</div>
		</div>
	</div>
</body>
</html>

