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
<script type="text/javascript" src="../js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="../js/cart.js"></script>
<link href="../css/cart.css" rel="stylesheet" type="text/css" /> 
<link href="../css/basic.css" rel="stylesheet" type="text/css"/>
<link href="../css/font-awesome.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车-小米商城</title>
</head>
<body>

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
						我的购物车
					</h2>
			</div>
		</div>
	</div>
	
	
		<div class="page-main">
			<div class="container">
				<div class="cartBox">
				<form action="updateCalCartItems.action" method="post">
					<div class="cart-goods-list">
						<div class="list-head clearfix">
							<div class="col col-check">
								<input class="isSelect" type="checkbox" id="all">
								全选
							</div>
							
							<div class="col col-name">商品名称</div>
							<div class="col col-price">单价</div>
							<div class="col col-num">数量</div>
							<div class="col col-total">小计</div>
							<div class="col col-action">操作</div>
						</div>
						<div class="list-body">
							<c:forEach items="${resultList}" var="c">
								<div class="item-box">
									<div class="item-table">
										<div class="item-row clearfix">
											<div class="col col-check">
												<input class="isSelect" type="checkbox" name="cartItemIds" value="${c.cartItemId}">
											</div>
											<div class="col col-img">
												<a>
													<img src="../${c.product.picUrl}" width="80" height="80"/>
												</a>
											</div>
											<div class="col col-name">
												<h3 class="name">${c.product.extremeName}</h3>
											</div>
											<div class="col col-price">${c.product.productPrice}</div>
											<div class="col col-num">
												<div class="change-goods-num clearfix" >
													<a href="updateItemQuantity.action?num=-1&&cartItemId=${c.cartItemId}" ><i class="fa fa-minus" style="cursor:pointer; line-height: 38px;"></i></a>
														<i class="num">${c.quantity}</i>
													<a href="updateItemQuantity.action?num=1&&cartItemId=${c.cartItemId}"><i class="fa fa-plus" style="cursor:pointer; line-height: 38px;"></i></a>
												</div>
											</div>
											<div class="col col-total" id="amount">${c.amount}</div>
											<div class="col col-action">
												 <a class="del" href="deleteItem.action?cartItemId=${c.cartItemId}">
													<i class="fa fa-close"></i>
												</a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					</form>
					<div class="cart-bar clearfix">
						<div class="section-left">
							<a class="back-shopping" href="homepage.jsp">继续购物</a>
							<span class="cart-total">
								共
								<i id="totalNum"></i>
								件商品，已选择
								<i id="selectNum"></i>
								件
							</span>
						</div>
						<span class="total-price">
								合计：
								<em id="totalMoney"></em>
								元
							</span>
						<a class="btn btn-primary" id="calButton">去结算</a>
						<div class="no-select-tip">
							请勾选需要结算的商品 
							<i class="arrow arrow-a"></i>
							<i class="arrow arrow-b"></i>
						</div>
					</div>
				</div>
				<div class="cart-recommond container">
					<h2 class="recommond-title">
						<span>买购物车中商品的人还买了</span>
					</h2>
					<div class="recommond">
						<ul class="row clearfix">
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
							<li class="recommond-list span4">
								<dl>
									<dt>
										<a><img src="../images/recommend.png"/></a>
									</dt>
									<dd class="recommond-name">
										九号平衡车 Plus
									</dd>
									<dd class="recommond-price">3499元</dd>
									<dd class="recommond-tip">777人好评</dd>
								</dl>
							</li>
						</ul>
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