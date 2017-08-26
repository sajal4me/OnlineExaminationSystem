

var emailIndIn;
var emailIndUp;


$(document).ready(function(){
					var access_key='9dce54bbcdb14a4f4347bae41ba5b4bf';
					var email_address=$("#signEmail").val();
					var jsonFormat;
					var jsonSmtpCheck;
					
					$("#signEmail").blur(function(e) {
						$.ajax({
							url: 'http://apilayer.net/api/check?access_key=' + access_key + '&email=' + $("#signEmail").val(),
							
							dataType:'jsonp',
							
							
							
							success: function(json){
								jsonFormat=json.format_valid;
								jsonSmtpCheck=json.smtp_check;
								
								if(jsonFormat==true && jsonSmtpCheck==true)
									{
									    
									    $("#signEmail_help").html("");
									    emailIndIn=true;
										
									}
								else
									{
									 
									    $("#signEmail_help").html("Please Enter Valid Email Address");
									   emailIndIn=false;
										
									}
								
							}
						
						})
						});
					
					$("#regRmail").blur(function(e) {
						
						 $.ajax({
							url: 'http://apilayer.net/api/check?access_key=' + access_key + '&email=' + $("#regRmail").val(),
							
							dataType:'jsonp',
							
							
							
							success: function(json){
								jsonFormat=json.format_valid;
								jsonSmtpCheck=json.smtp_check;
																
								if(jsonFormat==true && jsonSmtpCheck==true)
									{
									    $("#email_help").html("");
									    emailIndUp=true;
									}
								else
									{
									    $("#email_help").html("Please Enter Valid Email Address");
									    emailIndUp=false;
									}	
							}
						})	
						
						});
					
});




function validateNonEmpty(data)
{
	if(data.value.length==0)
		{
			return false;
		}
	
	return true;
}


// Functions For Validation Of SignIn.



/*function validateEmail(emailId,emailId_help)
{
	var emailInd=validateNonEmpty(emailId);
	
	if(emailInd==true)
		{
			alert("Pre Start");
			if(emailId_help!=null)
				{
					alert("Start");
					var regexEmail=/^[\w\.-_\+]+@[\w-]+(\.\w{2,4})+$/;
					var regInd=regexEmail.test(emailId.value);
					if(regInd==true)
						{
							emailId_help.innerHTML="";
						
							return true;
						}
					else
						{
							emailId_help.innerHTML="Please Enter Valid Email-Id";
							return false;
						}
					
					
					
					
				
					var access_key='9dce54bbcdb14a4f4347bae41ba5b4bf';
					var email_address=emailId.value;
					
					alert(email_address);
					
					var jsonFormat;
					var jsonSmtpCheck;
					$.ajax({
						url: 'http://apilayer.net/api/check?access_key=' + access_key + '&email=' + email_address,
						
						dataType:'jsonp',
						
						success: function(json){
							
							alert("Here");
							jsonFormat=json.format_valid;
							jsonSmtpCheck=json.smtp_check;
							
							if(jsonFormat==true && jsonSmtpCheck==true)
								{
								    alert("Here if");
									emailId_help.innerHTML="";
									return true;
								}
							else
								{
								    alert("Here else");
									emailId_help.innerHTML="Email Not Exist";
									return false;
								}
							
						}
					
					
					
					
					})
					

					
				}
			
		}
	else
		{
			if(emailId_help!=null)
				{
					emailId_help.innerHTML="Email-Id Should Not Be Empty.";
					return false;
				}
		}
}*/

function validatePass(min,max,password,password_help)
{
	var passInd=validateNonEmpty(password);
	
	
	if(passInd==true)
		{
			if(password_help!=null)
				{
					var passwordLength=password.value.length;
					if(passwordLength>=min && passwordLength<=max )
					{
						password_help.innerHTML="";

						
						return true;
					}
					else
					{
						password_help.innerHTML="Password Should Be Of Length "+min+" to "+max+" characters. ";
						return false;
					}
				}
		}
	else
		{
			if(password_help!=null)
				{
					password_help.innerHTML="Password Should Not Be Empty.";
					return false;
				}
		}
}

