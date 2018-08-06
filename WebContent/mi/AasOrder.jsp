<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>order的列表便于选择</h3>
		<div>
			<table>
			  <tr>
			    <th></th>
			    <th>用户名</th>
			    <th>订单序号</th>
			  </tr>
			  <c:forEach items="${orders}"  var="os"  >
			  	 <tr>
				    <td>${os.receiverName}</td>
				    <td><a href="showOrderPro.action?orderId=${os.orderId}">${os.orderId}</a></td>
				  </tr>
			  </c:forEach>
			</table>
		</div>

</body>
</html>