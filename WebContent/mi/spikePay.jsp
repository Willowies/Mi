<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/head.css" type="text/css"/>
<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
<link href="../css/homepage.css" type="text/css" rel="stylesheet"/>
<link href="../css/font-awesome.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/homepage.js"></script>
<link href="../css/pay.css" rel="stylesheet" type="text/css" /> 
<link href="../css/basic.css" rel="stylesheet" type="text/css"/>
<link href="../css/font-awesome.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="../js/pay.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择在线支付方式</title>
</head>
<body>
	<div id="mask"></div>

<div class="site-topbar">
		<div class="container">
			<div class="topbar-nav">
				<a rel="nofollow" href="../mi/homepage.jsp" >小米商城</a>
				<span class="sep">|</span>
				<a rel="nofollow" href="https://www.miui.com/" target="_blank">MIUI</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="">IoT</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank">云服务</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank">金融</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank" >有品</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank" >小爱开放平台</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank">政企服务</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" data-toggle="modal">Select Region</a>
			</div>
			<div class="topbar-cart" id="J_miniCartTrigger">
				<a rel="nofollow" class="cart-mini" id="J_miniCartBtn" href="findCartItem.action">
					<i class="fa fa-shopping-cart"></i>
					购物车
					<span class="cart-mini-num">（0）</span>
				</a>
				<div class="cart-menu" id="J_miniCartMenu" >
				</div>
			</div>
			<div class="topbar-info">
				
			</div>
		</div>
</div>

<div class="head">
		<div class="head-container">
			<div class="head-logo">
				<div class="logo">
					<img src="../images/head-logo.png" style="width: 48px;height: 48px;"/>
				</div>
			</div>
			<div class="head-title">
					<h2 class="head-content">
						支付订单
					</h2>
			</div>
		</div>
	</div>


		<div class="page-main">
			<div class="container">
				<div class="section section-order">
					<div class="order-info clearfix">
						<div class="fl">
							<h2 class="title">订单提交成功！去付款咯 ~</h2>
							<p class="order-time">
								请在
								<span class="pay-time-tip">48小时0分</span>
								内完成支付，超时后将取消订单
							</p>
							<p class="post-info">
								收货信息：${orderResult.receiverName } ${orderResult.receiverPhone } ${orderResult.receiverAddress }
							</p>
						</div>
						<div class="fr">
							<p class="total">
								应付金额：
								<span class="money">
									<em>${orderResult.actualTotal }</em>
									元
								</span>
							</p>
							<a id="showDetail">订单详情</a>
						</div>
					</div>
					<i class="iconfont">√</i>
					<div class="order-detail" style="display: none;">
						<ul>
							<li class="clearfix">
								<div class="label">订单号：</div>
								<div class="content">
									<span class="order-num">
										 ${orderResult.orderId }
									</span>
								</div>
							</li>
							<li class="clearfix">
								<div class="label">收货信息：</div>
								<div class="content"> 
									${orderResult.receiverName } ${orderResult.receiverPhone } ${orderResult.receiverAddress }
								</div>
							</li>
							<li class="clearfix">
								<div class="label">商品名称：</div>
								<div class="content">
									 <c:forEach items="${orderResult.products}" var="oProduct">
										${oProduct.product.extremeName }<br>
									</c:forEach>
								</div>
							</li>
							<li class="clearfix">
								<div class="label">配送时间：</div>
								<div class="content">
									<c:if test="${orderResult.sendPeroid==1}">不限送货时间</c:if>
									<c:if test="${orderResult.sendPeroid==2}">工作日送货</c:if>
									<c:if test="${orderResult.sendPeroid==3}">双休日假日送货</c:if>
								</div>
							</li>
							<li class="clearfix">
								<div class="label">发票信息：</div>
								<div class="content"> 
									<c:if test="${orderResult.invoice.invoiceType==1}">电子发票</c:if>
									<c:if test="${orderResult.invoice.invoiceType==2}">纸质发票</c:if>
									<c:if test="${orderResult.invoice.receiverType==1}">个人</c:if>
									<c:if test="${orderResult.invoice.receiverType==2}">单位</c:if>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="section section-payment">
					<div class="cash-title">
						选择以下支付方式付款
					</div>
					<div class="payment-box">
						<div class="payment-header clearfix">
							<h3 class="title">支付平台</h3>
						</div>
						<div class="payment-body">
							<ul class="clearfix payment-list">
								<li class="weixin">
									<img src="../images/weixin.png" style="margin-left: 0;"/>
								</li>
								<li class="zfb">
									<img src="../images/zfb.png" style="margin-left: 0;"/>
								</li>
								<li class="yinlian">
									<img src="../images/yinlian.png" style="margin-left: 0;"/>
								</li>
								<li class="xiaomi">
									<img src="../images/xiaomi.jpg" style="margin-left: 0;"/>
								</li>
							</ul>
						</div>
					</div>
				</div>	
			</div>
		</div>
		<div class="weixin-pay" style="display: none;">
			<div class="pay-head">
				<span class="title">扫码支付</span>
				<a class="close"><i class="fa fa-close"></i></a>
			</div>
			<div class="show-pay">
				<div class="pay-pic">
					<img src="../images/weixin-pay.png" />
				</div>
				<div class="msg">
						请扫一扫二维码
						<br />
						<form action="paySpikeOrder.action">
							<input type="text" name="orderId" value="${orderResult.orderId }" style="display:none">
							<a style="color: #ff6700; cursor: point;" id="submitButton">支付成功</a>
						</form>
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
						<i class="fa fa-commenting-o"></i>
						联系客服
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
					<a href="" target="_blank" title="mi.com" >mi.com</a> 京ICP证110507号 
					<a href="" target="_blank" rel="nofollow" >京ICP备10046444号</a> 
					<a rel="nofollow" href="" target="_blank" >京公网安备11010802020134号 </a>
					<a rel="nofollow" href="" target="_blank">京网文[2017]1530-131号</a>
					<br> 违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试
				</p>
			</div>
			<div class="info-links">
                   <a rel="nofollow" href="" target="_blank"><img src="../images/truste.png" alt="TRUSTe Privacy Certification"></a>
                   <a rel="nofollow" href="" target="_blank" ><img src="../images/v-logo-2.png" alt="诚信网站"></a>
                   <a rel="nofollow" href="" target="_blank" ><img src="../images/v-logo-1.png" alt="可信网站"></a>
                   <a rel="nofollow" href="" target="_blank" ><img src="../images/v-logo-3.png" alt="网上交易保障中心"></a>
                   <a rel="nofollow" href="" target="_blank" ><img src="../images/ba10428a4f9495ac310fd0b5e0cf8370.png" alt="诚信经营 放心消费"></a>
			</div>
		</div>
		<div class="slogan ir">探索黑科技，小米为发烧而生</div>
	</div>



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