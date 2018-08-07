<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet"/>
		<link href="../css/font-awesome.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
		<style type="text/css">
			body {
				font: 14px/1.5 "Helvetica Neue",Helvetica,Arial,"Microsoft Yahei","Hiragino Sans GB","Heiti SC","WenQuanYi Micro Hei",sans-serif;
    color: #333;
				text-align: center;
				background-color: #F5F5F5;
			}
			.selfservice{
				height:20px;
				width:1024px;
			}
			
			.row ul {
				list-style-type: none;
				height: 330px;
				width: 1024px;
			}
			
			.row li {
				float: left;
				height: 161px;
				width: 23%;
				border-style: solid;
				border-width: 1px;
				border-color: #F5F5F5;
				background-color: #FFFFFF;
				text-align: center;
				height: 160px;
				position: relative;
			}
			
			.row img {
				border: 0;
				vertical-align: middle;
			}
			
			
			
			.row a {
				color: #757575;
				text-decoration: none;
			}
			.row a:hover{
				color:#FF6700;
			}
			.row ul a {
				display: block;
			}
		</style>
		<title>JSP Page</title>
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
	

		<div>
			<div class="selfservice">
				<h2>自助服务</h2>
			</div>
			

			<div class="row">
				<ul>
					<li>
						<br/>
						<a href="https://service.order.mi.com/apply/front" target="_blank" data-stat-id="2facb281b3a68d7a" onclick="_msq.push(['trackEvent', 'dbc112ecb8bd96ad-2facb281b3a68d7a', 'https://service.order.mi.com/apply/front', 'pcpid', '']);">
							<img src="../images/service-icon-shouhoufuwu.png" alt="申请售后服务">
							<br/>
							<span>申请售后服务</span>
						</a>
					</li>
					<li>
						<br/>
						<a href="//static.mi.com/order/" target="_blank" data-stat-id="fbf0552b37fced29" onclick="_msq.push(['trackEvent', 'dbc112ecb8bd96ad-fbf0552b37fced29', '//static.mi.com/order/', 'pcpid', '']);">
							<img src="../images/service-icon-dingdan.png" alt="订单查询">
							<br/>
							<span>订单查询</span>
						</a>
					</li>
					<li>
						<br/>
						<a href="https://account.xiaomi.com/pass/auth/security/home" target="_blank" data-stat-id="d6a8f72255a82f08" onclick="_msq.push(['trackEvent', 'dbc112ecb8bd96ad-d6a8f72255a82f08', 'https://account.xiaomi.com/pass/auth/security/home', 'pcpid', '']);">
							<img src="../images/service-icon-xmaccount.png" alt="小米账户">
							<br/>
							<span>小米账户</span>
						</a>
					</li>
					<li>
						<br/>
						<a href="https://www.mi.com/static/acceptance/" target="_blank" data-stat-id="e9621ccfd395dd92" onclick="_msq.push(['trackEvent', 'dbc112ecb8bd96ad-e9621ccfd395dd92', 'https://www.mi.com/static/acceptance/', 'pcpid', '']);">
							<img src="../images/service-icon-shoulidian.png" alt="售后县级受理点">
							<br/>
							<span>售后县级受理点</span>
						</a>
					</li>
					<li>
						<br/>
						<a href="//www.mi.com/static/maintainlocation/" target="_blank" data-stat-id="513ddbca53bc911c" onclick="_msq.push(['trackEvent', 'dbc112ecb8bd96ad-513ddbca53bc911c', '//www.mi.com/static/maintainlocation/', 'pcpid', '']);">
							<img src="../images/service-icon-wangdian.png" alt="授权服务网点">
							<br/>
							<span>授权服务网点</span>
						</a>
					</li>
					<li>
						<br/>
						<a href="//list.mi.com/accessories/tag?id=tv_service" target="_blank" data-stat-id="bbea1f24b4487b0b" onclick="_msq.push(['trackEvent', 'dbc112ecb8bd96ad-bbea1f24b4487b0b', '//list.mi.com/accessories/tagid=tv_service', 'pcpid', '']);">
							<img src="../images/service-icon-anzhuang.png" alt="付费服务">
							<br/>
							<span>付费服务</span>
						</a>
					</li>
					<li>
						<br/>
						<a href="//www.mi.com/service/exchange/#phone" target="_blank" data-stat-id="ef46ddec2589a6fa" onclick="_msq.push(['trackEvent', 'dbc112ecb8bd96ad-ef46ddec2589a6fa', '//www.mi.com/service/exchange/#phone', 'pcpid', '']);">
							<img src="../images/service-icon-shouhouzc.png" alt="售后政策">
							<br/>
							<span>售后政策</span>
						</a>
					</li>
					<li>
						<br/>
						<a href="http://chaxun.mi.com" target="_blank" data-stat-id="0fb2d2b5f7fc15f7" onclick="_msq.push(['trackEvent', 'dbc112ecb8bd96ad-0fb2d2b5f7fc15f7', 'http://chaxun.mi.com', 'pcpid', '']);">
							<img src="../images/service-icon-chaxun.png" alt="查询真伪">
							<br/>
							<span>查询真伪</span>
						</a>
					</li>
				</ul>
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