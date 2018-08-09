function checkEmail(userId,email){
	alert("进入");
	requestUrl = 'sendVerificationCode.action?userId='+userId+'&emailAddress='+ email;
	alert(requestUrl);
	
	$.ajax({
		url: requestUrl,
		type: 'post'
		}
	)
}