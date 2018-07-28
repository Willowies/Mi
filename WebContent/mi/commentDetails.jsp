<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page import="java.util.List"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getAttribute("comment")!=null){
	%>
		<p>用户：${comment.user.userName}</p>
		<p>用户头像：${comment.user.userHead}</p>
		<p>评论：${comment.commentContent}</p>
		<p>评论时间：<fmt:formatDate value="${comment.commentDate}" type="date"/></p>
		<p>评论等级：${comment.commentRank}</p>
		<img src="../${comment.commentUrl}" width="160px" height="160px" />
		<form action="responseComment.action" method="post">
			<input name="commentId" value="${comment.commentId}" style="display: none;" />
			<input name="productId" value="${comment.product.productId}" style="display: none;" />
			<textarea name="commentContent" clos=",50" rows="5" warp="virtual"></textarea>
			<button type="submit">回复</button>
		</form>
		<c:forEach items="${comment.commentResponses}" var="response">
			<p>回复用户：${response.user.userName} </p>
			<p>回复内容：${response.commentContent} </p>
			<p>回复日期： <fmt:formatDate value="${response.commentDate}" type="date"/></p>
		</c:forEach>
		
	<%
		} else {
	%>
	<p style="margin-left: 170px;">未知错误</p3>
	<%
		}
	%>
</body>
</html>