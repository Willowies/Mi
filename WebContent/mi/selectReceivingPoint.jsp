<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<script src="../js/selectReceivingPoint.js"></script>
		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet"/>
		<link href="../css/font-awesome.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>小米县级受理点查询</title>
		
		<style type="text/css">
			body {
				background: #f5f5f5;
				width: 1226px;
				margin-left: auto;
				margin-right: auto;
				font: 14px/1.5 "Helvetica Neue", Helvetica, Arial, "Microsoft Yahei", "Hiragino Sans GB", "Heiti SC", "WenQuanYi Micro Hei", sans-serif;
			}
			
			.normal_question {
				width: 100%;
			}
			
			.holddiv {
				border: 1px solid #e0e0e0;
				padding-bottom: 40px;
				background-color: #fff;
				margin-top: 20px;
				color: #424242;
				float: left;
				width: 100%;
			}
			
			.hd {
				height: 58px;
				line-height: 58px;
				border-bottom: 1px solid #e0e0e0;
				background-color: #fafafa;
				text-indent: 40px;
			}
			
			.bd {
				padding: 25px 25px 25px 40px;
				text-overflow: ellipsis
			}
			
			.bd dl {
				
				margin: 40px 0 0;
				text-indent: 40px;
				white-space: nowrap;
			}
			
			.bd dt {
				margin-bottom: 5px;
				color: #ff6700;
				white-space: nowrap;
				text-overflow: ellipsis;
				overflow: hidden;
			}
			
			.bd dd {
				margin: 0;
				text-indent: 40px;
				line-height: 2;
				font-size: 12px;
				white-space: nowrap;
				text-overflow: ellipsis;
				overflow: hidden;
			}
			.qd {
				padding: 25px 25px 25px 40px;
				text-overflow: ellipsis
			}
			
			.qd dl {
				margin: 40px 0 0;
				text-indent: 40px;
				white-space: nowrap;
			}
			
			.qd dt {
				margin-bottom: 5px;
				white-space: nowrap;
				text-overflow: ellipsis;
				overflow: hidden;
			}
			
			.qd dd {
				margin: 0;
				text-indent: 40px;
				line-height: 2;
				font-size: 12px;
				white-space: nowrap;
				text-overflow: ellipsis;
				overflow: hidden;
			}
			.resultdiv{
			float:left;
			width: 25%;
			
			}
			.selectresult {
				height: auto;
				overflow:hidden;
				width: 100%;
				border: 1px solid #e0e0e0;
				padding-bottom: 40px;
				background-color: #FFFFFF;
				color: #424242;
				float: left;
			}
			
			.selectform {
				text-align: center;
			}
			
			.selectbox {
				loat: left;
				_display: inline;
				width: 138px;
				height: 38px;
				margin: 0 5px;
				border: 1px solid #e0e0e0;
				background-color: #fff;
				overflow: hidden;
				_zoom: 1;
				position: relative;
			}
			
			.selectbutton {
				background: #ff6700;
				border-color: #ff6700;
				width: 138px;
				height: 40px;
				line-height: 40px;
				display: inline-block;
				background-color: #ff6700;
				color: #fff;
				border-radius: 0;
				text-transform: none;
				vertical-align: baseline;
				padding: 0;
				margin: 0;
				border: 1px solid #b0b0b0;
			}
			
			.desc {
				margin: 0 0 35px;
				font-size: 20px;
			}
		</style>
	</head>

	<body onload="init()">
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
		<!--内容块-->

		<div class="selectresult">
			<div class="hd">
				<span></span>附近的受理网点
			</div>
			<div class="selectform">
				<h1>小米售后 县区受理网点查询</h1>
				<p class="desc">
					<span class="user-city" id="J_userCity">辽宁 沈阳市</span> 附近的受理网点
				</p>

				<form action="selectRP.action">
					<select class="selectbox" name="province" id="param_province" onchange="provincechange(this.selectedIndex)">
						<option>请选择省份</option>
					</select>
					<select class="selectbox" name="city" id="param_city">
						<option>请选择城市</option>
					</select>
					<button class="selectbutton" type="submit">查询受理网点</button>
				</form>
			</div>
			<div class="bd">
				<!-- <dl>
					<dt>德宏傣族景颇族自治州 瑞丽市</dt>
					<dd title="瑞丽姐告湘杨电脑材料经营部">瑞丽姐告湘杨电脑材料经营部</dd>
					<dd title="云南省瑞丽市姐告国门大道211号湘杨电脑">云南省瑞丽市姐告国门大道211号湘杨电脑</dd>
					<dd>0692-4666398</dd>
				</dl> -->

				<dl>
		     <%
		    if(request.getAttribute("rps")!=null){
			List rps=(List) request.getAttribute("rps");
			if(!rps.isEmpty()){ 
		      %>
					<c:forEach items="${rps}" var="rp">
					    <div class="resultdiv">
					    <dt>${rp.rpCity}   ${rp.rpCountry}</dt>
						<dd title="${rp.rpName}">${rp.rpName}</dd>
						<dd title="${rp.rpAddress}">地址：${rp.rpAddress}</dd>
						<dd>联系电话：${rp.rpTelephone}</dd>
					    
					    </div>
						
					</c:forEach>

					<%
			}else{
		%>
					<p>未查询到数据</p>
					<%
			}
		}
		%>

				</dl>

			</div>
		</div>

		<div class="normal_question">

			<div class="holddiv">
				<div class="hd">常见问题</div>
				<div class="qd">
					<dl>
						<dt>Q： 受理点是什么？</dt>
						<dd>受理点是小米公司在县区授权的售后服务接机点，负责接收有售后服务需求的小米手机并免费邮寄至上级小米授权服务中心进行售后服务</dd>
					</dl>
					<dl>
						<dt>Q： 受理点与小米授权服务中心有什么区别？</dt>
						<dd>受理点只接收用户手机并替用户邮寄给上级小米授权服务中心，不具备维修功能</dd>
					</dl>
					<dl>
						<dt>Q： 送修的机器到受理点后多长时间可以修好？</dt>
						<dd>受理点接收用户产品后，5个工作日内处理完毕，用户可以去受理点取机。</dd>
					</dl>
					<dl>
						<dt>Q： 保修期外的机器受理点可以受理吗？</dt>
						<dd>可以受理，保修期外的机器将按全国统一报价，由维修点联系客户进行报价</dd>
					</dl>
					<dl>
						<dt>Q： 受理点可以接小米电视机吗？</dt>
						<dd>目前受理点只开放了小米手机、小米平板、小米盒子、小米路由器产品。</dd>
					</dl>
					<dl>
						<dt>Q： 对受理点不满意，怎么办？</dt>
						<dd>如您对小米授权受理点的服务不满意，可随时拨打小米服务热线进行反馈，小米服务热线工作时间：周一至周日 8:00-18:00 （仅收市话费）4001005678</dd>
					</dl>
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
	    
		
	     