function validateAllSignIn(form)
{
	var emailInd=false;
	var passInd=false;	
	emailInd=validateEmail(form["email"],document.getElementById("signEmail_help"));
	passInd=validatePass(6,15,form["pass"],document.getElementById("signPass_help"));
	
	/*alert(emailIndIn+" "+passInd);*/
	emailInd=emailIndIn;
	
	if(emailInd && validatePass(6,15,form["pass"],document.getElementById("signPass_help")))
		{
			
			form.submit();
		}
	else
		{
			
			alert("Sorry Please Enter Valid Data.");
		}
}

//Functions For Validation Of SignUp.

function validateName(name,name_help)
{
	
	var emptyNameInd=validateNonEmpty(name);
	if(emptyNameInd==true)
		{
			if(name_help!=null)
				{
					name_help.innerHTML="";
					return true;
				}
		}
	else
		{
			name_help.innerHTML="Name Should Not Be Empty";
			return false;
		}
}

function validateRePass(form,rePass_help)
{
	var rePassEmptyInd=validateNonEmpty(form["confirmPassUp"]);
											
	if(rePassEmptyInd==true)
		{
			if(rePass_help!=null)
				{
					var pass=form["passUp"].value;
					var confirmPass=form["confirmPassUp"].value;
					
					if(pass==confirmPass)
						{
							rePass_help.innerHTML="";
							return true;
						}
					else
						{
							rePass_help.innerHTML="Passwords Do Not Match";
							return false;
						}
				}
			else
				return false;
		}
	else
		{
			if(rePass_help!=null)
				{
					rePass_help.innerHTML="Password Should Not Be Empty";
					return false;
				}
		}
	
}

function validateMobileNumber(mobileNumber,mobileNumber_help)
{
	var mobNoEmptyInd=validateNonEmpty(mobileNumber);
	
	if(mobNoEmptyInd==true)
		{
			var regexMob=/^\d{10}$/;
			var mobregInd=regexMob.test(mobileNumber.value);
			
			if(mobregInd==true)
				{
					if(mobileNumber_help!=null)
						{
							mobileNumber_help.innerHTML="";
							return true;
						}
				}
			else
				{
					if(mobileNumber_help!=null)
						{
							mobileNumber_help.innerHTML="MobileNumber Format:'8587878471'";
						
						}
					return false;
				}
		}
	else
		{
			mobileNumber_help.innerHTML="Mobile Number Should Not Be Empty.";
			return false;
		}
	
}

function validateSecurityAnswer(secAnswer,secAnswer_help)
{
	var secAnswerNonEmptyInd=validateNonEmpty(secAnswer);
	if(secAnswerNonEmptyInd==true)
		{
			secAnswer_help.innerHTML="";
			return true;
		}
	else
		{
			if(secAnswer_help!=null)
				{
					secAnswer_help.innerHTML="Security Answer Should Not Be Empty.";
					
				}
			return false;
		}
}

function validateSignUpAll(form)
{
	var nameInd;
	var emailIndSignUp;
	var passInd;
	var repassInd;
	var mobInd;
	var secAnsInd;
	
	nameInd=validateName(form["nameUp"],document.getElementById("name_help"));
	/*alert(nameInd);*/
	
	emailIndSignUp=emailIndUp;
	/*alert(emailIndSignUp);*/
	
	passInd=validatePass(6,15,form["passUp"],document.getElementById("pass_help"));
	/*alert(passInd);*/
	
	repassInd=validateRePass(form,document.getElementById("rePass_help"));
	/*alert(repassInd);*/
	
	mobInd=validateMobileNumber(form["mobileNumberUp"],document.getElementById("mobileNumber_help"));
	/*alert(mobInd);*/
	
	secAnsInd=validateSecurityAnswer(form["ansUp"],document.getElementById("ans_help"));
	/*alert(secAnsInd);*/
	
	var x=nameInd+" "+emailIndSignUp+" "+passInd+" "+repassInd+" "+mobInd+" "+secAnsInd;
	/*alert(x);*/
	
	if(nameInd && emailIndSignUp && passInd && repassInd && mobInd && secAnsInd)
		{
			form.submit();
		}
	else
		{
			alert("Sorry Please Enter Valid Data.");
			form.reset();
			window.location.href="FetchSecurityQuestion";
		}
}





