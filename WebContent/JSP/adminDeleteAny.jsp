<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/adminDeleteAny.css">
<link rel="icon"
	href="${pageContext.request.contextPath}/IMAGE/logo.png"
	type="image/x-icon">
<title>Admin Delete ANY</title>
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

		<%
				HashMap<Integer,List<String>> deleteOptionMap=new HashMap<Integer,List<String>>();
				List<String> deleteOptionList=new ArrayList<String>();
				deleteOptionMap=(HashMap<Integer,List<String>>)request.getAttribute("deleteMap");
				String deleteIndex=request.getParameter("deleteIndex");
				String deleteWhatDisplay="";
				if(deleteIndex.equals("1"))
					deleteWhatDisplay="Select Category";
				else if(deleteIndex.equals("2"))
					deleteWhatDisplay="Select Set";
				else if(deleteIndex.equals("3"))
					deleteWhatDisplay="Select Topic";
				else if(deleteIndex.equals("4"))
					deleteWhatDisplay="Select Question";	
				System.out.println("Delete: "+deleteWhatDisplay);
			%>

		<div id="adminContent">

			<div id="menu">



				<form id="categoryForm"
					action="Check_Admin_Session_DeleteAny.Admin_Filter?category=<%=category %>&deleteIndex=<%=deleteIndex %>"
					method="Post">

					<select name="delete">
						<option value="" selected disabled><%= deleteWhatDisplay %></option>
						<%	
		    				for(Integer i:deleteOptionMap.keySet())
							{
		    			
								deleteOptionList=deleteOptionMap.get(i);
		    			%>


						<option name="option" value="<%= i %>"><%=deleteOptionList.get(0)%></option>
						<%
							}
			    		 %>
					</select> <input id="submitButton" type="submit" value="Submit">
				</form>



			</div>
		</div>
	</div>



</body>
</html>

</body>
</html>