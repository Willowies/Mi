<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台管理</title>
		<link rel="stylesheet" href="../css/bootstrap-self-use.css" />
		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/manageHome.css" type="text/css" rel="stylesheet" />
		<link href="../css/font-awesome.css" rel="stylesheet">
		<link href="../css/model.css" rel="stylesheet">
		<link href="../css/manageSelf.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript">
				function changeSecondClass(id) {
					$.post("getProductSecondClassInManage.action", {
						"id": id
					}, function(json) {
						$(".secondClass").html(""); //清空下拉框  
						for(var i = 0; i < json.length; i++) {
							//添加一个secondClass  
							$(".secondClass").append(
								"<option value='" + json[i].secondClassId + "'>" + json[i].secondClassName +
								"</option>");
						}
						changeProduct($(".secondClass").val());
					}, 'json');
				}

				function changeProduct(id) {
					$.post("getProductInfoInManageByTime.action", {
						"id": id,
						"date": "${date}",
						"time": "${time}"
					}, function(json) {
						$(".product").html(""); //清空下拉框  
						$(".product").append(
							"<option value=''></option>");
						for(var i = 0; i < json.length; i++) {
							//添加一个product  
							$(".product").append(
								"<option value='" + json[i].productId + "'>" + json[i].extremeName +
								"</option>");
						}
					}, 'json');
				}

				$(function() {
					//初始化firstClass下拉框  
					$.post("getProductFirstClassInManage.action", null, function(json) {
						for(var i = 0; i < json.length; i++) {
							//添加一个教师  
							$(".firstClass").append(
								"<option value='" + json[i].firstClassId + "'>" + json[i].firstClassName + "</option>");
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
						"id": id
					}, function(json) {
						$("#pAll").css("display","block");
						$("#pName").html("商品名称："+json.extremeName); //清空下拉框  
						$("#pUrl").attr("src",json.picUrl);
						$("#pPrice").html(json.productPrice);
						$("#pStock").html(json.stock);
						$("input[name='productId']").val(json.productId);
						$("input[name='spikeQuantity']").attr("max", json.stock);

						if(json.stock <= 0) {
							alert("商品缺货");
							$("input[name='spikeButton']").removeAttr("onclick");
						}

					}, 'json');
				}

				function setProductStock() {

					$.ajax({
						type: "POST", //方法类型
						dataType: "json", //预期服务器返回的数据类型
						url: "setProductStock.action", //url
						data: $('#stockForm').serialize(),
						success: function(result) {
							var c = parseInt($("#pStock").html()) + parseInt($("input[name='stock']").val());
							console.log(c);
							if(result.stock == c) {
								alert("添加成功");
								$("#pStock").html(result.stock);
							} else {
								alert("添加失败");
							}
						},
						error: function() {
							alert("添加失败");
						}
					});
				}
			</script>
	</head>

	<body>
		<div class="site-topbar">
			<div class="container">
				<div class="topbar-nav">

				</div>
				<div class="topbar-info">
					<a rel="nofollow" class="link">管理员</a>
					</span>
				</div>
			</div>
		</div>
		<div class="site-header">
			<div class="container">
				<div class="header-logo">
					<a href="manageHome.html"><img src="../images/logo-footer.png" alt="小米logo" /></a>
				</div>
				<div class="header-nav">
					<p style="margin: 30px 0 0 20%;width: 200px;font-size: 30px;">后台管理系统</p>
				</div>

			</div>
		</div>
		<div class="menu-bar">
			<div class="container ">
				<a href='manageHome.html'>首页</a><span class="sep">&gt;</span>
				<a>设置抢购商品</a>
			</div>
		</div>
		<div class="grey-back-div">
			<p class="online-head"> 设置抢购商品 </p>
			<div class="spikeproduct">
				<div class="choosetime">
					<form action="getSpikeProductByTime.action" method="post" class="row-form">

						<input style="width: 200px;" type="date" name="date" required="required" class="form-control">
						<select style="width: 200px;" name="time" class="form-control">
							<option value="10">十点场</option>
							<option value="12">十二点场</option>
							<option value="18">十八点场</option>
							<option value="20">二十点场</option>
							<option value="22">二十二点场</option>
						</select>
						<button class="btn btn-default" type="submit">搜索场次</button>
					</form>
				</div>
					<%
	if(request.getAttribute("state")!=null){
		
	if(request.getAttribute("productList")!=null){
		List l = (List) request.getAttribute("productList");
		if (!l.isEmpty()) {
	%>
				<c:forEach items="${productList}" var="product">
				<div class="productlist">
					<div class="productitem">
						<img src="../images/54e35fdd-bc68-4a89-bad7-c9c3bb2fc6fe.jpeg" height="150px" />
						<div class="productinfo">
							<p>商品名称：${product.productName}</p>
							<form action="modifySpikeProduct.action" method="post">
								<div>
									<span>商品数量:${product.spikeQuantity}</span>&nbsp;&nbsp;&nbsp;<input type="number" name="spikeQuantity" value="2" required="required" min="1" max="${product.stock}" />
								</div>
								<div>
									<span>商品价格:${product.spikePrice}</span>&nbsp;&nbsp;&nbsp;<input type="number" name="spikePrice" value="2099" required="required" min="1" />
								</div>
								<input name="spikeProductId" value="${product.spikeProductId}" style="display: none;" />
								<input type="date" name="date" value="${date}" required="required" style="display: none;">
								<input name="time" value="${time}" style="display: none;">
								<div class="productinfoform">
									<button class="btn btn-default" type="submit">修改</button>
									<button class="btn btn-default" type="button" onclick="window.location.href='deleteSpikeProduct.action?spikeProductId=0&productId=0'">删除</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				</c:forEach>
				<%
		} else {
	%>
		<p style="margin-left: 170px;">未查询到数据</p3>
			<%
		}
	}
	}
	%>
				<div class="choosetime">
					<select class="firstClass"></select>
					<select class="secondClass"></select>
					<select class="product" onclick="changeProductInfo(this)"></select>
				</div>
				<div class="productitem" id="pAll">
						<img id="pUrl" src="../images/54e35fdd-bc68-4a89-bad7-c9c3bb2fc6fe.jpeg" height="150px" />
						<div class="productinfo">
							<p id="pName">商品名称</p>
							<form action="addSpikeProduct.action" method="post">
								<div>
									<span>商品库存:</span>&nbsp;&nbsp;&nbsp;<p id="pStock">123</p>&nbsp;&nbsp;&nbsp;<input id="quantity"  placeholder="抢购量"  name="spikeQuantity" type="number" min="1" max="100" />
								</div>
								<div>
									<span>商品价格:</span>&nbsp;&nbsp;&nbsp;<p id="pPrice"></p>&nbsp;&nbsp;&nbsp;<input placeholder="抢购价格" name="spikePrice" type="number" min="1" />
								</div>
								<input name="productId" value="" style="display: none;" />
								<input type="date" name="date" value="${date}" required="required" style="display: none;">
								<input name="time" value="${time}" style="display: none;">
								<div class="productinfoform">
									<button class="btn btn-default"  type="submit">增加抢购商品</button>
								</div>
							</form>
						</div>
					</div>
			</div>
		</div>

		<div class="site-footer">
			<div class="container">
				<div class="footer-service">
					<ul class="list-service">
						<li style="border-left:0;">
							<div style="margin-right: auto;margin-left: auto;height: 25px;width: 126px;">
								<img src="../images/wrench.png" width="25px" height="25px" style="float:left">
								<a rel="nofollow" href="" target="_blank">预约维修服务</a>
							</div>
						</li>
						<li>
							<div style="margin-right: auto;margin-left: auto;height: 25px;width: 135px;">
								<img src="../images/seven.png" width="25px" height="25px" style="float:left">
								<a rel="nofollow" href="" target="_blank">7天无理由退货</a>
							</div>
						</li>
						<li>
							<div style="margin-right: auto;margin-left: auto;height: 25px;width: 127px;">
								<img src="../images/fifteen.png" width="25px" height="25px" style="float:left">
								<a rel="nofollow" href="" target="_blank">15天免费换货</a>
							</div>
						</li>
						<li>
							<div style="margin-right: auto;margin-left: auto;height: 25px;width: 121px;">
								<img src="../images/present.png" width="25px" height="25px" style="float:left">
								<a rel="nofollow" href="" target="_blank">满150元包邮</a>
							</div>
						</li>
						<li>
							<div style="margin-right: auto;margin-left: auto;height: 25px;width: 148px;">
								<img src="../images/location.png" width="25px" height="25px" style="float:left">
								<a rel="nofollow" href="" target="_blank">520余家售后网点</a>
							</div>
						</li>
					</ul>
				</div>
				<div class="footer-links">
					<div class="footer-links-item">
						<p style="margin:-1px 0 26px 0;font-size:14px;color:#000;height:17px;">帮助中心</p>
						<p>账户管理</p>
						<p>购物指南</p>
						<p>订单操作</p>
					</div>
					<div class="footer-links-item">
						<p style="margin:-1px 0 26px 0;font-size:14px;color:#000;height:17px;">服务支持</p>
						<p>售后政策</p>
						<p>自助服务</p>
						<p>相关下载</p>
					</div>
					<div class="footer-links-item">
						<p style="margin:-1px 0 26px 0;font-size:14px;color:#000;height:17px;">线下门店</p>
						<p>小米之家</p>
						<p>服务网点</p>
						<p>授权体验店</p>
					</div>
					<div class="footer-links-item">
						<p style="margin:-1px 0 26px 0;font-size:14px;color:#000;height:17px;">关于小米</p>
						<p>了解小米</p>
						<p>加入小米</p>
						<p>投资者关系</p>
					</div>
					<div class="footer-links-item">
						<p style="margin:-1px 0 26px 0;font-size:14px;color:#000;height:17px;">关注我们</p>
						<p>新浪微博</p>
						<p>官方微信</p>
						<p>联系我们</p>
					</div>
					<div class="footer-links-item">
						<p style="margin:-1px 0 26px 0;font-size:14px;color:#000;height:17px;">特色服务</p>
						<p>F码通道</p>
						<p>礼物码</p>
						<p>防伪查询</p>
					</div>
					<div class="footer-links-contact">
						<p style="margin: 0 0 5px;font-size: 22px;line-height: 1;color: #ff6700;">400-100-5678</p>
						<p>周一至周日 8:00-18:00<br>（仅收市话费）</p>
						<a href="" class="contactA">
							<i class="fa fa-commenting-o"></i> 联系客服
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="site-info">
			<div class="container">
				<div class="logo ir">小米官网</div>
				<div class="info-text">
					<p class="sites">
						<a>小米商城</a><span class="sep">|</span>
						<a>MIUI</a><span class="sep">|</span>
						<a>米家</a><span class="sep">|</span>
						<a>米聊</a><span class="sep">|</span>
						<a>多看</a><span class="sep">|</span>
						<a>游戏</a><span class="sep">|</span>
						<a>路由器</a><span class="sep">|</span>
						<a>米粉卡</a><span class="sep">|</span>
						<a>政企服务</a><span class="sep">|</span>
						<a>小米天猫店</a><span class="sep">|</span>
						<a>隐私政策</a><span class="sep">|</span>
						<a>问题反馈</a><span class="sep">|</span>
						<a>廉正举报</a><span class="sep">|</span>
						<a>Select Region</a>
					</p>
					<p>©
						<a href="" target="_blank" title="mi.com">mi.com</a> 京ICP证110507号
						<a href="" target="_blank" rel="nofollow">京ICP备10046444号</a>
						<a rel="nofollow" href="" target="_blank">京公网安备11010802020134号 </a>
						<a rel="nofollow" href="" target="_blank">京网文[2017]1530-131号</a>
						<br> 违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试
					</p>
				</div>
				<div class="info-links">
					<a rel="nofollow" href="" target="_blank"><img src="../images/truste.png" alt="TRUSTe Privacy Certification"></a>
					<a rel="nofollow" href="" target="_blank"><img src="../images/v-logo-2.png" alt="诚信网站"></a>
					<a rel="nofollow" href="" target="_blank"><img src="../images/v-logo-1.png" alt="可信网站"></a>
					<a rel="nofollow" href="" target="_blank"><img src="../images/v-logo-3.png" alt="网上交易保障中心"></a>
					<a rel="nofollow" href="" target="_blank"><img src="../images/ba10428a4f9495ac310fd0b5e0cf8370.png" alt="诚信经营 放心消费"></a>
				</div>
			</div>
			<div class="slogan ir">探索黑科技，小米为发烧而生</div>
		</div>
	</body>

</html>