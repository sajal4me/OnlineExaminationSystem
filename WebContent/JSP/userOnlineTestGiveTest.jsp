<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<%@ page import="org.json.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src='JS/userOnlineTestGiveTest.js'></script>
<script src='JS/timer.js'></script>

<!-- <script>
			window.location.hash="no-back-button";
			window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
			window.onhashchange=function(){window.location.hash="no-back-button";}
		</script>  -->


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/userOnlineTestGiveTest.css">

<title>Test</title>
<body>
	<%
			System.out.println("**JSP**userOnlineTestGiveTest.jsp");
		%>
	<%-- <%!int i=0;
		HashMap<Integer,List<String>> questionMap;
		
		%>
		<% 
				 questionMap=(HashMap<Integer,List<String>>)request.getAttribute("questionMap");
				List<String> questionList=new ArrayList<String>();
				Set<Integer> questionSet=questionMap.keySet();
				
					String initialId=request.getParameter("initialId");
					
					i=Integer.parseInt(initialId);
					
					
					
					
			
			%> --%>

	<div id="centerContent">

		<div id="question">

			<h3 id="questionTitle">Questions</h3>

			<div id="optionButton"></div>
		</div>

		<input type="hidden" name="quesLoop" id="quesLoop" value=<%-- <%=i %> --%>/>

		<div id="displayQuestion">

			<%-- <%
				   questionList=(questionMap.get(i));
				
				%>
				 --%>
			<div id="ques">
				<p>
					<%-- <%=questionList.get(1) %> --%>
				</p>
			</div>
			<div id="option1">
				<input type="radio" name="opt" value="1"><span></span>
			</div>
			<div id="option2">
				<input type="radio" name="opt" value="2"><span></span>
			</div>
			<div id="option3">
				<input type="radio" name="opt" value="3"><span></span>
			</div>
			<div id="option4">
				<input type="radio" name="opt" value="4"><span></span>
			</div>

		</div>
		<div id="testTimer">
			<div id="clock"></div>
			<h5>TIME REMAINING</h5>
			<p id="line"></p>
			<div id="current"></div>
			<p id="p1">Current Question</p>
			<div id="unattempted"></div>
			<p id="p2">Unattempted</p>
			<div id="visited"></div>
			<p id="p3">Visited</p>

		</div>

		<div id="viewQuestion">
			<button id="previous">PREVIOUS</button>
			<button id="next">NEXT</button>
			<button id="submit">SUBMIT TEST</button>
		</div>

	</div>
</body>
</html>
