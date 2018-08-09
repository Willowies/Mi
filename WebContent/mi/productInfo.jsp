<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"   %>
<!DOCTYPE html>
<html>
	<head>
	    <link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet"/>
		<link href="../css/productInfo.css" rel='stylesheet' type='text/css' />
		<link href="../css/font-awesome.css" rel='stylesheet' type='text/css' />
		<link rel="stylesheet" href="../css/bootstrap.min.css">		
		<script type="text/javascript" src="../js/jquery-3.2.0.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
		<script type="text/javascript" src="../js/productInfo.js"></script>
		
		<meta charset="UTF-8">
		<title>商品详情</title>
	</head>
	<body>
	<!-- 顶栏 -->
		<div class="site-topbar">
		<div class="container">
			<div class="topbar-nav">
				<a rel="nofollow" href="../mi/homepage.jsp" style="color: #b0b0b0 !important;">小米商城</a>
				<span class="sep">|</span>
				<a rel="nofollow" href="https://www.miui.com/" target="_blank"  style="color: #b0b0b0 !important;">MIUI</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" style="color: #b0b0b0 !important;">IoT</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank" style="color: #b0b0b0 !important;">云服务</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank" style="color: #b0b0b0 !important;">金融</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank" style="color: #b0b0b0 !important;">有品</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank" style="color: #b0b0b0 !important;">小爱开放平台</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" target="_blank" style="color: #b0b0b0 !important;">政企服务</a>
			  	<span class="sep">|</span>
			  	<a rel="nofollow" href="" data-toggle="modal" style="color: #b0b0b0 !important;">Select Region</a>
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
	    <!-- 导航栏 -->
		<div class="site-header">
		<div class="container">
			<div class="header-logo">
				<a href="homepage.jsp"><img src="../images/logo-footer.png"  alt="小米logo" /></a>
			</div>
			<div class="header-nav">
				<ul class="nav-list">
					<li id="J_navCategory" class="nav-category">
						<a href="" class="link-category" style="visibility: visible;">
							<span class="text">全部商品分类</span>
						</a>
						<div class="site-category" style="display:none;">
							<ul id="J_categoryList" class="site-category-list">
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=1" class="title" style="color:#fff !important;">手机<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=2" class="title" style="color:#fff !important;">平板<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=3" class="title" style="color:#fff !important;">电视机<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=4" class="title" style="color:#fff !important;">笔记本<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=5" class="title" style="color:#fff !important;">空气净化器<i class="fa fa-chevron-right"></i></a>
									<div class="children"></div>
								</li>
								<li class="category-item">
									<a href="selectClassfiedProduct.action?secondClassId=6" class="title" style="color:#fff !important;">插线板<i class="fa fa-chevron-right"></i></a>
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
		
		<div class="product-head-info">
			<div class="product-head-box">
				<div class="product-name">${productName}</div>
				<div class="con">
					<a href="displayProductSummary.action?productName=${productName}">概述</a>&nbsp; |&nbsp;
					<a href="displayProductParameter.action?productName=${productName}">参数</a>&nbsp; |&nbsp;
					<a href="getCommentPage.action?productName=${productName}">用户评价</a>&nbsp;					
				</div>
			</div>
		</div>
		<div class="buyBox" id="buyBox">
			<div class="box clearfix">
				<div class="login-notic">
					<!--未登录提示-->
					<div class="page-container">						
                                                                                 为方便您购买，请提前登录 
                        <a href="login.jsp" class="proLogin" onclick="" style="color: #ff6700 !important;text-decoration: none;margin-left:25px">立即登录</a> 
                        <span class="proLoginClose fa fa-close" style="color: #b5b5b5;" onclick=""></span>
					</div>
				</div>
				<div class="pro-choose-main page-container clearfix">
					<div class="pro-view span10">
						<!--左侧轮播图-->
						<div class="imgload hide"></div>
						<div id="img" class="img-con" style="margin-top: 0px;">
							<div id="myCarousel" class="ui-wrapper carousel slide" data-ride="carousel" style="max-width: 100%;">
							    <!-- 轮播指标 -->
							    <ol class="carousel-indicators">
		                           		                            
	                            </ol>
							    <!-- 轮播项目 -->
								<div class="ui-viewport carousel-inner" style="width: 100%; overflow: hidden; position: relative; height: 560px;">
									<div id="sliderView" class="sliderWrap item active" style="width: auto; position: relative;">
									    <img class="slider done" src=""/>
									</div>
								</div>
								<!-- 轮播导航 -->
								<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		                            <span class="sr-only">Previous</span>
	                            </a>
								<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		                            <span class="sr-only">Next</span>
	                            </a>
							</div>
						</div>
					</div>
					<div class="pro-info span10">
						<h1 id="pro-title" class="pro-title">${productName}</h1>
						<!--提示-->
						<p class="sale-desc" id="desc"></p>
						<!--选择第一级别-->
						<span class="pro-price"></span>
						<div class="loading hide">
							<div class="loader"></div>
						</div>
						<c:if test="${couponList.size() != 0}">
						    <div class="saleWrap">
						    <c:forEach items="${couponList}" var="c">
						      <form action="receiveCoupon.action?couponId=${c.couponId}" method="post">
                                <div class="coupon-wrap">
								    <span class="coupon-tag">优惠券</span>
								    <span class="couponName">${c.couponName}</span>
								    <span class="couponId" style="display:none;">${c.couponId}</span>
								    <span class="couponDiscount" style="display:none;">${c.discountAmount}</span>
								    <span class="startDate" style="display:none;">${c.startDate}</span>
								    <span class="endDate" style="display:none;">${c.endDate}</span>
								    <a class="getCoupon" style="color: #ff6700 !important; cursor: pointer; display: inline-block; text-decoration: none;" 
									    data-toggle="modal">立即领取</a>
							    </div>
							  </form>
                            </c:forEach>
                            </div>
						</c:if>
			
						<!--商品信息主体-->
						<div class="pro-main">
							<!--当前仓库-->
							<div class="address-wrap">
								<div class="user-default-address" id="userDefaultAddress">
									<i class="fa fa-location-arrow"></i>
									<div>
										<div class="address-info">
											<span class="item">${receiverAddress.receiverProvince}</span>
											<span class="item">${receiverAddress.receiverCity}</span>
											<span class="item">${receiverAddress.receiverDistrict}</span>
											<!-- span class="item">${receiverAddress.address}</span> -->
										</div>
									</div>
									<div class="product-status active" id="productStatus">
										<span class="sale">有现货</span>										
										<span class="over">暂时缺货</span>
									</div>
								</div>
							</div>
							<!-- 产品版本 -->
							<div class="list-wrap" id="versionList">
								<!-- 选择版本 -->
								<div class="pro-choose pro-choose-col" data-index="0">
									<div class="step-title version" data-name="选择版本">选择版本</div>
									<ul id="selectVersion" class="step-list step-one clearfix">
									  <c:forEach items="${productList}" var="p">
										  <li class="but but-biglarge">
											  <a class="pro-para">
												  <span class="name">${p.version}</span>
												  <span class="productPrice" style="display:none;">${p.productPrice}</span>
												  <span class="price" ></span>
											  </a>
										  </li>
									  </c:forEach>	
									</ul>
								</div>
								<!--选择颜色-->
								<div id="selectColor" class="pro-choose pro-choose-col" data-index="1">
									<div class="step-title" data-name="选择颜色"> 选择颜色  </div>
									<ul class="step-list clearfix">										
										
									</ul>
								</div>
								<!--已选择的产品-->
								<div class="pro-list" id="proList">
									<ul>
										<li id="totalName">
										    
											
										</li>
										<li class="totalPrice"></li>
									</ul>
								</div>
								<!--购买按钮-->
								<ul class="btn-wrap clearfix" id="buyBtnBox">
									<li>
										<a id="buyOrNotice" class="but but-primary but-biglarge proBuyBtn" data-type="common" data-toggle="modal"></a>
									</li>
								</ul>
								<div class="pro-policy" id="policy">
									<a>
										<span class="support">
											<i class="fa fa-info"></i>
											<em>7天无理由退货</em>
										</span>
										<span class="support">
											<i class="fa fa-info"></i>
											<em>15天换货</em>
										</span>
										<span class="support">
											<i class="fa fa-info"></i>
											<em>365天保修</em>
										</span>
									</a>								
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--特别说明-->
				<div class="infor-con">
					<div class="section is-visible preload">
						<div class="page-container">
							<h3>特别说明</h3>
							<div class="con">
								<img src="../images/dbcd8c4fa60093939c2dfffe62428535_aaee9db8790426631abc3b76fa3da617.jpg"/>
							</div>
						</div>
					</div>
					<div class="section is-visible preload">
						<div class="page-container">
							<h3>官方微信  </h3>
							<div class="con">
								<img src="../images/d1ba7e773402c9b145587ccca967f7fa_1a84b2b629512205bf528aae91361efb.jpg"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--领取优惠券-->
		<div class="modal fade modal-coupon modal-hide in" id="couponModal" style="display: none;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
			</button>
			<div class="modal-body">
				<div class="list">
					<h3 style="margin: 0; padding: 0; text-align: center; font-size: 30px; color:#424242">领取优惠券</h3>
					<p class="tips" style="line-height: 20px;"></p>
					<div class="con">
						<ul>
							<li>
								<div class="coupon-price">
									
									
								</div>
								<div class="coupon-con">
									<p class="coupon-txt" style="line-height: 20px; margin: 0;">
										使用范围：
										<span></span>
									</p>
									<p class="coupon-time">有效时间：</p>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--到货通知提醒设置-->
		<div class="modal fade modal-hide modal-setRemind in" id="modalNoticeArrival" style="display: none;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
			</button>
			<div class="modal-body" style="max-height: 400px; padding: 40px 60px;">
				<h4 id="#isSetted" class="isSetted" style="margin: 10px 0 20px; font-size: 30px; font-weight: normal; color: #ff6700;text-align: center;"></h4>
				<p style="margin: 1em 0;"></p>
				<div>
					<a class="but btn-primary known" data-dismiss="modal" style="color:#fff !important; width: 158px; height: 38px; background: #ff6700; border-color: #ff6700; font-size: 14px; line-height: 38px; margin-left: 61px;">我知道了</a>
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
