<%@page import="com.mi.model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="../css/selectUser.css" />
</head>
<body>
	<form action="updateUserHead.action" method="post" enctype="multipart/form-data">
		<div id="wrapper">
			<div id="upside">
				<div>
					<a href="outLogin.action"><img src="../images/mi-logo.png" /></a>
				</div>
				<div id="return">
					<a href="outLogin.action">退出</a>
				</div>
			</div>
			<div id="middleside">
				<div id="title-item">
					<div class="div1"><a href="updatePassword.jsp">修改密码</a></div>
					<div class="div1"><a href="selectUser.jsp" style="color:#ff7e00;">个人信息</a></div>
					<div class="div2">${sessionScope.user.userName}</div>
					<div class="div3">
						<img src="../${sessionScope.user.userHead}" />
					</div>
				</div>
				<div id="main-item">
					<div id="main-left">
						<div>
			                <img src="../${sessionScope.user.userHead}"/>
		                </div>
						<div id="setHead">
			                                               设置头像
			                <input type="file" name="userHeadImage">
		                </div>
						<div>
			                <button type="submit" >确定上传</button>
		                </div>
					</div>
					<div id="main-right">
						<div>
			                <input type="text" style="display:none" name="userId" value="${sessionScope.user.userId }" >
		                </div>
						<div class="text0">
							<span>个人基本资料</span>
							<span><a href="updateUser.jsp">编辑</a></span>
						</div>
						<hr />
						<div class="text1">
							<p>
								<span>用户名:</span>
								<span>${sessionScope.user.userName}
								
								</span>
							</p>
						</div>
						<hr />
						<div class="text1">
							<p>
								<span>&nbsp;生&nbsp;日:</span>
								<span> <fmt:formatDate value="${sessionScope.user.userBirth}" type="date"/></span>
							</p>
						</div>
						<hr />
						<div class="text1">
							<p>
								<span>&nbsp;性&nbsp;别:</span>
								<span>${sessionScope.user.userSex}</span>
							</p>
						</div>
						<hr />
						<div class="text1">
							<p>
								<span>手机号:</span>
								<span>${sessionScope.user.userPhone}</span>
							</p>
						</div>
						<hr />
						<div class="text1">
							<p>
								<span>&nbsp;邮&nbsp;箱:</span>
								<span>${sessionScope.user.userEmail}</span>
							</p>
						</div>
						<hr />
						<div class="text1">
							<p>
								<span>银行卡:</span>
								<span>${sessionScope.user.userCard}</span>
							</p>
						</div>
						<hr />
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