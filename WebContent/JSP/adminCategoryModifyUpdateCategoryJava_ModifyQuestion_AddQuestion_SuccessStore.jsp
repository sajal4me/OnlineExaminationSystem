<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.model.CommonDAO,com.model.SQLConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

	<%
			CommonDAO commonDAOObject=CommonDAO.getNewCommonDAOObject();
			Connection con=commonDAOObject.getConnection();
			PreparedStatement pstmtCategory=con.prepareStatement(SQLConstants.SELECT_CATEGORY);
			PreparedStatement pstmtSet=con.prepareStatement(SQLConstants.SELECT_SET);
			PreparedStatement pstmtTopic=con.prepareStatement(SQLConstants.SELECT_TOPIC);
			ResultSet rsCategory=pstmtCategory.executeQuery();
			ResultSet rsSet=pstmtSet.executeQuery();
			ResultSet rsTopic=pstmtTopic.executeQuery();
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
					Add Question</p>
				<form id="categoryForm"
					action="Check_Admin_Session_ModifyCategory_UpdateCategory_Java_ModifyQuestion_AddQuestion_StoreQuestion.Admin_Filter"
					method="POST">
					Question &emsp;&nbsp;&nbsp;<input id="entry" name="question"
						type="text" required /><br /> Option:&emsp;&emsp;A<input id=""
						type="text" name="option1" /><br />
					&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;B<input id="opt" type="text"
						name="option2" /><br /> &emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;C<input
						id="opt" type="text" name="option3" /><br />
					&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;D<input id="opt" type="text"
						name="option4" /><br /> Answer &nbsp;&emsp;&emsp;<input id="entry"
						type="text" required /><br /> Set
					&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&emsp;<select id="regSecurity"
						name="set" required>
						<option value="" selected disabled>Choose Set</option>
						<%
								
								
								while(rsSet.next())
								{
								
									int setId=rsSet.getInt(1);
									
									%>

						<option value=<%= setId%>>
							<%=  setId  %>
						</option>
						<% 	
								}
							
							%>

						<!-- <option selected disabled>Choose set &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</option>
									<option>xxxx</option>
									<option>yyyy</option>
									<option>zzzz</option>
									<option>aaaa</option> -->
					</select><br /> Topic &nbsp;&emsp;&emsp;&emsp;<select id="regSecurity"
						name="topic" required>
						<option value="" selected disabled>Choose Topic</option>
						<%
								
								
								while(rsTopic.next())
								{
									int topicId=rsTopic.getInt(1);
									String topic=rsTopic.getString(3);
									%>

						<option value=<%= topicId%>>
							<%=  topic  %>
						</option>
						<% 	
								}
							
							%>

						<!-- <option selected disabled>Choose topic &emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;</option>
									<option>xxxx</option>
									<option>yyyy</option>
									<option>zzzz</option>
									<option>aaaa</option> -->
					</select><br /> Category &nbsp;&emsp; <select id="regSecurity"
						name="category" required>
						<option value="" selected disabled>Choose Category</option>
						<%
								
								
								while(rsCategory.next())
								{
									int CategoryId=rsCategory.getInt(1);
									String Category=rsCategory.getString(2);
									%>

						<option value=<%= CategoryId%>>
							<%=  Category  %>
						</option>
						<% 	
								}
							
							%>
						<!-- <option selected disabled>Choose category &emsp;&emsp;&emsp;&nbsp;&nbsp;</option>
									<option>xxxx</option>
									<option>yyyy</option>
									<option>zzzz</option>
									<option>aaaa</option> -->
					</select><br /> <input id="submitButton" type="submit" value="Add">
				</form>
			</div>
		</div>
	</div>
</body>
</html>