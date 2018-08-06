<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="selectLikeProduct.action" method="post">
		<button type="submit">查询</button>
	</form>
	
	<div>
		<table>
			<tr>
				<th></th>
				<th>喜欢商品数量</th> 
			</tr>
			<tr>
				<td>${user.userName}</td>
				<td>${user.userHead}</td>
				<td>${user.userPhone}</td>
				<td>${user.userEmail}</td>
				<td>${user.userId}</td>
			</tr>
			
		<c:forEach items="${resultList}" var="likeProduct" >
			<tr>
				<td>${likeProduct.likeProductId}</td>
				<td>${likeProduct.userId}</td>
				<td>${likeProduct.product.productName}</td>
				<td>${likeProduct.product.description}</td>
				<td>${likeProduct.product.productPrice}</td>
			</tr>
		</c:forEach>
			
		</table>
	</div>
	
	
</body>
</html>