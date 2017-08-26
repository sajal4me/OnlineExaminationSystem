


$(document).ready(function(){
	var url = window.location.search;
	var mainurl="Check_User_Session_GiveTest_JsFetch"+url;
	console.log(mainurl);
	
	var length;
	
	$.ajax({
        type: "GET",
        url:   mainurl,
        success: function (data){
        	
        	console.log(data);
        	questionList = data
        	lengthMain=Object.keys(data).length;
        	s(lengthMain);
        }
			
		});
});
		
	
function submitFunc(solutionArray,qidArray,cTime)
{
	
	console.log(solutionArray);
	console.log(qidArray);
	/*var time=localStorage.getItem("end1");*/
	/*var cTime=document.getElementById('clock').innerHTML;*/
	var appendUrl=(window.location.search);
	/*$.post("Check_User_Session_Getqans",{'qArray[]':qidArray,'solutionArray[]':solutionArray});*/
	
	alert("Time Less:"+cTime);
	
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


function s(lengthMain)
{

var minutesleft = (parseInt(lengthMain))*2; //give minutes you wish
var secondsleft = 0; // give seconds you wish
var finishedtext = "";
var end1;
if(localStorage.getItem("end1")) {
end1 = new Date(localStorage.getItem("end1"));
} else {
end1 = new Date();
end1.setMinutes(end1.getMinutes()+minutesleft);
end1.setSeconds(end1.getSeconds()+secondsleft);

}
var counter = function () {
var now = new Date();
var diff = end1 - now;

diff = new Date(diff);

	var milliseconds = parseInt((diff%1000)/100);
    var sec = parseInt((diff/1000)%60);
    var mins = parseInt((diff/(1000*60))%60);
    //var hours = parseInt((diff/(1000*60*60))%24);

if (mins < 10) {
    mins = "0" + mins;
}
if (sec < 10) { 
    sec = "0" + sec;
}     
if(now >= end1) {     
    clearTimeout(interval);
   // localStorage.setItem("end", null);
     localStorage.removeItem("end1");
     localStorage.clear();
     cTime=document.getElementById('clock').innerHTML;
    document.getElementById('clock').innerHTML = finishedtext;
    alert(cTime);
     submitFunc(solutionArray,qidArray,cTime);
} else {
    var value = mins + ":" + sec;
    localStorage.setItem("end1", end1);
    document.getElementById('clock').innerHTML = value;
}
}
var interval = setInterval(counter, 1000);
}