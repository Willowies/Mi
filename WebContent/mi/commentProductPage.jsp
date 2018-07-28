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
<p>好评：${goodNum}</p>
<p>中评：${middleNum}</p>
<p>差评：${badNum}</p>
		<form action="getCommentPage.action" method="post">
			<input name="productName" value="小米8" style="display: none;" />
			<button type="submit">回复</button>
		</form>

	<%
	if(request.getAttribute("hotComments")!=null){
		List l = (List) request.getAttribute("hotComments");
		if (!l.isEmpty()) {
	%>
	<p>热门评论：</p>
	<c:forEach items="${hotComments}" var="comment">
		
		<p>用户：${comment.user.userName}</p>
		<p>用户头像：${comment.user.userHead}</p>
		<p>评论：${comment.commentContent}</p>
		<p>评论时间：<fmt:formatDate value="${comment.commentDate}" type="date"/></p>
		<p>评论等级：${comment.commentRank}</p>
		<img src="../${comment.commentUrl}" width="160px" height="160px" />
			<p style="margin-left: 20px;width: 110px;">
				<form action="commentDetails.action" method="post">
					<input type="text" name="commentId" value="${comment.commentId}"  style="display: none;" />
					<button type="submit">查看回复</button>
				</form>
			</p>
		<c:forEach items="${comment.commentResponses}" var="response">
			<p>回复用户：${response.user.userName} </p>
			<p>回复内容：${response.commentContent} </p>
			<p>回复日期： <fmt:formatDate value="${response.commentDate}" type="date"/></p>
		</c:forEach>
	</c:forEach>
	<%
		} else {
	%>
	<p style="margin-left: 170px;">未查询到数据</p3>
	<%
		}
	}
	%>
	
	<%
	if(request.getAttribute("newComments")!=null){
		List l2 = (List) request.getAttribute("newComments");
		if (!l2.isEmpty()) {
	%>
	<p>最新评论：</p>
	<c:forEach items="${newComments}" var="comment">
		
		<p>用户：${comment.user.userName}</p>
		<p>用户头像：${comment.user.userHead}</p>
		<p>评论：${comment.commentContent}</p>
		<p>评论时间：<fmt:formatDate value="${comment.commentDate}" type="date"/></p>
		<p>评论等级：${comment.commentRank}</p>
		<img src="../${comment.commentUrl}" width="160px" height="160px" />
			<p style="margin-left: 20px;width: 110px;">
				<form action="commentDetails.action" method="post">
					<input type="text" name="commentId" value="${comment.commentId}"  style="display: none;" />
					<button type="submit">查看回复</button>
				</form>
			</p>
		<c:forEach items="${comment.commentResponses}" var="response">
			<p>回复用户：${response.user.userName} </p>
			<p>回复内容：${response.commentContent} </p>
			<p>回复日期： <fmt:formatDate value="${response.commentDate}" type="date"/></p>
		</c:forEach>
	</c:forEach>
	<%
		} else {
	%>
	<p style="margin-left: 170px;">未查询到数据</p3>
	<%
		}
	}
	%>
	
	<%
	if(request.getAttribute("rankComments")!=null){
		List l = (List) request.getAttribute("rankComments");
		if (!l.isEmpty()) {
	%>
	<p>好？评论：</p>
	<c:forEach items="${rankComments}" var="comment">
		
		<p>用户：${comment.user.userName}</p>
		<p>用户头像：${comment.user.userHead}</p>
		<p>评论：${comment.commentContent}</p>
		<p>评论时间：<fmt:formatDate value="${comment.commentDate}" type="date"/></p>
		<p>评论等级：${comment.commentRank}</p>
		<img src="../${comment.commentUrl}" width="160px" height="160px" />
			<p style="margin-left: 20px;width: 110px;">
				<form action="commentDetails.action" method="post">
					<input type="text" name="commentId" value="${comment.commentId}"  style="display: none;" />
					<button type="submit">查看回复</button>
				</form>
			</p>
		
		<c:forEach items="${comment.commentResponses}" var="response">
			<c:if test="${response.commentResponseId !=  0 }">
			<p>回复用户：${response.user.userName} </p>
			<p>回复内容：${response.commentContent} </p>
			<p>回复日期： <fmt:formatDate value="${response.commentDate}" type="date"/></p>
			</c:if>  
		</c:forEach>
		
	</c:forEach>
	<%
		} else {
	%>
	<p style="margin-left: 170px;">未查询到数据</p3>
	<%
		}
	}
	%>
</body>
</html>