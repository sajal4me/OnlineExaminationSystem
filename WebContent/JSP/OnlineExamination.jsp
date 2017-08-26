<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <!-- <script>

			function resizePage()

			{
				document.getElementById("containerThree").style.height=(document.body.clientHeight-999)*0.9;
			}
		
		</script> -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/OnlineExamination.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/CSS/newOnlineExamination.css">
</head>
<body>


	<!-- // Including Header in Page. -->

	<jsp:include page="header.jsp" />
	<div id="containerOne">


		<div id="gallery">
			<div id=galleryMsg>
				<strong><marquee>
						<p>
							<i>Don't Stress. Do Your Best. Forget The Rest. </i>
						</p>
					</marquee></strong>
			</div>
			<div id="pic">
				<img id="myPhoto"
					src="<%=request.getContextPath() %>/IMAGE/onlineExam3.jpg"
					alt="sunset beach" />
				<script type="text/javascript">
						var myImage=document.getElementById("myPhoto");
						var imageArray=["<%=request.getContextPath() %>/IMAGE/onlineExam1.jpg","<%=request.getContextPath() %>/IMAGE/onlineExam2.jpg","<%=request.getContextPath() %>/IMAGE/onlineExam3.jpg","<%=request.getContextPath() %>/IMAGE/onlineExam4.jpg","<%=request.getContextPath() %>/IMAGE/onlineExam5.jpg"];
						var imageIndex=0;
						function changeImage()
						{
						 myPhoto.setAttribute("src",imageArray[imageIndex]);
						 imageIndex++;
						 if(imageIndex>=imageArray.length)
						   {
							 imageIndex=0;
						   }
						}
						var intervalHandle=setInterval(changeImage,1500);
						myPhoto.onclick=function()
						{
							clearInterval(intervalHandle);
							}
					</script>
			</div>
		</div>
	</div>

	<!-- Description About Site. -->
	<div id="containerTwo" name="containerTwo">
		<div id="message">
			<p id="titleVision">What is Online Test</p>
			<p id="visionContent">
				<i>"Nowadays, online exam or test is the most popular process
					for selection candidates in employment sector or education sector.
					The traditional examination procedure was costly, maximum effort
					very lengthy process. That why the exam process has been replaced
					by online exam in the present times. This modern process of
					assessment has been accepted in maximum no of Government sector,
					recognized organization, public sector and institutions to
					selection the best candidate. The main benefit of this modern
					process is to save papers, low cost, minimum employee requirement
					to conduct this process, minimum effort, saving time, instant
					result and conduct this exam in India as well as abroad.."</i>
			</p>
		</div>
		<div id="OES">
			<div id="titleFirst">
				<p>Why you like OES ?</p>
			</div>
			<p id="OESContent">
				<i>" All questions are selected by most experienced faculty and
					teachers.<br> Review your perivious tes performance and
					progress.<br> All the online test of this site are free of
					cost.<br> Free and Unlimited test serise are available.<br>
					Free and Simple Registration."
				</i>
			</p>
		</div>

	</div>



	<!-- //Including Footer in JSP. -->

	<jsp:include page="footer.jsp" />


</body>
</html>