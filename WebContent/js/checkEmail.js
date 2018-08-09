function checkEmail(userId){
	var email = $("#email").val();
	requestUrl = 'sendVerificationCode.action?userId='+userId+'&emailAddress='+ email;
	alert(requestUrl);
	
	$.ajax({
		url: requestUrl,
		type: 'post'
		}
	)
}