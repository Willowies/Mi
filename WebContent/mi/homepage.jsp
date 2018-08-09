<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet"/>
		<link href="../css/indexSpike.css" rel='stylesheet' type='text/css' />
		<link href="../css/font-awesome.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
		<script type="text/javascript" src="../js/indexSpike.js"></script>
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
				<a rel="nofollow" class="cart-mini" id="J_miniCartBtn" href="javascript:void(0)">
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
	<div class="carousel">
		<div class="carouselBody">
			<div class="carouselImg" style="width: 100%; overflow: hidden; position: relative; height: 460px;">
				<div class="carouselimgItem" style="z-index: 50; display: block;">
					<a href="javascript:void(0)"><img src="../images/xmad_15329163042455_sNOki.jpg" width="1226px" height="460px"/></a>
				</div>
				<div class="carouselimgItem" style="z-index: 0; display: none;">
					<a href="javascript:void(0)"><img src="../images/xmad_15330559831596_SsvKz.jpg" width="1226px" height="460px"/></a>
				</div>
				<div class="carouselimgItem" style="z-index: 0; display: none;">
					<a href="javascript:void(0)"><img src="../images/xmad_15336320121108_TDvwz.jpg" width="1226px" height="460px"/></a>
				</div>
				<div class="carouselimgItem" style="z-index: 0; display: none;">
					<a href="javascript:void(0)"><img src="../images/xmad_15151497671427_UPjdu.jpg" width="1226px" height="460px"/></a>
				</div>
				<div class="carouselimgItem" style="z-index: 0; display: none;">
					<a href="javascript:void(0)"><img src="../images/xmad_15293778771651_yYPSw.jpg" width="1226px" height="460px"/></a>
				</div>
			</div>
			<div class="carouselBtn">
				<div class="carouselPN">
					<a class="left"><i class="fa fa-chevron-left"></i></a>
					<a class="right"><i class="fa fa-chevron-right"></i></a>
				</div>
				<div  class="carouselCircle">
					<div class="carouselImgSwitch">
						<a class="imgSwitch active">1</a>
						<a class="imgSwitch">2</a>
						<a class="imgSwitch">3</a>
						<a class="imgSwitch">4</a>
						<a class="imgSwitch">5</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--开始闪购-->
		<div class="home-container container">
			<div class="flashPurchase carousel-container">
			    <div class="plain-box">
				    <div class="box-hd">
					    <h2 class="title">小米闪购</h2>
					    <div class="more">
						    <div class="controls controls-line-small">
							    <span class="control control-prev control-disabled">&laquo;</span>
							    <span class="control control-next ">&raquo;</span>
						    </div>
					    </div>
				    </div>
				    <div class="box-bd">
				    	<div class="flash-loading" id="flashLoading" style="display: none;">
				    		<div class="loader"></div>
				    	</div>
				    	<div class="carousel-list goods-list rainbow-list clearfix">
				    		<ul class="flashPurchase-countdown">
				    			<li class="rainbow-item-4">
				    				<div class="time-title">18:00  场</div>
				    				<img src="../images/flashpurchase.png"/>
				    				<div class="sub"></div>
				    				<div class="countdown clearfix">
				    					<div class="box">00</div>
				    					<div class="dosh">:</div>
				    					<div class="box">00</div>
				    					<div class="dosh">:</div>
				    					<div class="box">00</div>
				    				</div>
				    			</li>
				    		</ul>
				    		<div class="carousel-wrapper" style="height: 340px; overflow: hidden;">
				    			<ul class="flashPurchase-list carousel-col-5-list" style="width: 2480px; margin-left: 0px; transition: margin-left 0.5s ease;">
				    				
				    			</ul>
				    		</div>
				    	</div>
				    </div>
			    </div>
		    </div>
		    <!--结束闪购-->
		</div>
	<div class="xm-groupPurchase">
		<div class="titleG">
			<h3 style="display:inline-block; margin:15px 0; float:left; font-size:22px; font-weight:200;">小米团购</h3>
			<div class="more">
				<a class="morePre"><i class="fa fa-chevron-left"></i></a>
				<a class="moreNext"><i class="fa fa-chevron-right"></i></a>
			</div>
		</div>
		<div class="content">
			<div class="goods-list">
				<div id="addGoodItem" class="all-goods-list" style="width: 2480px;height:340px;margin-left: 0px;transition: margin-left 0.5s ease;">
					<div class="goods-item"><a href="" target="_blank"></a><div class="inner"><div class="inner-img"><a href="groupPurchase.jsp" style="height:160px; display:block;"><img src="../images/c9e0a117fd138828b13bc5ae493e90ae_pms_1527735137.81615202!560x560.jpg" width="160px" height="160px"></a></div><h3 class="title"><a href="groupPurchase.jsp">小米8 6GB 64GB 全网通 黑色</a></h3><p class="desc">全球首款双频GPS / 骁龙845处理器 / 红外人脸解锁 / AI变焦双摄 / 三星 AMOLED 屏</p><p class="price"><span>2599</span>&nbsp;<span>元&nbsp;</span><del style="color:#b0b0b0;">2699元</del></p></div></div>					
					<div class="goods-item"><a href="" target="_blank"></a><div class="inner"><div class="inner-img"><a href="groupPurchase.jsp" style="height:160px; display:block;"><img src="../images/c9e0a117fd138828b13bc5ae493e90ae_pms_1527735137.81615202!560x560.jpg" width="160px" height="160px"></a></div><h3 class="title"><a href="groupPurchase.jsp">小米8 6GB 64GB 全网通 黑色</a></h3><p class="desc">全球首款双频GPS / 骁龙845处理器 / 红外人脸解锁 / AI变焦双摄 / 三星 AMOLED 屏</p><p class="price"><span>2599</span>&nbsp;<span>元&nbsp;</span><del style="color:#b0b0b0;">2699元</del></p></div></div>
					<div class="goods-item"><a href="" target="_blank"></a><div class="inner"><div class="inner-img"><a href="groupPurchase.jsp" style="height:160px; display:block;"><img src="../images/c9e0a117fd138828b13bc5ae493e90ae_pms_1527735137.81615202!560x560.jpg" width="160px" height="160px"></a></div><h3 class="title"><a href="groupPurchase.jsp">小米8 6GB 64GB 全网通 黑色</a></h3><p class="desc">全球首款双频GPS / 骁龙845处理器 / 红外人脸解锁 / AI变焦双摄 / 三星 AMOLED 屏</p><p class="price"><span>2599</span>&nbsp;<span>元&nbsp;</span><del style="color:#b0b0b0;">2699元</del></p></div></div>
					<div class="goods-item"><a href="" target="_blank"></a><div class="inner"><div class="inner-img"><a href="groupPurchase.jsp" style="height:160px; display:block;"><img src="../images/c9e0a117fd138828b13bc5ae493e90ae_pms_1527735137.81615202!560x560.jpg" width="160px" height="160px"></a></div><h3 class="title"><a href="groupPurchase.jsp">小米8 6GB 64GB 全网通 黑色</a></h3><p class="desc">全球首款双频GPS / 骁龙845处理器 / 红外人脸解锁 / AI变焦双摄 / 三星 AMOLED 屏</p><p class="price"><span>2599</span>&nbsp;<span>元&nbsp;</span><del style="color:#b0b0b0;">2699元</del></p></div></div>
					<div class="goods-item"><a href="" target="_blank"></a><div class="inner"><div class="inner-img"><a href="groupPurchase.jsp" style="height:160px; display:block;"><img src="../images/c9e0a117fd138828b13bc5ae493e90ae_pms_1527735137.81615202!560x560.jpg" width="160px" height="160px"></a></div><h3 class="title"><a href="groupPurchase.jsp">小米8 6GB 64GB 全网通 黑色</a></h3><p class="desc">全球首款双频GPS / 骁龙845处理器 / 红外人脸解锁 / AI变焦双摄 / 三星 AMOLED 屏</p><p class="price"><span>2599</span>&nbsp;<span>元&nbsp;</span><del style="color:#b0b0b0;">2699元</del></p></div></div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="page-main home-main">
		<div class="container">
			<div class="phoneInfomation">
				<div id="phone"  class="page-main-block" >
					<h3 style="display:inline-block; margin:15px 0; float:left;font-size:22px; font-weight:200;">手机</h3>
					<div class="moreInfo">
						<a href="selectClassfiedProduct.action?secondClassId=1" class="watchMore">查看全部&nbsp;<i class="fa fa-chevron-circle-right"></i></a>
					</div>
				</div>
				<div class="page-main-content">
					<div class="phoneAdv">
						<div class="phoneInfo-itemImg" style="margin-left:0;">
							<a href="javascript:void(0)"><img src="../images/xmad_15323220713837_GLBVX.jpg" width="234px" height="614px"/></a>
						</div>
					</div>
					<div class="phoneInfo">
					
					</div>
				</div>
			</div>
			<div class="elecInfomation">
				<div id="homeelec"  class="page-main-block">
					<h3 style="display:inline-block; margin:15px 0; float:left;font-size:22px; font-weight:200;">家电</h3>
					<div class="switchmore">
						<ul style="list-style-type:none; font-size:16px; margin:0; padding:0;">
							<li class="tab-active">热门</li>
							<li>电视</li>
							<li>电脑</li>
							<li>家居</li>
						</ul>
					</div>
				</div>
				<div class="page-main-content">
					<div class="elecAdv">
						<div class="phoneInfo-itemImg" style="margin-left:0;">
							<a href="javascript:void(0)"><img src="../images/xmad_15232550390498_qwxEC.jpg" width="234px" height="300px"/></a>
						</div>
						<div class="phoneInfo-itemImg"  style="margin-left:0;">
							<a href="javascript:void(0)"><img src="../images/xmad_15123939053142_dFlAw.jpg" width="234px" height="300px"/></a>
						</div>
					</div>
					<div class="elecInfo">
						<div class="elecInfoEle" style="display:flex;"><div class="phoneInfo-item"><a href="" target="_blank"></a><div class="inner"><div class="inner-img"><img src="../images/xmad_14972549116226_tZpod.png" width="150px" height="150px"></div><h3 class="titleP"><a>米家空气净化器Pro 第一代</a></h3><p class="desc">OLED 显示屏幕 / 激光颗粒物传感器 / 500m³/h颗粒物 CADR / 60㎡适用面积</p><p class="price"><span>1499元</span>
						</p><div class="review"><a href=""><span class="comment">开始开始开始了算了老鼠老鼠老鼠老鼠老鼠老鼠</span><span class="author">来自于 xxx的评价</span></a></div></div></div></div>
						<div class="elecInfoEle" style="display:none;"></div>
						<div class="elecInfoEle" style="display:none;"></div>
						<div class="elecInfoEle" style="display:none;"></div>
					</div>
				</div>
				
			</div>
			<div class="accessoryInfomation">
				<div id="accessory"  class="page-main-block">
					<h3 style="display:inline-block; margin:15px 0; float:left;font-size:22px; font-weight:200;">手机配件</h3>
					<div class="switchmoreA">
						<ul style="list-style-type:none; font-size:16px; margin:0; padding:0;">
							<li class="tab-active">热门</li>
							<li style="width:49px;">保护套</li>
							<li>贴膜</li>
							<li  style="width:64px;">其他配件</li>
						</ul>
					</div>
				</div>
				<div class="page-main-content">
					<div class="accessoryAdv">
						<div class="phoneInfo-itemImg" style="margin-left:0;">
							<a href="javascript:void(0)"><img src="../images/xmad_15222058002076_sWEmR.jpg" width="234px" height="300px"/></a>
						</div>
						<div class="phoneInfo-itemImg"  style="margin-left:0;">
							<a href="javascript:void(0)"><img src="../images/xmad_15290668700648_LpwQf.jpg" width="234px" height="300px"/></a>
						</div>
					</div>
					<div class="accessoryInfo">
						<div class="elecInfoEle" style="display:flex;"><div class="phoneInfo-item"><a href="" target="_blank"></a><div class="inner"><div class="inner-img"><img src="../images/pms_1524466977.94886383!200x200.jpg" width="150px" height="150px"></div><h3 class="titleP"><a>小米6X 极简保护壳 红色 6X</a></h3><p class="price"><span>29元</span></p><p class="rank"></p>
						<div class="review"><a href=""><span class="comment">开始开始开始了算了老鼠老鼠老鼠老鼠老鼠老鼠</span><span class="author">来自于 xxx的评价</span></a></div></div></div></div>
						<div class="elecInfoEle" style="display:none;"></div>
						<div class="elecInfoEle" style="display:none;"></div>
						<div class="elecInfoEle" style="display:none;"></div>
					</div>
				</div>
			</div>
			<div class="recommend">
				<div class="titleB">
					<h3 style="display:inline-block; margin:15px 0; float:left;font-size:22px; font-weight:200;">为你推荐</h3>
					<div class="moreSecond">
						<a class="morePreSecond"><i class="fa fa-chevron-left"></i></a>
						<a class="moreNextSecond"><i class="fa fa-chevron-right"></i></a>
					</div>
				</div>
				<div class="content">
					<div class="goods-list">
						<div id="addGoodItemSecond" class="all-goods-list" style="width: 2480px;height:320px;margin-left: 0px;transition: margin-left 0.5s ease;">
							
						</div>
					</div>
				</div>
			</div>
			
			<div class=comment>
				<div class="titleC">
					<h2 style="font-size:22px; font-weight:200;">热评产品</h2>
				</div>
				<div class="content">
					<div class="contentin">
						<div class="contentItem">
							<div class="picItem">
								<img src="../images/54e35fdd-bc68-4a89-bad7-c9c3bb2fc6fe.jpeg" width="296" height="220" alt="米家压力IH电饭煲">
							</div>
							<p class="reviewHot">包装很让人感动，式样也很可爱，做出的饭全家人都爱吃，超爱五星！手机控制还是不太熟练，最主要是没有连接...</p>
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
	
	<div class="fixService">
		<a href="onlineService.html"><i class="fa fa-user-o"></i></a>
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