<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/OnlineExamination.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/setTopicDetails.css">

<title>Insert title here</title>
</head>
<body>

	<jsp:include page="loggedinHeader.jsp" />


	<div id="centerContent">

		<!-- Fetch Map Data Which Stores All The Category DATA. -->
		<%
				
				System.out.println("**JSP**--userOnlineTestSetTopicDetails.jsp");
				String subcatName=(String)request.getAttribute("subcategoryName");
				
				
				Map<Integer,List<String>> setTopicMap=new LinkedHashMap<Integer,List<String>>();
				List<String> setTopicList=new ArrayList<String>();
				if(subcatName.equalsIgnoreCase("topic"))
				{
				setTopicMap=(Map<Integer,List<String>>)request.getAttribute("topicIdNameMap");
				System.out.println(setTopicMap);
				for(Integer k:setTopicMap.keySet())
				{
					
					setTopicList=(setTopicMap.get(k));
					
				%>


		<div id="comcategory">
			<p id="Lang"><%=setTopicList.get(1) %></p>
			<%-- <p><%=setTopicList.get(1) %></p> --%>


			<a
				href="Check_User_Session_InstructionsTest.Exam_Filter?subcategory=<%=subcatName %>&topicId=<%= setTopicList.get(0)%>">
				<button id="StartTest">
					START TEST
					<button>
			</a>
		</div>



		<%
				}
				
				%>



		<% 
				}
				else if(subcatName.equalsIgnoreCase("set"))
				{
					setTopicMap=(Map<Integer,List<String>>)request.getAttribute("setIdQuesMap");
					System.out.println(setTopicMap);
					for(Integer k:setTopicMap.keySet())
					{
						
						setTopicList=(setTopicMap.get(k));
						
					%>


		<div id="comcategory">
			<p id="Lang"><%= subcatName%><%=setTopicList.get(0) %></p>
			<p>
				No Of Ques:<%=setTopicList.get(1) %></p>


			<a
				href="Check_User_Session_InstructionsTest.Exam_Filter?subcategory=<%=subcatName %>&setId=<%=setTopicList.get(0)%> ">
				<button id="StartTest">
					START TEST
					<button>
			</a>
		</div>



		<%
					}
				}
				%>


	</div>



	<jsp:include page="footer.jsp" />

</body>
</html>