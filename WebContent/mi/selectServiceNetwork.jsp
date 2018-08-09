<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet" />
		<link href="../css/font-awesome.css" rel="stylesheet">
		<link href="../css/selectServiceNetwork.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
		<script src="../js/selectServiceNetwork.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=kagUWSbQaKFfW9oxhDWXsEqEFNCgfb1y"></script>
		<script src="../js/selectReceivingPoint.js"></script>

		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<!-- <meta http-equiv="refresh" content="0;" url="selectSP.action"/>  -->
		<title>小米授权服务中心网点</title>
	</head>

	<body onload="init('${province}')">

		<div class="site-topbar">
			<div class="container">
				<div class="topbar-nav">
					<a rel="nofollow" href="../mi/homepage.jsp">小米商城</a>
					<span class="sep">|</span>
					<a rel="nofollow" href="https://www.miui.com/" target="_blank">MIUI</a>
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
					<a rel="nofollow" class="cart-mini" id="J_miniCartBtn" href="findCartItem.action">
						<i class="fa fa-shopping-cart"></i> 购物车
						<span class="cart-mini-num">（0）</span>
					</a>
					<div class="cart-menu" id="J_miniCartMenu">
					</div>
				</div>
				<div class="topbar-info">

				</div>
			</div>
		</div>
		<div class="site-header">
			<div class="container">
				<div class="header-logo">
					<a href="homepage.jsp"><img src="../images/logo-footer.png" alt="小米logo" /></a>
				</div>
				<div class="header-nav">
					<ul class="nav-list">

						<li id="navItem1" class="nav-item">小米手机
							<div id="J_navMenu" class="header-nav-menu" style="display:none;">
								<div class="container">
									<ul class="children-list clearfix"></ul>
								</div>
							</div>
						</li>
						<li id="navItem2" class="nav-item">红米
							<div id="J_navMenu" class="header-nav-menu" style="display:none;">
								<div class="container">
									<ul class="children-list clearfix"></ul>
								</div>
							</div>
						</li>
						<li id="navItem3" class="nav-item">电视
							<div id="J_navMenu" class="header-nav-menu" style="display:none;">
								<div class="container">
									<ul class="children-list clearfix"></ul>
								</div>
							</div>
						</li>
						<li id="navItem4" class="nav-item">笔记本
							<div id="J_navMenu" class="header-nav-menu" style="display:none;">
								<div class="container">
									<ul class="children-list clearfix"></ul>
								</div>
							</div>
						</li>
						<li id="navItem5" class="nav-item">盒子</li>
						<li id="navItem6" class="nav-item">新品</li>
						<li id="navItem7" class="nav-item">路由器</li>
						<li id="navItem8" class="nav-item">智能硬件</li>
						<li id="navItem9" class="nav-item-service">
							<a href="Service.jsp">服务</a>
						</li>
						<li id="navItem10" class="nav-item">社区</li>
					</ul>
				</div>
				<div class="header-search">
					<form id="J_searchForm" class="search-form" method="post" action="searchProduct.action">
						<input class="search-text" type="search" id="search" name="text">
						<input type="submit" class="search-btn" value="">
					</form>
				</div>
			</div>
		</div>

		<div class="ServiceNetwork">
			<div class="titlediv">
				<div class="image">
					<img src="../images/l-top1.png" alt="申请售后服务">
				</div>
				<div class="titleclass">
					<div class="titleclass-image">
						<img src="../images/pos.png" alt="申请售后服务">
						<span class="orange">${province},${city}</span> 附近共有<span class="orange">${ServiceNetworkcount}</span>个 服务网点
					</div>
					<div class="formclass">
						<form action="selectSN.action" method="post">
							<select class="selectbox" name="province" value="${province}" id="param_province" onchange="provincechange(this.selectedIndex)">
								<option>请选择省份</option>
							</select>
							<select class="selectbox" name="city" value="${city}" id="param_city">
								<option>请选择城市</option>
							</select>
							<button class="selectbutton" type="submit">查询受理网点</button>
						</form>

					</div>

				</div>
			</div>
				

			
			<div class="resultandmap">
				<div class="selectresult">
					<div class="resultandmap-select-title">
							<form action="selectSP.action" id="spId" method="post">

								<input name="province" value "${province}" style="display:none">
								<input name="city" value "${city}" style="display:none">
								<select name="spId" class="productselectbox">
									<option value="">全部产品</option>
									<c:forEach items="${sps}" var="sp">
										<option value="${sp.spId}">${sp.spName}</option>
									</c:forEach>

								</select>
								<button type="submit" class="selectbutton1">查询</button>

							</form>

					</div>
					<div class="resultandmap-select-result">
					<%if(request.getAttribute("sns")!=null){
			             List sns=(List) request.getAttribute("sns");
			             if(!sns.isEmpty()){%> 
				    <ul>
							<c:forEach items="${sns}" var="sn">					
							<li >
								<div class="libox">
								<h3 title="${sn.snName}">${sn.snName}</h3>
							    <p title="${sn.snAddress}">${sn.snAddress}</p>
							    <p title="${sn.snTelephone}">联系电话：${sn.snTelephone}</p>
							   </div>
							</li>		
							</c:forEach>
		
				</ul>	
							<%}else{		%>
							<p>未查询到数据</p>							
							<%			}		}		%>
				</div>
					
				</div>
				<div id="allmap" class="mapstyle">
					
				</div>
				
				
			</div>

			<!--
				onclick="changecenter(${sn.snCoordx},${sn.Coordy})"
				
				<div class="resultandmap">

				
					<div class="resultandmap-select-result">
							<%
		if(request.getAttribute("sns")!=null){
			List sns=(List) request.getAttribute("sns");
			if(!sns.isEmpty()){ 
			        
		%> 
		
		        <ul>
							<c:forEach items="${sns}" var="sn">
						
							<li >
								<h3 title="${sn.snName}">${sn.snName}</h3>
							    <p title="${sn.snAddress}">${sn.snAddress}</p>
							    <p>id:${sn.snId}</p>
								<p>${sn.snCity} ${rp.rpCountry}</p>
								<p>${sn.snName}</p>
								<p>地址：${sn.snAddress}</p>
								<p>联系电话：${sn.snTelephone}</p>
								<p>营业时间：${sn.snWorkTime}</p>
								<p>产品类型</p>
								<c:forEach items="${sn.serviceProducts}" var="sp">
									<span>${sp.spName}</span>
								</c:forEach>
								<p>服务类型</p>
								<c:forEach items="${sn.serviceTypes}" var="st">
									<span>${st.stName}</span>
								</c:forEach>
							</li>		
							</c:forEach>
		
				</ul>	
							<%
			}else{
		%>
							<p>未查询到数据</p>
							<%
			}
		}
		%>
				

			</div>-->

		</div>

