<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh-CN" xml:lang="zh-CN">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>申请售后服务</title>
		<link href="../css/as-base.min.css" rel="stylesheet" type=" text/css" />
        <link href="../css/as-main.min.css " rel="stylesheet" type="text/css" />
		<link href="../css/as-serviceMain.min.css" rel="stylesheet" type=" text/css" />
	   
	    <link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet"/>
		<link href="../css/font-awesome.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
		<script type="text/javascript" src="../js/aftersale-homePageTopBar.js"></script>
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
		
		<!-- .site-topbar END -->

		<!-- .site-header END -->

		<div class="breadcrumbs ">
			<div class="container ">
				<a href="//www.mi.com/index.html ">首页</a><span class="sep ">&gt;</span><span>申请售后服务</span>
			</div>
		</div>

		<div class="page-main user-main ">
			<div class="container ">
				<div class="row ">
					<div class="span4 ">
						<div class="uc-box uc-sub-box ">

							<div class="uc-nav-box ">
								<div class="box-hd ">
									<h3 class="title ">售后服务</h3>
								</div>
								<div class="box-bd ">
									<ul class="uc-nav-list ">
										<li>
											<a href="asSelectTables.action">服务记录</a>
										</li>
										<li>
											<a href="AasApplyWay.jsp">申请服务</a>
										</li>

									</ul>
								</div>
							</div>

						</div>
					</div>
					<script>
						var accountOperation = 1;
						var actionURL = '/apply/createExpressCompensateAccount/id/AS1807233403862';
					</script>
					<div class="span16 ">
						<div class="service-box service-main-box ">
							<div class="service-content-box order-view-box ">
								<div class="box-hd ">
									<h1 class="title ">服务单详情</h1>
									<div class="more clearfix ">
										<h2 class="subtitle ">服务单号：${asTable.asId}</h2>
										<div class="actions ">
                                             <c:choose>
                                                <c:when test="${asTable.asState == 7002 }">
                                                     <a class="btn btn-small btn-line-gray J_cancelOrder " href="asChangeTableState.action?asId=${asTable.asId}">取消订单</a>
                                                      </c:when>
                                                         <c:otherwise>
                                                             <p></p>
                                                         </c:otherwise>
                                              </c:choose>
										</div>
									</div>
								</div>
								<div class="box-bd ">
									<div class="uc-order-item uc-order-item-pay ">
										<div class="order-detail ">
											<div class="order-summary ">

												温馨提示：为了节省您的业务办理时间，请提前做好数据备份，关闭屏幕锁与查找手机功能。<br/><br/>

												<!--
													<div class="order-status order-detail-status ">

													<div class="delivery-submit ">
														<a class="btn btn-primary btn-small " href="/apply/createExpressCompensateAccount/id/AS1807233403862 ">
															申请运费报销</a>
													</div>

												</div> 
												-->

												<div class="order-progress ">
													<ol class='progress-list progress-list-col-3 clearfix'>
														<li class='step step-first  step-done step-active '>
															<div class='progress'><span class='text'>小米审核</span></div>
															<div class='info'>${asTable.asTime}</div>
														</li>
													</ol>
												</div>
											</div>
											<table class="order-items-table ">
												<tbody>
													<tr>
														<td class="col col-thumb ">
															<div class="figure figure-thumb ">
																<a target="_blank ">
																	<img src="//i1.mifile.cn/a1/pms_1524621222.66011593!80x80.jpg " width="80 " height="80 " alt=" ">
																</a>
															</div>
														</td>
														<td class="col col-name " colspan="2 ">
															<p class="name ">
																<a target="_blank ">${asTable.productName}&nbsp;&nbsp;&nbsp;${asTable.version}&nbsp;&nbsp;&nbsp;${asTable.color}</a>
															</p>
														</td>
														<td class="col col-actions ">
															<p class="name ">
																单品号：${asTable.asProId}<br/> SN号：${asTable.asSn} </p>
														</td>

													</tr>
												</tbody>
											</table>
										</div>

										<div class="order-detail-info ">
											<h3>本服务由 <span class="service-type ">客服中心</span> 为您提供</h3>
											<table class="info-table ">
												<tbody>

													<tr>
														<th>服务方式：</th>
														<td>${asTable.asBack}服务</td>
													</tr>
													<tr>
														<th>返回方式：</th>
														<td>${asTable.asBack}</td>
													</tr>
													<tr>
														<th>服务类型：</th>
														<td>${asTable.asWay}</</td>
													</tr>
													<tr>
														<th>问题描述：</th>
														<td>${asTable.asDescription}</td>
													</tr>
													<tr>
														<th>收货信息：</th>
														<td>${asTable.asAddress}</td>
													</tr>
													<tr>
														<th>联系人：</th>
														<td>${asTable.asPerson}</td>
													</tr>
													<tr>
														<th>联系电话：</th>
														<td>${asTable.asPhone}</td>
													</tr>

												</tbody>
											</table>
										</div>

									</div>
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
		<!-- .modal-weixin END -->

		<!-- .xm-dm-queue END -->

		<!-- .xm-dm-error END -->

		<!-- .modal-globalSites END -->

	</body>
<!--<script>
	function serviceDetail(){
		document.getElementById("asDetail ").style.display="block ";
	}
</script>-->
</html>