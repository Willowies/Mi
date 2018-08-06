<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="../css/updatePassword.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script>
	<%
	if(request.getAttribute("oldPasswordMsg")!=null){
	%>
			alert("${oldPasswordMsg}");
	<%
	}
	%>
	<%
	if(request.getAttribute("rePasswordMsg")!=null){
	%>
			alert("${rePasswordMsg}");
	<%
	}
	%>
	
	
	/* function validate(){
		
		var p1 = $ ("input[name='userPassword']").val();
		var p2 = $ ("input[name='reUserPassword']").val();
		if(p1 == p2 && p1!=null && p1!=''){
			
			return true;			
		}else{
			alert("两次密码不一致");
			return false;
		}
		
	} */
</script>
</head>
<body>		
	<form action="updatePassword.action" method="post" onsubmit="return validate()">
		<div id="wrapper">
			<div id="upside">
				<div>
					<a href="outLogin.action"><img src="../images/mi-logo.png" /></a>
				</div>
				<div id="return">
					<a href="selectUser.jsp">取消</a>
				</div>
			</div>
			<div id="middleside">
				<div>
					<input type="text" style="display:none" name="userId" value="${sessionScope.user.userId }" >
				</div>
				<div id="title-item">
					修改密码
				</div>
				<div id="main-item" >					
						<h4>原密码:</h4>
					    <div class="div1">
						   <input type="password" name="oldPassword" placeholder="输入原始密码" />
						   <span style="color:red">${oldPasswordMsg}</span>
					    </div>
					    
					    <h4>新密码:</h4>
					    <div class="div1">
						   <input type="password" name="userPassword" placeholder="输入新密码" required="required" />
					    </div>

					    <div class="div1">
						    <input type="password" name="reUserPassword" placeholder="重复新密码" required="required" />
						    <span id="reuserpwd"></span>
					    </div>
					    <div class="div2">
							<a><input type="submit" value="提交"></a>						
						</div>
				</div>
			</div>
			<div id="footer">
				小米公司版权所有-京ICP备10046444-京公网安备11010802020134号-京ICP证110507号
			</div>
		</div>
	
	</form>
</body>
</html>