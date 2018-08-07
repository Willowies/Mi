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
<link href="../css/pay-success.css" rel="stylesheet" type="text/css" /> 
<link href="../css/basic.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="../js/pay-success.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付成功</title>
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
						<a href="" class="link-category" style="visibility: visible;">
							<span class="text">全部商品分类</span>
						</a>
						<div class="site-category" style="display:none;">
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



	<div class="page-main">
			<div class="container pay-success-box clearfix">
				<div class="succ">
					<h2 class="title">支付成功</h2>
					<p class="price">
						<em>${orderResult.actualTotal}</em>
						元
					</p>
					<a class="btn" href="getOrderDetailsById.action?orderId=${orderResult.orderId}">查看订单详情</a>
					<p class="state">
						小米公司不会以任何理由要求您提供银行卡信息或支付额外费用
						<br />
						请谨防钓鱼链接或诈骗电话。
					</p>
				</div>
				<div class="info">
					<ul>
						<li class="clearfix">
							<div class="label">订单编号：</div>
							<div class="content">${orderResult.orderId }</div>
						</li>
						<li class="clearfix">
							<div class="label">收货信息：<br></div>
							<div class="content">
								${orderResult.receiverName } ${orderResult.receiverPhone }
								<br />
								${orderResult.receiverAddress }
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
			<div class="container pay-success-recommend">
				<h2 class="recommond-title">
					<span>为你推荐</span>
				</h2>
				<div class="recommond">
					<div class="carousel-wrapper" style="height: 320px;overflow: hidden;">
						<ul class="carousel-list clearfix" style="width: 2480px;margin-left: 0px;transition: margin-left 0.5s ease 0s;">
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/cartpic.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/cartpic.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/cartpic.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/cartpic.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/cartpic.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/example.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/example.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/example.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/example.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
							<li class="recommond-list">
								<dl>
									<dt><a><img src="../images/example.jpg"/></a></dt>
									<dd class="recommond-name">
										小米8 全网通版 6GB内存 256GB
									</dd>
									<dd class="recommond-price">3299元</dd>
									<dd class="recommond-tip">2741人好评</dd>
								</dl>
							</li>
						</ul>
					</div>
				</div>
				<div class="pages-wapper">
					<ul class="pagers">
						<li class="pager pager-active">
							<span class="dot">1</span>
						</li>
						<li class="pager">
							<span class="dot">2</span>
						</li>
					</ul>
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