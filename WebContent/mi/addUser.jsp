<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="../css/addUser.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
			function validate() {
				var v = $ ("input[name='userPhone']").val();
				
				var t= $.ajax({
					type: "POST",
					url: "selectUserPhone.action",
					data: "userPhone=" + v,
					async: false
				}).responseText;
				
				if(t == 'true'){
					var i1= $ ("input[name='userPassword']").val();
					var i2= $ ("input[name='userRePassword']").val();
					if(i1 == i2 && i1!=null && i1!=''){
						return true;
					}else{
						$("#repwd").html("*两次密码不一致 ");
						return false;
					}
					return true;
				}else if(t == 'false'){
					alert("该手机号已注册，请登录");
					return false;
				}
				
			}
</script>
</head>
<body>
	<form action="addUser.action" method="post" onsubmit="return validate()">	
		<div id="wrapper">
			<div id="upside">
				<div id="logo-item">
					<a href="homepage.jsp"><img src="../images/logo.jpg"/></a>
				</div>
				<div id="title-item">
					注册小米账号
				</div>
				<div id="main-item">
					<h4>手机号:</h4>
					<div class="div1">
						<input type="text" name="userPhone"  placeholder="请输入手机号" value="${errorMap.userPhone==null?user.userPhone:''}" />
						<span style="color:red">${errorMap.userPhone }</span>
					</div>
					<h4>密码:</h4>
					<div class="div1">
						<input type="password"  name="userPassword"  placeholder="请输入3-16位数字、字母、下划线组合" value="${errorMap.userPassword==null?user.userPassword:''}"/>
						<span style="color:red">${errorMap.userPassword }</span>
					</div>
					<h4>确认密码:</h4>
					<div class="div1">
						<input type="password" name="userRePassword" placeholder="再次输入密码"/>
						<span id="repwd" style="color:red"></span>
					</div>
					<div class="div2">
						<a><input type="submit" value="立即注册" /></a>
					</div>
					<div class="div3">
						<a href="login.jsp">立即登录</a>
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