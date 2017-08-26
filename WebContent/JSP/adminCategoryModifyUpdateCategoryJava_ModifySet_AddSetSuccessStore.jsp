<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminCategoryModifyUpdateJavaModifySetAddSet.css">
<link rel="icon" href="logo.png" type="image/x-icon">
<title>adminCategoryModifyUpdateCategoryJava_ModifySet_AddSetSuccessStore</title>
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
				<p>MODIFY CATEGORY > Update Category > Java > Modify Set > Add
					Set</p>
				<form id="categoryForm"
					action="Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifySet_AddSet_StoreSet.Admin_Filter"
					method="POST">
					<!-- Set Id &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;<input id="entry" type="text" required /><br/> -->
					Number Of Question <input id="entry" name="nameOfQues"
						type="number" requirred /><br /> <input id="submitButton"
						type="submit" value="Submit">
				</form>
			</div>
			<p>
			<h2>Success Store.</h2>
			</p>
		</div>

	</div>
</body>
</html>