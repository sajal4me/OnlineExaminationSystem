<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/TestCategory.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/OnlineExamination.css">
<title>Insert title here</title>
</head>
<body>

	<%
			Map<Integer,List<String>> catsettopMap =new LinkedHashMap<Integer,List<String>>();
			System.out.println("userOnlineTestCategory.jsp");
			HttpSession sess=request.getSession(false);
			if(sess!=null)
			{
		
		%>
	<jsp:include page="loggedinHeader.jsp" />
	<%
			}
			else
			{
		%>
	<jsp:include page="header.jsp" />
	<%
			}
		%>

	<div id="centerContent">

		<!-- Fetch Map Data Which Stores All The Category DATA. -->
		<%
				
				List<String> catsettopList=new ArrayList<String>();
				catsettopMap=(Map<Integer,List<String> >)request.getAttribute("catsettopMap");
				System.out.println(request.getAttribute("catsettopMap"));
				for(Integer k:catsettopMap.keySet())
				{
					
					catsettopList=(catsettopMap.get(k));
					
				%>


		<div id="comcategory">
			<p id="Lang"><%=catsettopList.get(0) %></p>
			<p>
				Number Of Set:<%=catsettopList.get(1) %></p>
			<p>
				Number Of Topic:<%= catsettopList.get(2) %></p>
			<input type="hidden" name="categoryName"
				value="<%= catsettopList.get(0)%>"> <a
				href="Check_User_Session_SetTopic.Exam_Filter?catsettopList=<%= catsettopList.get(1) %>&catsettopList=<%= catsettopList.get(2)%>&categoryName=<%= catsettopList.get(0)%>">
				<button id="StartTest" >START TEST</button>
				
			</a>
		</div>

		<!-- <div id="C1"><p id="Lang">C</p><p>Number Of Set:10</p><p>Number Of Question per Set:20</p><p>Duration per Set:20min</p><a href="TestArea.html"><button id="StartTest">START TEST<button></a></div>
			<div id="Cplus1"><p id="Lang">C++</p><p>Number Of Set:10</p><p>Number Of Question per Set:20</p><p>Duration per Set:20min</p><a href="TestArea.html"><button id="StartTest">START TEST<button></a></div> -->

		<%
				}
			%>


	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>