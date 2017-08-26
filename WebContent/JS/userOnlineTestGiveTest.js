var solutionArray={};
var qidArray={};
var time;
var cTime;


$(document).ready(function(){
	var url = window.location.search;
	var mainurl="Check_User_Session_GiveTest_JsFetch"+url;
	var questionList;
	var curbutIndex=0;
	var maincurbutIndex=0;
	
	var length;
	
	$.ajax({
        type: "GET" ,
        url:   mainurl ,
        success: function (data){
        	var lengthMain;
        	questionList = data;
        	lengthMain=(Object.keys(data).length);
        	length=lengthMain;
        	for(var index=0;index < Object.keys(data).length;index++)
        	{
        			
        			qidArray[index]=questionList[index][0];
        	}
        	      	
    		setQuestionAndOptions(1);
    		maincurbutIndex=1;
  
            for(var index=0; index < Object.keys(data).length; index++){
            	var anchorElement = document.createElement("a");
            	anchorElement.innerHTML = index + 1;
            	anchorElement.href='';
            	$("#optionButton").append(anchorElement);
            }
            
           
            $('input[type=radio][name=opt]').change(function() {
        		event.preventDefault();
        		event.stopPropagation();
        		
        		if(maincurbutIndex<=lengthMain)
        		{
        		solutionArray[maincurbutIndex-1]=this.value;
        		}
            });
            
        	$("#optionButton a").click(myFunc);
        	$("#next").click(myNextFunc);    
        	$("#previous").click(myPreFunc);
        	$("#submit").click(submitFunc);
        }
	});
	
	function myNextFunc(event)
	{
		event.preventDefault();
		event.stopPropagation();
		var length=Object.keys(questionList).length;
		if(maincurbutIndex<length)
		{
			maincurbutIndex++;
			setQuestionAndOptions(maincurbutIndex);
		}	
	}
	function myPreFunc(event)
	{
		event.preventDefault();
		event.stopPropagation();
		if(maincurbutIndex>1)
		{
		maincurbutIndex--;
		
		setQuestionAndOptions(maincurbutIndex);
		}
	}
	function submitFunc(event)
	{
		event.preventDefault();
		event.stopPropagation();
		console.log(solutionArray);
		console.log(qidArray);
		time=localStorage.getItem("end1");
		cTime=document.getElementById('clock').innerHTML;
		alert(cTime);
		var appendUrl=(window.location.search);
		/*$.post("Check_User_Session_Getqans",{'qArray[]':qidArray,'solutionArray[]':solutionArray});*/
		
		$.ajax({
			url:"Check_User_Session_Getqans"+appendUrl,
			type:"post",
			datatype:"JSON",
			data:{solutionArray: JSON.stringify(solutionArray),questionArray: JSON.stringify(qidArray),length:length,time:cTime},
			
			success:function(data){
				var arr = $.map(data, function(el) { return el });
				var url="JSP/userOnlineTestResult.jsp"+"?data="+arr;
				localStorage.removeItem("end1");
			    localStorage.clear();
				window.location.href=url;
			}
		});
	}
	
	
	function myFunc(event){
		event.preventDefault();
		event.stopPropagation();
		$(this).css("background-color", "green");
		setQuestionAndOptions($(this)[0].innerHTML);
		maincurbutIndex=($(this)[0].innerHTML);//Inner Html Gives Value Of Dynamic Anchor Tag.
		console.log("maincurbutIndex");
		console.log(maincurbutIndex);
	}
	
	
	function setQuestionAndOptions(index){
		index = parseInt(index) - 1;
		qidArray[index]=questionList[index][0];
		$("#ques").text(questionList[index][1]);
        $("#option1").children("span").text(questionList[index][2]);
        $("#option2").children("span").text(questionList[index][3]);
        $("#option3").children("span").text(questionList[index][4]);
        $("#option4").children("span").text(questionList[index][5]);
	}
});



