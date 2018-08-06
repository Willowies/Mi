<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addUserId.action">
		<input type="text" name="userId">
		<button type="submit">向session添加User</button>
	</form>
	
	<form action="addCartItem.action">
		<input type="text" name="productId">
		<button type="submit">向购物车中添加商品</button>
	</form>

	<form action="findCartItem.action">
		<button type="submit">前往购物车</button>
	</form>
	<form action="recommendProduct.action">
		<button type="submit">推荐商品</button>
	</form>
	<c:forEach items="${products}" var="p">
		<p>${p.picUrl }</p>
		<p>${p.extremeName }</p>
		<p>${p.productPrice }</p>
		<p></p>
	</c:forEach>
	<p>${cartItem.product.extremeName}</p>
	<%
		Object message = request.getAttribute("message");
		if(message!=null&&!"".equals(message)){
	%>
		<script type="text/javascript">
		alert("<%=message%>");
		</script>
	<%
		}
	%>
</body>
</html>