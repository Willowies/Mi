<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>晒单评价</title>

		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet" />
		<link href="../css/font-awesome.css" rel="stylesheet">
		<link href="../css/model.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
	</head>

	<body>
		<div class="site-topbar">
			<div class="container">
				<div class="topbar-nav">
					<a rel="nofollow" href="../mi/homepage.jsp">小米商城</a>
					<span class="sep">|</span>
					<a rel="nofollow" href="" target="_blank">MIUI</a>
					<span class="sep">|</span>
					<a rel="nofollow" href="">IoT</a>
					<span class="sep">|</span>
					<a rel="nofollow" href="" target="_blank">云服务</a>
					<span class="sep">|</span>
					<a rel="nofollow" href="" target="_blank">金融</a>
					<span class="sep">|</span>
					<a rel="nofollow" href="" target="_blank">有品</a>
					<span class="sep">|</span>
					<a rel="nofollow" href="" target="_blank">小爱开放平台</a>
					<span class="sep">|</span>
					<a rel="nofollow" href="" target="_blank">政企服务</a>
					<span class="sep">|</span>
					<a rel="nofollow" href="" data-toggle="modal">Select Region</a>
				</div>
				<div class="topbar-cart" id="J_miniCartTrigger">
					<a rel="nofollow" class="cart-mini" id="J_miniCartBtn" href="">
						<i class="fa fa-shopping-cart"></i> 购物车
						<span class="cart-mini-num">（0）</span>
					</a>
					<div class="cart-menu" id="J_miniCartMenu">

					</div>
				</div>
				<div class="topbar-info">
					<a rel="nofollow" class="link" href="">登录</a>
					<span class="sep">|</span>
					<a rel="nofollow" class="link" href="">注册</a>
					<span class="sep">|</span>
					<span class="message">
					<a rel="nofollow" href="">消息通知</a>
				</span>
				</div>
			</div>
		</div>
		<div class="site-header">
			<div class="container">
				<div class="header-logo">
					<a href="../mi/homepage.jsp"><img src="../images/logo-footer.png" alt="小米logo" /></a>
				</div>
				<div class="header-nav">
					<ul class="nav-list">
						<li id="J_navCategory" class="nav-category">
							<a class="link-category">
								<span class="text">全部商品分类</span>
							</a>
						</li>
						<li id="navItem1" class="nav-item">小米手机
							<div id="J_navMenu" class="header-nav-menu" style="display:none;">
								<div class="container">
									<ul class="children-list clearfix">
										<li class="first">
											<div class="figure figure-thumb">
												<a href="https://www.mi.com/mi8/">
													<img src="../images/pc-320-220-mi8.png" alt="小米8" width="160" height="110">
												</a>
											</div>
											<div class="title">
												<a href="">小米8</a>
											</div>
											<p class="price">2699元起</p>
										</li>
										<li>
											<i class="line"></i>
											<div class="figure figure-thumb">
												<a href="https://www.mi.com/mi8/">
													<img src="../images/pc-320-220-mi8se.png" alt="小米8" width="160" height="110">
												</a>
											</div>
											<div class="title">
												<a href="">小米8 SE</a>
											</div>
											<p class="price">2699元起</p>
										</li>
										<li>
											<i class="line"></i>
											<div class="figure figure-thumb">
												<a href="https://www.mi.com/mi8/">
													<img src="../images/pc-320-220-mi8.png" alt="小米8" width="160" height="110">
												</a>
											</div>
											<div class="title">
												<a href="">小米8</a>
											</div>
											<p class="price">2699元起</p>
										</li>
										<li>
											<i class="line"></i>
											<div class="figure figure-thumb">
												<a href="https://www.mi.com/mi8/">
													<img src="../images/pc-320-220-mi8.png" alt="小米8" width="160" height="110">
												</a>
											</div>
											<div class="title">
												<a href="">小米8</a>
											</div>
											<p class="price">2699元起</p>
										</li>
										<li>
											<i class="line"></i>
											<div class="figure figure-thumb">
												<a href="https://www.mi.com/mi8/">
													<img src="../images/pc-320-220-mi8.png" alt="小米8" width="160" height="110">
												</a>
											</div>
											<div class="title">
												<a href="">小米8</a>
											</div>
											<p class="price">2699元起</p>
										</li>
										<li>
											<i class="line"></i>
											<div class="figure figure-thumb">
												<a href="https://www.mi.com/mi8/">
													<img src="../images/pc-320-220-mi8.png" alt="小米8" width="160" height="110">
												</a>
											</div>
											<div class="title">
												<a href="">小米8</a>
											</div>
											<p class="price">2699元起</p>
										</li>
									</ul>
								</div>
							</div>
						</li>
						<li id="navItem2" class="nav-item">红米</li>
						<li id="navItem3" class="nav-item">电视</li>
						<li id="navItem4" class="nav-item">笔记本</li>
						<li id="navItem5" class="nav-item">盒子</li>
						<li id="navItem6" class="nav-item">新品</li>
						<li id="navItem7" class="nav-item">路由器</li>
						<li id="navItem8" class="nav-item">智能硬件</li>
						<li id="navItem9" class="nav-item">服务</li>
						<li id="navItem10" class="nav-item">社区</li>
					</ul>
				</div>
				<div class="header-search">
					<form id="J_searchForm" class="search-form">
						<input class="search-text" type="search" id="search" name="keyword">
						<input type="submit" class="search-btn" value="">
					</form>
				</div>
			</div>
		</div>
		<div class="menu-bar">
			<div class="container ">
				<a href='../mi/homepage.jsp'>首页</a><span class="sep">&gt;</span>
				<a>个人中心</a>
			</div>
		</div>
		<div class="grey-back-div">
			<div class="middle-content">
				<div class="left-bar">
					<div class="function-box">
						<div class="box-head">
							<h3 class="title">订单中心</h3>
						</div>
						<div class="box-body">
							<ul class="list">
								<li>
									<a href="../mi/getAllOrder.action">我的订单</a>
								</li>
								<li>
									<a href="../mi/getAllGroupOrder.action">团购订单</a>
								</li>
								<li class="active">
									<a href="../mi/getWaitCommentProduct.action">评价晒单</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="function-box">
						<div class="box-head">
							<h3 class="title">个人中心</h3>
						</div>
						<div class="box-body">
							<ul class="list">
								<li>
									<a href="../mi/myPersonalCenter.jsp">我的个人中心</a>
								</li>
								<li>
									<a href="../mi/messageNotice.jsp">消息通知</a>
								</li>
								<li>
									<a href="../mi/likeProduct.jsp">喜欢的商品</a>
								</li>
								<li>
									<a href="../mi/myCoupon.jsp">优惠券</a>
								</li>
								<li>
									<a href="../mi/receiverAddress.jsp">收货地址</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="function-box">
						<div class="box-head">
							<h3 class="title">售后服务</h3>
						</div>
						<div class="box-body">
							<ul class="list">
								<li>
									<a href="../mi/asSelectTables.action">服务记录</a>
								</li>
								<li>
									<a href="../mi/asApplyWay.html">申请服务</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="function-box">
						<div class="box-head">
							<h3 class="title">账户管理</h3>
						</div>
						<div class="box-body">
							<ul class="list">
								<li>
									<a href="../mi/selectUser.jsp">个人信息</a>
								</li>
								<li>
									<a href="../mi/updatePassword.jsp">修改密码</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="right-content">
					<div class="content-head">
						<h1 class="title">商品评价</h1>
						<div class="head-details">
							<ul class="head-list">
								<li class="first">
									<a href="getWaitCommentProduct.action">待评价商品</a>
								</li>
								<li>
									<a href="getCommentedProduct.action">已评价商品</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="content-body">
						<hr style="width: 100%;margin-top: 10px;" />
						<div class="content-body-div">
							<div class="xm-goods-list-wrap">
								<ul class="xm-goods-list clearfix">
									<%
	if(request.getAttribute("productList")!=null){
		List l = (List) request.getAttribute("productList");
		if (!l.isEmpty()) {
	%>
									<c:forEach items="${productList}" var="product">
										<li class="xm-goods-item">
											<div class="figure figure-img">
												<a href=""><img src="../${product.picUrl}" /></a>
											</div>
											<h3 class="title"><a href="" >${product.productName}</a></h3>
											<p class="price">${product.productPrice}元</p>
											<p class="rank">${product.productCommentNum}人评价</p>
											<div class="actions">
												<form action="userToCommentProduct.action" method="post">
													<input type="text" name="productId" value="${product.productId}" style="display: none;" />
													<input type="text" name="productName" value="${product.productName} ${product.version} ${product.color}" style="display: none;" />
													<input type="text" name="productCommentNum" value="${product.productCommentNum}" style="display: none;" />
													<input type="text" name="productPrice" value="${product.productPrice}" style="display: none;" />
													<input type="text" name="picUrl" value="${product.picUrl}" style="display: none;" />
													<button class="btn btn-primary btn-small J_btnComment" style="background:#fff">去评价</a>
												</form>
												
										</div>
									</li>
									</c:forEach>
	<%
		} else {
	%>
	<p style="margin: 50px 350px;">未查询到数据</p3>
	<%
		}
	}
	%>
								</ul>
							</div>
						</div>
						
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