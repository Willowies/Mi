<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<link rel="stylesheet" href="../css/bootstrap-self-use.css" />
		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet" />
		<link href="../css/font-awesome.css" rel="stylesheet">
		<link href="../css/model.css" rel="stylesheet">
		<link href="../css/commentPage.css" rel="stylesheet">
		<style>
			a{
				color: #555;
			}
		</style>
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/myOwnHeadJs.js" ></script>
		<script>
			function showPic(i) {
				var src = i.src;
				if(src != null && src != '') {
					$('#jump-big-img').attr("src", src);
					$('#jump-block').css("display", "block");
				}
			}

			function fadePic() {
				$('#jump-block').css("display", "none");

			}
		</script>
	</head>

	<body>
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
					<a rel="nofollow" class="cart-mini" id="J_miniCartBtn" href="">
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
						<li id="navItem9" class="nav-item">服务</li>
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

		<div class="product-head-info">
			<div class="product-head-box">
				<div class="product-name">${productName}</div>
				<div class="con">
					<a href="//www.mi.com/huosai3/">概述</a>&nbsp; |&nbsp;
					<a href="//www.mi.com/huosai3/">参数</a>&nbsp; |&nbsp;
					<a href="//www.mi.com/huosai3/">用户评价</a>&nbsp; |&nbsp;
					<a href="//www.mi.com/huosai3/" class="btn-toBuy">立即购买</a>
				</div>
			</div>
		</div>
		<!-- 弹窗 -->
		<div id="jump-block" onclick="fadePic()">
			<div class="big-img">
				<img id="jump-big-img" src="../images/T1bXKjBQAT1RXrhCrK.jpg" width="600px" />
			</div>
		</div>
		<div class="grey-back-div" style="padding-top: 20px;    box-shadow: inset 0px 5px 5px rgba(0,0,0,0.07);">
			<div class="middle-content">
				<div class="choose-comment">
					<a href="getCommentPage.action?${productName}" <c:if test="${commentType==1}"> class="choosed"</c:if>>热门</a>
					<a href="getGoodCommentPage.action?${productName}" <c:if test="${commentType==2}"> class="choosed"</c:if>>好评(${goodNum})</a>
					<a href="getMiddleCommentPage.action?${productName}" <c:if test="${commentType==3}"> class="choosed"</c:if>>中评(${middleNum})</a>
					<a href="getBadCommentPage.action?${productName}" <c:if test="${commentType==4}"> class="choosed"</c:if>> 差评(${badNum})</a>
				</div>
				<c:if test="${not empty newComments}">
					<div class="comment-details" style="float: right;">
						<h4 style="    margin-top: 50px;">最新评价</h4>
						<ul class="m-spe-list J_speList">
							<c:forEach items="${newComments}" var="comment">
								<li class="">
									<div class="spe-top" style="margin-bottom: 10px;"> <span class="time"><fmt:formatDate value="${comment.commentDate}" type="date"/></span>
										<a>- ${comment.user.userName}</a>
									</div>
									<div class="txt">
										<a> ${comment.commentContent} </a>
									</div>
									<div class="comment-eval">
										<c:if test="${comment.commentRank == 1}"><i class="fa fa-frown-o" aria-hidden="true"></i> 失望</c:if>
										<c:if test="${comment.commentRank == 2}"><i class="fa fa-meh-o" aria-hidden="true"></i> 一般</c:if>
										<c:if test="${comment.commentRank == 3}"><i class="fa fa-meh-o" aria-hidden="true"></i> 满意</c:if>
										<c:if test="${comment.commentRank == 4}"><i class="fa fa-smile-o" aria-hidden="true"></i> 喜欢</c:if>
										<c:if test="${comment.commentRank == 5}"><i class="fa fa-smile-o" aria-hidden="true"></i> 超爱</c:if>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<c:forEach items="${hotComments}" var="comment">
					<div class="product-info">
						<div class="span13 comment-detail">
							<ul class="m-comment-list">
								<li class="com-item J_resetImgCon J_canZoomBox" data-id="154912845">
									<a class="user-img"> <img src="../${comment.user.userHead}"> </a>
									<div class="comment-info">
										<a class="user-name">${comment.user.userName}</a>
										<p class="time">
											<fmt:formatDate value="${comment.commentDate}" type="date" />
										</p>
									</div>
									<div class="comment-eval">
										<c:if test="${comment.commentRank == 1}"><i class="fa fa-frown-o" aria-hidden="true"></i> 失望</c:if>
										<c:if test="${comment.commentRank == 2}"><i class="fa fa-meh-o" aria-hidden="true"></i> 一般</c:if>
										<c:if test="${comment.commentRank == 3}"><i class="fa fa-meh-o" aria-hidden="true"></i> 满意</c:if>
										<c:if test="${comment.commentRank == 4}"><i class="fa fa-smile-o" aria-hidden="true"></i> 喜欢</c:if>
										<c:if test="${comment.commentRank == 5}"><i class="fa fa-smile-o" aria-hidden="true"></i> 超爱</c:if>
									</div>
									<div class="comment-txt">
										<p> ${comment.commentContent}</p>
									</div>
									<c:if test="${not empty comment.commentUrl}">
										<div class="m-img-list clearfix h-img-list">
											<div class="img-item img-item1 item-one showimg">
												<img class="J_resetImgItem J_canZoom" src="../${comment.commentUrl}" height="160px" width="auto" style="cursor: pointer;" onclick="showPic(this)">
											</div>
										</div>
									</c:if>
									<div class="comment-answer">
										<c:forEach items="${comment.commentResponses}" var="response" varStatus="i">
											<c:if test="${i.index < 1}">
											<div class="answer-item">
												<c:if test="${not empty response.user.userHead}">
													<img class="answer-img" src="../${response.user.userHead}">
												</c:if>
												<div class="answer-content">
													<h3 class="">${response.user.userName}</h3>
													<p> ${response.commentContent} </p>
												</div>
											</div>
											</c:if>
										</c:forEach>
									</div>
									<div class="comment-detail-btn">
										<a href="commentDetails.action?commentId=${comment.commentId}">查看评价详情</a>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</c:forEach>
				<c:forEach items="${rankComments}" var="comment">
					<div class="product-info">
						<div class="span13 comment-detail">
							<ul class="m-comment-list">
								<li class="com-item J_resetImgCon J_canZoomBox" data-id="154912845">
									<a class="user-img"> <img src="../${comment.user.userHead}"> </a>
									<div class="comment-info">
										<a class="user-name">${comment.user.userName}</a>
										<p class="time">
											<fmt:formatDate value="${comment.commentDate}" type="date" />
										</p>
									</div>
									<div class="comment-eval">
										<c:if test="${comment.commentRank == 1}"><i class="fa fa-frown-o" aria-hidden="true"></i> 失望</c:if>
										<c:if test="${comment.commentRank == 2}"><i class="fa fa-meh-o" aria-hidden="true"></i> 一般</c:if>
										<c:if test="${comment.commentRank == 3}"><i class="fa fa-meh-o" aria-hidden="true"></i> 满意</c:if>
										<c:if test="${comment.commentRank == 4}"><i class="fa fa-smile-o" aria-hidden="true"></i> 喜欢</c:if>
										<c:if test="${comment.commentRank == 5}"><i class="fa fa-smile-o" aria-hidden="true"></i> 超爱</c:if>
									</div>
									<div class="comment-txt">
										<p> ${comment.commentContent}</p>
									</div>
									<c:if test="${not empty comment.commentUrl}">
										<div class="m-img-list clearfix h-img-list">
											<div class="img-item img-item1 item-one showimg">
												<img class="J_resetImgItem J_canZoom" src="../${comment.commentUrl}" height="160px" width="auto" style="cursor: pointer;" onclick="showPic(this)">
											</div>
										</div>
									</c:if>
									<div class="comment-answer">
										<c:forEach items="${comment.commentResponses}" var="response" varStatus="i">
											<c:if test="${i.index < 1}">
											<div class="answer-item">
												<c:if test="${not empty response.user.userHead}">
													<img class="answer-img" src="../${response.user.userHead}">
												</c:if>
												<div class="answer-content">
													<h3 class="">${response.user.userName}</h3>
													<p> ${response.commentContent} </p>
												</div>
											</div>
											</c:if>
										</c:forEach>
									</div>
									<div class="comment-detail-btn">
										<a href="commentDetails.action?commentId=${comment.commentId}">查看评价详情</a>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</c:forEach>
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