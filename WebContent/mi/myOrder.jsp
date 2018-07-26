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
	<form action="getAllOrder.action" method="post">
		<button type="submit">提交</button>
	</form>
	<form action="getOrderByProductName.action" method="post">
		<input type="text" name="productName" required="required" />
		<button type="submit">提交</button>
	</form>
	<%
	if(request.getAttribute("orderList")!=null){
		List l = (List) request.getAttribute("orderList");
		if (!l.isEmpty()) {
	%>
	<p>页数：${pageTotal} </p>
	<c:forEach items="${orderList}" var="order">
		
			<p style="margin-left: 20px;width: 110px;">订单id ${order.orderId}
				<form action="getOrderDetailsById.action" method="post">
					<input type="number" name="orderId" value="${order.orderId}"  style="display: none;" />
					<button type="submit">详情</button>
				</form>
			</p>
			<p style="margin-left: 10px;width: 110px;">生成时间 <fmt:formatDate value="${order.createDate}" type="date"/></p>
			<p>用户：${order.user.userName} </p>
			<p>订单状态：${order.orderState} </p>
			<p>订单金额：${order.orderState} </p>
			<c:forEach items="${order.products}" var="product">
				<p>商品名称：${product.product.productName} </p>
				<p>商品数量：${product.quantity} </p>
				<p>商品价格：${product.productPrice} </p>
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