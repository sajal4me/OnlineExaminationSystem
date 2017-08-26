<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page session="false"%>
<!Doctype html>
<html lang="en">
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="JS/register.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/SignIn.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/OnlineExamination.css">
<link rel="shortcut icon" href="IMAGE/tabLogo.png" />
<title>Registration</title>
</head>

<body>
	<jsp:include page="header.jsp" />

	<%
			System.out.println("Register.jsp");
		%>

	<div id="centerContent">
		<!--center content-->
		<div id="signInRegForm">
			<table id="formTable">
				<tr>
					<td id="signPart" width="400">
						<h3>Sign In</h3>
						<hr />
						<p>Sign in using your registered account:</p>
						<form action="SignIn" method="post" name="signIn">
							<input id="signEmail" type="text" name="email"
								placeholder="Enter email here" required /> <br /> <span
								style="color: #ff6666" id="signEmail_help"></span> <br /> <input
								id="signPass" type="password" name="pass"
								placeholder="Enter Password here"
								onblur="validatePass(6,15,this,document.getElementById('signPass_help'))"
								required /><br /> <span style="color: #ff6666"
								id="signPass_help"></span> <br /> <input id="signSubmit"
								onclick="validateAllSignIn(this.form)" type="submit"
								value="SignIn" /><br /> <a
								href="<%= request.getContextPath() %>/JSP/PasswordRecovery.jsp"
								name="passRecovery" style="text-decoration: none">Forget
								Password?/Click here</a>

						</form>
					</td>
					<td id="regPart" width="500">
						<h3>Register</h3>
						<hr />
						<p>Enter your details here:</p>

						<form action="<%=request.getContextPath()%>/JSP/Register.jsp"
							onsubmit="return validateSignUpAll(this);" method="Post">
							<%
                                if(request.getParameter("security")!=null)
                                {
                                	
 							  /*   	String s=request.getContextPath();
                                	System.out.println(s); */
                                	ServletContext context=getServletContext();
                                	RequestDispatcher rD=context.getRequestDispatcher("/SignUp");
                                	
                                	
                                	rD.forward(request,response);
                                }
                                
                            %>
							<input id="regName" type="text" name="nameUp"
								placeholder="Enter Name here"
								onblur="validateName(this,document.getElementById('name_help'))"
								required /> <br /> <span style="color: #ff6666" id="name_help"></span>
							<br /> <input id="regRmail" type="email" name="emailUp"
								placeholder="Enter email here" required /> <br /> <span
								style="color: #ff6666" id="email_help"></span> <br /> <input
								id="regPass" type="password" name="passUp"
								placeholder="Enter Password here"
								onblur="validatePass(6,15,this,document.getElementById('pass_help'))"
								required /> <br /> <span style="color: #ff6666" id="pass_help"></span>
							<br /> <input id="regConfirmPass" type="password"
								name="confirmPassUp" placeholder="Re-enter Password here"
								onblur="validateRePass(this.form,document.getElementById('rePass_help'))"
								required /> <br /> <span style="color: #ff6666" id="rePass_help"></span>
							<br /> <input id="regContact" name="mobileNumberUp" type="number"
								maxlength="10" placeholder="Mobile Number"
								onblur="validateMobileNumber(this,document.getElementById('mobileNumber_help'))"
								required /> </br> <span style="color: #ff6666"
								id="mobileNumber_help"></span> <br /> <select id="regSecurity"
								name="security" required></br>
								<option value="" selected disabled>Choose security
									question</option>


								<%! String tempQuestion; %>
								<%
									  if(request.getParameter("security")==null)
									  {
									  HashMap<Integer,String> questionMap=new HashMap<Integer,String>();
									  
									  questionMap=(HashMap<Integer,String>)request.getAttribute("questionMap");
									  
									   
									  Set<Integer> keys=questionMap.keySet();	
									  Iterator<Integer> itr=keys.iterator();	   
										   while(itr.hasNext())
										   {
											   Integer key=itr.next();
											   String value=questionMap.get(key);
											   tempQuestion=value;
											  %>

								<option id="dynamicOption" value=<%= key %>>
									<%=  tempQuestion  %>
								</option>

								<% 
										   }
									  }
										  
										    
									%>

								<!-- <option >Mother Maiden Name</option>
						    <option> Birth Place</option> -->
							</select> <input id="ans" type="text" name="ansUp"
								placeholder="Enter security answer here"
								onblur="validateSecurityAnswer(this,document.getElementById('ans_help'))"
								required><br /> <span style="color: #ff6666"
								id="ans_help"></span> <br /> <input type="submit" id="signUpReg"
								value="Register" onclick="validateSignUpAll(this.form)" />

						</form>
					</td>
				</tr>
			</table>

		</div>
	</div>





	<jsp:include page="footer.jsp" />

</body>
</html>
