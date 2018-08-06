<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet"/>
		<link href="../css/font-awesome.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
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
	<div class="site-header">
		<div class="container">
			<div class="header-logo">
				<a href="homepage.jsp"><img src="../images/logo-footer.png"  alt="小米logo" /></a>
			</div>
			<div class="header-nav">
				<ul class="nav-list">
					<li id="J_navCategory" class="nav-category">
						<a class="link-category">
							<span class="text">全部商品分类</span>
						</a>
						<div class="site-category" style="display:block;">
							<ul id="J_categoryList" class="site-category-list">
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=1" class="title">手机<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=2" class="title">平板<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=3" class="title">电视机<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=4" class="title">笔记本<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=5" class="title">空气净化器<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=6" class="title">插线板<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
							</ul>
						</div>
					</li>
					<li id="navItem1" class="nav-item">小米手机<div id="J_navMenu" class="header-nav-menu"  style="display:none;"><div class="container"><ul class="children-list clearfix"></ul></div></div></li>
					<li id="navItem2" class="nav-item">红米<div id="J_navMenu" class="header-nav-menu"  style="display:none;"><div class="container"><ul class="children-list clearfix"></ul></div></div></li>
					<li id="navItem3" class="nav-item">电视<div id="J_navMenu" class="header-nav-menu"  style="display:none;"><div class="container"><ul class="children-list clearfix"></ul></div></div></li>
					<li id="navItem4" class="nav-item">笔记本<div id="J_navMenu" class="header-nav-menu"  style="display:none;"><div class="container"><ul class="children-list clearfix"></ul></div></div></li>
					<li id="navItem5" class="nav-item">盒子</li>
					<li id="navItem6" class="nav-item">新品</li>
					<li id="navItem7" class="nav-item">路由器</li>
					<li id="navItem8" class="nav-item">智能硬件</li>
					<li id="navItem9" class="nav-item-service"><a href="Service.jsp">服务</a></li>
					<li id="navItem10" class="nav-item">社区</li>
				</ul>
			</div>
			<div class="header-search">
				<form id="J_searchForm" class="search-form" method="post" action="searchProduct.action">
					<input class="search-text" type="search" id="search" name="text" >
					<input type="submit" class="search-btn" value="">
				</form>
			</div>
		</div>
	</div>
	<div style="height:500px; width:100%;"></div>
	
	<div class="xm-groupPurchase">
		<div class="titleG" style="background:#c16666;">
			<h3>小米团购</h3>
		</div>
		<div class="content" style="background:#b68df9;">
			<div class="goods-list">
				<div id="addGoodItem" class="all-goods-list" style="width: 2480px;height:340px;margin-left: 0px;transition: margin-left 0.5s ease;">
					
					
				</div>
			</div>
		</div>
	</div>
	
	<div class="page-main home-main">
		<div class="container">
			<div class="phoneInfomation">
				<div id="phone"  class="page-main-block" style="background:#c16666;">
					<h3>手机</h3>
				</div>
				<div class="page-main-content" style="background:#b68df9;">
					<div class="phoneAdv" style="background:#af77ad;">
						
					</div>
					<div class="phoneInfo" style="background:#f5f7a4;">
					
					</div>
				</div>
			</div>
			<div class="elecInfomation">
				<div id="homeelec"  class="page-main-block" style="background:#c16666;">
					<h3>家电</h3>
				</div>
				<div class="page-main-content" style="background:#b68df9;">
					<div class="elecAdv" style="background:#af77ad;">
						<div class="phoneInfo-item" style="margin-left:0;">
							<a href="" target="_blank"></a>
							<div class="inner">
								<div class="inner-img">
									<img src="../images/pms_1524883847.49276938!220x220.jpg" width="150px" height="150px">
								</div>
								<h3 class="title"><a>小米电视4A 43英寸青春版</a></h3>
								<p class="desc">全高清屏 / 人工智能语音</p>
								<p class="price">
									<span>599元</span>
								</p>
							</div>
						</div>
						<div class="phoneInfo-item" style="margin-left:0;">
							<a href="" target="_blank"></a>
							<div class="inner">
								<div class="inner-img">
									<img src="../images/pms_1524883847.49276938!220x220.jpg" width="150px" height="150px">
								</div>
								<h3 class="title"><a>小米电视4A 43英寸青春版</a></h3>
								<p class="desc">全高清屏 / 人工智能语音</p>
								<p class="price">
									<span>599元</span>
								</p>
							</div>
						</div>
					</div>
					<div class="elecInfo" style="background:#f5f7a4;">
						
					</div>
				</div>
				
			</div>
			<div class="accessoryInfomation">
				<div id="accessory"  class="page-main-block" style="background:#c16666;">
					<h3>手机配件</h3>
				</div>
				<div class="page-main-content" style="background:#b68df9;">
					<div class="accessoryAdv" style="background:#af77ad;">
						<div class="phoneInfo-item" style="margin-left:0;">
							<a href="" target="_blank"></a>
							<div class="inner">
								<div class="inner-img">
									<img src="../images/pms_1524883847.49276938!220x220.jpg" width="150px" height="150px">
								</div>
								<h3 class="titleP"><a>小米电视4A 43英寸青春版</a></h3>
								<p class="price">
									<span>1499元</span>
								</p>
								<p class="rank">1053人评价</p>
								<div class="review-wrapper"></div>
							</div>
						</div>
						<div class="phoneInfo-item"  style="margin-left:0;">
							<a href="" target="_blank"></a>
							<div class="inner">
								<div class="inner-img">
									<img src="../images/pms_1527840795.6763911.jpg" width="150px" height="150px">
								</div>
								<h3 class="titleP"><a>小米8 硅胶保护套</a></h3>
								<p class="price">
									<span>49</span>&nbsp;<span>元</span>
								</p>
								<p class="rank">1053人评价</p>
								<div class="review-wrapper"></div>
							</div>
						</div>
					</div>
					<div class="accessoryInfo" style="background:#f5f7a4;">
						
					</div>
				</div>
			</div>
			<div class="recommend">
				<div class="titleB" style="background:#c16666;">
					<h3>为你推荐</h3>
				</div>
				<div class="content" style="background:#b68df9;">
					<div class="goods-list">
						<div id="addGoodItemSecond" class="all-goods-list" style="width: 2480px;height:320px;margin-left: 0px;transition: margin-left 0.5s ease;">
							<div class="goods-item">
								<a href="" target="_blank"></a>
								<div class="inner">
									<div class="inner-img">
										<img src="../images/pms_1528718738.78643039!280x280.jpg" width="140px" height="140px">
									</div>
									<h3 class="titleP"><a> 红米6 全网通版 3GB内存 32GB </a></h3>
									<p class="price">
										<span>769</span>&nbsp;<span>元</span>
									</p>
									<p class="rank">1643人好评</p>
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
			
			<div class=comment>
				<div class="titleC" style="background:#c16666;">
					<h2 style="font-size:22px;">热评产品</h2>
				</div>
				<div class="content" style="background:#b68df9;">
					<div class="contentin">
						<div class="contentItem">
							<div class="picItem">
								<img src="../images/54e35fdd-bc68-4a89-bad7-c9c3bb2fc6fe.jpeg" width="296" height="220" alt="米家压力IH电饭煲">
							</div>
							<p class="review">包装很让人感动，式样也很可爱，做出的饭全家人都爱吃，超爱五星！手机控制还是不太熟练，最主要是没有连接...</p>
							<p class="author"> 来自于 HZG 的评价 </p>
							<div class="info">
								<h3 class="title">
									<a href="" >米家压力IH电饭煲</a>
								</h3>
								<span class="sep">|</span>
								<p class="price">
									<span class="num">999</span>元
								</p>
							</div>
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
</body>
</html>