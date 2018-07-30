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

</head>
<body>

		<form action="getSpikeProductByTime.action" method="post">
			<input  type="date" name="date" required="required" >
			<select name="time">
			  <option value ="10">十点场</option>
			  <option value="12">十二点场</option>
			  <option value="18">十八点场</option>
			  <option value="20">二十点场</option>
			  <option value="22">二十二点场</option>
			</select>
			<button type="submit">搜索</button>
		</form>

	<%
	if(request.getAttribute("state")!=null){
		
	if(request.getAttribute("productList")!=null){
		List l = (List) request.getAttribute("productList");
		if (!l.isEmpty()) {
	%>
	
	<c:forEach items="${productList}" var="product">
		
		<p>商品id：${product.spikeProductId}</p>
		<p>商品名称：${product.productName}</p>
		<p>商品价格：${product.spikePrice}</p>
		<p>商品数量：${product.spikeQuantity}</p>
		
	</c:forEach>
	<%
		} else {
	%>
	<p style="margin-left: 170px;">未查询到数据</p3>
	<%
		}
	}
	%>
<script type="text/javascript">
	function changeSecondClass(id) {
		$.post("getProductSecondClassInManage.action", {
			"id" : id
		}, function(json) {
			$(".secondClass").html("");//清空下拉框  
			for (var i = 0; i < json.length; i++) {
				//添加一个secondClass  
				$(".secondClass").append(
						"<option value='"+json[i].secondClassId+"'>" + json[i].secondClassName
								+ "</option>");
			}
			changeProduct($(".secondClass").val());
		}, 'json');
	}
	
	function changeProduct(id) {
		$.post("getProductInfoInManageByTime.action", {
			"id" : id,
			"date":"${date}",
			"time":"${time}"
		}, function(json) {
			$(".product").html("");//清空下拉框  
			$(".product").append(
						"<option value=''></option>");
			for (var i = 0; i < json.length; i++) {
				//添加一个product  
				$(".product").append(
						"<option value='"+json[i].productId+"'>" + json[i].extremeName
								+ "</option>");
			}
		}, 'json');
	}
	
	$(function() {
		//初始化firstClass下拉框  
		$.post("getProductFirstClassInManage.action", null, function(json) {
			for (var i = 0; i < json.length; i++) {
				//添加一个教师  
				$(".firstClass").append(
						"<option value='"+json[i].firstClassId+"'>" +json[i].firstClassName+ "</option>");
			}
			changeSecondClass($(".firstClass").val());
		}, 'json');
		//注册firstClass下拉框事件   
		$(".firstClass").change(function() { 
			changeSecondClass($(this).val()); 
		}); 
		
		$(".secondClass").change(function() {
			changeProduct($(this).val()); 
		});
		
		<%
		if(request.getAttribute("alertMsg")!=null){
		%>
		alert("${alertMsg}");
		<%
		}
		%>
		
	});
	
	function changeProductInfo(value) {
		var id = value.options[value.selectedIndex].value;
		$.post("getProductInfoInManage.action", {
			"id":id
		}, function(json) {
			$("#pName").html(json.extremeName);//清空下拉框  
			$("#pUrl").html("<img src='../"+json.picUrl+"' />");
			$("#pPrice").html(json.productPrice);
			$("#pStock").html(json.stock);
			$("input[name='productId']").val(json.productId);
			$("input[name='spikeQuantity']").attr("max",json.stock);
			
			if(json.stock <= 0){
				alert("商品缺货");
				$("input[name='spikeButton']").removeAttr("onclick");
			}
			
		}, 'json');
	}
	
	function setProductStock() {
		
		$.ajax({
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "setProductStock.action" ,//url
                data: $('#stockForm').serialize(),
                success: function (result) {
                	var c = parseInt($("#pStock").html()) + parseInt($("input[name='stock']").val());
                	console.log(c);
                    if (result.stock == c) {
                        alert("添加成功");
                        $("#pStock").html(result.stock);
                    }else{
                    	alert("添加失败");
                    }
                },
                error : function() {
                    alert("添加失败");
                }
            });
	}
	
</script>

	<select class="firstClass"></select>  
	<select class="secondClass"></select>
	<select class="product" onclick="changeProductInfo(this)"></select>   
	<form action="addSpikeProduct.action" method="post">
		<p id="pName"></p>
		<p id="pPrice"></p>
		<p id="pUrl"></p>
		<p id="pStock"></p>
		<input name="productId"  style="display: none;" />
		<input  type="date" name="date" value="${date}" required="required"  style="display: none;"  >
		<input  name="time" value="${time}"  style="display: none;"  >
		<input name="spikePrice" type="number" min="1"   />
		<input name="spikeQuantity" type="number" min="1" max="100"   />
		<button type="submit">增加抢购商品</button>
	</form>
	
	<%
	}
	%>

</body>
</html>