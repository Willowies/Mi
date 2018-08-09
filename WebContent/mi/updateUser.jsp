<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑个人信息</title>
<link rel="stylesheet" type="text/css" href="../css/updateUser.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script>
	function validate(){
		var v = $ ("input[name='userCard']").val();		
		if(v!=null && v!=""){
			if(v<100000000000000 || v>999999999999999999999){
				$("#card").html("*银行卡位数错误 ");
				return false;
			}
		}
		
		return true;
	}
</script>
</head>
<body>
	<form action="updateUser.action" method="post" onsubmit="return validate()">	
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
				<div id="title-item">
					编辑个人信息
				</div>
				<div id="main-item" >
						<div>
							<input type="text" style="display:none" name="userId" value="${sessionScope.user.userId }" >
						</div>
						<h4>用户名:</h4>
					    <div class="div1">
						   <input type="text"  name="userName" placeholder="请输入2-10位长度的昵称" value="${errorMap.userName==null?sessionScope.user.userName:''}" />
						   <span style="color:red">${errorMap.userName }</span>
					    </div>
					    
					    <h4>生日:</h4>
					    <div class="div1">
						   <input type="Date"  name="userBirth" value="${sessionScope.user.userBirth}">
					    </div>
					    
					    <h4>性别:</h4>
					    <div class="div1">
						    <select name="userSex" value="${sessionScope.user.userSex}" >
					            <option value="男" >男</option>
					            <option value="女" >女</option>
				            </select>
			            </div>
			            
					    <h4>邮箱:</h4>
					    <div class="div1">
					        <input type="email"  name="userEmail" placeholder="请输入正确的邮箱格式" value="${errorMap.userEmail==null?sessionScope.user.userEmail:''}" />
			                <span style="color:red">${errorMap.userEmail }</span>
			            </div>
					    <h4>银行卡:</h4>
					    <div class="div1">
						    <input type="number"  name="userCard"  placeholder="请输入银行卡号" value="${errorMap.userCard==null?sessionScope.user.userCard:''}" />
			                <span style="color:red">${errorMap.userCard }</span>
			                <span id="card" style="color:red"></span>
					    </div>
					    <div class="div2">
							<a><input type="submit" value="保存" /></a>
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