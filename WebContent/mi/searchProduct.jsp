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
<script type="text/javascript" src="../js/jquery.min.js" ></script>
<script type="text/javascript">
function like(id)
{
       //Ajax调用处理
      $.ajax({
         type: "POST",
         url: "likeProductInSeachPage.action",
         data: "productId="+id,
         success: function(data){
      	   alert(data);
         }
      });
}
</script>
</head>
<body>

		<form action="getCommentPage.action" method="post">
			<input type="radio" value="价格高" name="searchType">价格高</input>
			<input type="radio" value="价格低" name="searchType">价格低</input>
			<input type="radio" value="推荐" name="searchType">推荐</input>
			<input type="radio" value="评价" name="searchType">评价多</input>
			<input type="radio" value="评价" name="requireCondition">显示评价</input>
			<input type="radio" value="有货" name="requireCondition">只显示有货</input>
			<input name="secondClassName" type="text"  />
			<input name="text" value="${text}" style="display: none;" />
			<button type="submit">搜索</button>
		</form>

	<%
	if(request.getAttribute("searchResults")!=null){
		List l = (List) request.getAttribute("searchResults");
		if (!l.isEmpty()) {
	%>
	<c:if test="${commentFormat == 0}">
	<c:forEach items="${searchResults}" var="result">
		
		<p>商品名称：${result.productName}</p>
		<p>商品价格：${result.productPrice}</p>
		<form action="productDetails.action" method="post">
			<input name="productName" value="${result.productOriginalName}" style="display: none;" />
			<button type="submit" ><img src="../${result.picUrl}" width="160px" height="160px" /></button>
		</form>
		<c:forEach items="${result.products}" var="product">

				<c:if test="${product.likeProduct == 0}">
   					<button onclick="like(${product.productId})" >喜欢<input name="pId" value="${product.productId}" style="display: none;" /></button>
				</c:if>
				<c:if test="${product.likeProduct == 1}">
   					<button >已喜欢</button>
				</c:if>
			</form>
			<p>商品颜色：${product.color}</p>
			<img src="../${product.picUrl}" width="50px" height="50px" />
		</c:forEach>

	</c:forEach>
	</c:if>
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