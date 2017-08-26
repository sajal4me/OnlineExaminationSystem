<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/userOnlineTestInstructions.css">
<title>Instructions</title>

<!-- <script>
		window.location.hash="no-back-button";
		window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
		window.onhashchange=function(){window.location.hash="no-back-button";}
	</script>  -->
</head>
<body>

	<div id="centerContent">


		<h3 id="title">INSTRUCTION</h3>
		<div id="left"></div>


		<div id="Instruction">
			<!-- <div id="option0"><p>1.   Total number of questions : 20.</p></div> -->
			<div id="option1">
				<p>1. Time alloted : (No. Of Question*2) minutes.</p>
			</div>
			<div id="option2">
				<p>2. Each question carry 2 mark, no negative marks.</p>
			</div>
			<div id="option3">
				<p>3. DO NOT refresh the page.</p>
			</div>
			<div id="option4">
				<p>4. All the best :-).</p>
			</div>
		</div>

		<div id="testTimer"></div>

		<%
								HttpSession sess=request.getSession(false);
								String catName=(String) sess.getAttribute("categoryName");
								System.out.println(catName);
								String setId,topicId;
								System.out.println("**JSP**-userOnlineTestInstruction.jsp");
								String subcatName=(String)request.getAttribute("subcatName");
								if(subcatName.equalsIgnoreCase("set"))
								{
									setId=((String)request.getAttribute("setId"));
							%>




		<a
			href="Check_User_Session_GiveTest.Exam_Filter?catName=<%=catName %>&subcatName=<%=subcatName%>&setId=<%=setId%>">
			<button id="startTest">START TEST</button>
		</a>

		<%		
								}
								else if(subcatName.equalsIgnoreCase("topic"))
								{
									topicId=((String)request.getAttribute("topicId"));
								%>




		<a
			href="Check_User_Session_GiveTest.Exam_Filter?catName=<%=catName %>&subcatName=<%=subcatName%>&topicId=<%=topicId%>">
			<button id="startTest">START TEST</button>
		</a>

		<% 
								}
							
							%>




	</div>

</body>
</html>