<script type="text/javascript">
	//下拉列表功能

	
	var map = new BMap.Map("allmap"); // 创建Map实例
	$(".servicenetworks").text();

	map.centerAndZoom("沈阳市", 15);
	//添加地图类型控件
	map.addControl(new BMap.MapTypeControl({
		mapTypes: [
			BMAP_NORMAL_MAP,
			BMAP_HYBRID_MAP
		]
	}));
	map.enableScrollWheelZoom(true); //开启鼠标滚轮缩放
	var top_left_control = new BMap.ScaleControl({
		anchor: BMAP_ANCHOR_TOP_LEFT
	}); // 左上角，添加比例尺
	var top_left_navigation = new BMap.NavigationControl(); //左上角，添加默认缩放平移控件
	map.addControl(top_left_control);
	map.addControl(top_left_navigation);

	/*var points = [{
			"lng": 112.58,
			"lat": 26.89,
			"url": "http://www.baidu.com",
			"id": 1,
			"name": "p1"
		},
		{
			"lng": 112.59,
			"lat": 26.90,
			"url": "http://www.mi.com",
			"id": 2,
			"name": "p2"
		},
		{
			"lng": 112.57,
			"lat": 26.88,
			"url": "http://www.csdn.com",
			"id": 3,
			"name": "p3"
		}
	];

	function addMarker(points) {
		//循环建立标注点
		for(var i = 0, pointsLen = points.length; i < pointsLen; i++) {
			var point = new BMap.Point(points[i].lng, points[i].lat); //将标注点转化成地图上的点
			var marker = new BMap.Marker(point); //将点转化成标注点
			map.addOverlay(marker); //将标注点添加到地图上
			//添加监听事件
			(function() {
				var thePoint = points[i];
				marker.addEventListener("click",
					//显示信息的方法
					function() {
						showInfo(this, thePoint);
					});
			})();
		}

	}*/
	/*fuction changecenter(x,y){
		map.centerAndZoom(x,y, 15);
		
	}
	 $(function () {
            $(".changepoint").click(function () {
                debugger;
                var css = $(".changepoint").attr("style");
                if (css.indexOf("border: 1px solid #757575")>=0)
                    $(this).css("border", "1px solid #FF6700");
                else
                    $(this).css("border", "1px solid #757575");
            });
        })*/
			
			

			
		</script>

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