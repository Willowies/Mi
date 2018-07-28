<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评价晒单</title>
</head>
<body>
	<%
	if(request.getAttribute("productList")!=null){
		List l = (List) request.getAttribute("productList");
		if (!l.isEmpty()) {
	%>
	<c:forEach items="${productList}" var="product">
		
			<p style="margin-left: 20px;width: 110px;">商品id ${product.productId}
				<form action="userToCommentDetails.action" method="post">
					<input type="text" name="productId" value="${product.productId}"  style="display: none;" />
					<button type="submit">查看评价</button>
				</form>
			</p>
			<p>商品名称：${product.productName} ${product.version} ${product.color}</p>
			<p>商品价格：${product.productPrice} </p>
			<p>${product.productCommentNum}人评价 </p>
			<img src="../${product.picUrl}" width="160px" height="160px" />
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