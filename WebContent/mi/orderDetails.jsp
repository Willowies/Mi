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
	if(request.getAttribute("order")!=null){
	%>
			<p style="margin-left: 20px;width: 110px;">订单id ${order.orderId}</p3>
			<p style="margin-left: 10px;width: 110px;">生成时间 <fmt:formatDate value="${order.createDate}" type="date"/></p3>
			<p>用户：${order.receiverName} </p>
			<p>电话：${order.receiverPhone} </p>
			<p>地址：${order.receiverAddress} </p>
			<p>订单状态：${order.orderState} </p>
			<p>订单运费：${order.deliveryFee} </p>
			<p>实付：${order.actualTotal} </p>
			<p>发票：${order.invoice.content} </p>
			<c:if test="${order.coupon.couponId != 0}">
				<p>优惠价：${order.coupon.couponName} </p>
			</c:if>
			<c:forEach items="${order.products}" var="product">
				<p>商品名称：${product.product.productName} </p>
				<p>商品数量：${product.quantity} </p>
				<p>商品价格：${product.productPrice} </p>
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