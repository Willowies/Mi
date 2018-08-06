<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="../css/login.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
	<%
	if(request.getAttribute("loginError")!=null){
	%>
			alert("${loginError}");
	<%
	}
	%>
</script>
</head>
<body>
	<form action="login.action" method="post">	
		<div id="wrapper">
			<div id="upside">
				<div id="logo-item">
					<img src="../images/logo.jpg"/>
				</div>
				<div id="title-item">
					小米账号登录
				</div>
				<div id="main-item">
					<div class="div1">
						<input type="text" name="userPhone" placeholder="请输入手机号"/>
					</div>
					<div class="div1">
						<input type="password" name="userPassword" placeholder="请输入密码"/>
					</div>
					<div class="div2">
						<a><input type="submit" value="登录" /></a>
					</div>
					<div class="div3">
						<a href="addUser.jsp">立即注册？</a>
					</div>
					<div class="div3" style="color:red">${loginError }</div>
				</div>
			</div>
			<div id="footer">
				小米公司版权所有-京ICP备10046444-京公网安备11010802020134号-京ICP证110507号
			</div>
		</div>
		
	</form>
</body>
</html>