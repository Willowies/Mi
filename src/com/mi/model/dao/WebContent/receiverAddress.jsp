<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addReceiverAddress.action" method="post">
		<input type="text" name = "receiverName" placeholder="receiverName"/>
		<input type="text" name = "receiverPhone" placeholder="receiverPhone"/>
		<input type="text" name = "receiverProvince" placeholder="receiverProvince"/>
		<input type="text" name = "receiverCity" placeholder="receiverCity"/>
		<input type="text" name = "receiverDistrict" placeholder="receiverDistrict"/>
		<input type="text" name = "address" placeholder="address"/>
		<input type="text" name = "addressLabel" placeholder="addressLabel"/>
		<button type="submit">添加</button>
	</form>
	
	<div>
		<table>
			<tr>
				<th></th>
				<th>添加收货地址</th> 
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