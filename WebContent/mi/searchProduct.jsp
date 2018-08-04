<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>搜索商品</title>
		<link rel="stylesheet" href="../css/bootstrap-self-use.css" />
		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet" />
		<link href="../css/font-awesome.css" rel="stylesheet">
		<link href="../css/model.css" rel="stylesheet">
		<link href="../css/search.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
		<script>
			function changePic(i,id) {
				var like = $(i).parent().find("p").html();
				var v = $(i).attr("src");
				if(like == "0"){
					$(i).parent().parent().parent().find("[class='actions clearfix']").find("a").find("i").attr("class","fa fa-heart-o");
					$(i).parent().parent().parent().find("[class='actions clearfix']").find("a").find("p").html(id);
				}else if(like == "1"){
					$(i).parent().parent().parent().find("[class='actions clearfix']").find("a").find("i").attr("class","fa fa-heart");
					$(i).parent().parent().parent().find("[class='actions clearfix']").find("a").find("p").html(id);
				}
				$(i).parent().parent().parent().find("[class='figure figure-img']").find("a").find("img").attr("src", v);
			}

			function like(i) {
				var id = $(i).parent().find("p").html();
				if ($(i).attr("class") == "fa fa-heart") {
					unlike(i);
					return ;
				}
				//Ajax调用处理
				$.ajax({
					type: "POST",
					url: "likeProductInSeachPage.action",
					data: "productId=" + id,
					success: function(data) {
						alert(data);
						if(data == "成功"){
							var pId = "p"+id;
							var heart = $("#"+pId).find("p");
							$(heart).html(1);
							$(i).attr("class","fa fa-heart");
						}else{
							alert(data);
						}
					}
				});
			} 
			
			function unlike(i) {
				var id = $(i).parent().find("p").html();
				//Ajax调用处理
				$.ajax({
					type: "POST",
					url: "unlikeProductInSeachPage.action",
					data: "productId=" + id,
					success: function(data) {
						alert(data);
						if(data == "成功"){
							var pId = "p"+id;
							var heart = $("#"+pId).find("p");
							$(heart).html(0);
							$(i).attr("class","fa fa-heart-o");
						}else{
							alert(data);
						}
					}
				});
			}

			var searchType = $("input[name='searchType']");
			var requireCondition = $("input[name='requireCondition']");
			var secondClassName = $("input[name='secondClassName']");
			function searchProduct(i, t) {
				if(t < 10){
					if ($(i).html() == "全部") {
						$("input[name='secondClassName']").attr("value","");
					}else{
						$("input[name='secondClassName']").attr("value",$(i).html());
					}
				
				}else if (t <20) {
					$("input[name='searchType']").attr("value",$(i).html());
				}else if (t<30) {
					alert(t == 21);
					if (t == 21) {
						$("input[name='requireCondition']").attr("value","评价");
					} else if(t == 22){
						$("input[name='requireCondition']").attr("value","有货");
					}
				}
				$("#searchformId").submit();
				
			} 
		</script>
	</head>

	<body>
		<form id="searchformId" action="searchProduct.action" method="post" style="display: none;">
			<input value="${searchType}" name="searchType"></input>
			<input value="${requireCondition}" name="requireCondition"></input>
			<input name="secondClassName" value="${secondClassName}" type="text"  />
			<input name="text" value="${text}" />
			<button type="submit">搜索</button>
		</form>
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
				<a>搜索商品</a>
			</div>
		</div>
		<div class="product-head-info">
			<div class="product-head-box">
				<div class="con">
					<span>分类</span>
					<a onclick="searchProduct(this,1)">全部</a>
					<c:forEach items="${secondClassNames}" var="name">
						<a <c:if test="${secondClassName == name}"> class="active first"</c:if> onclick="searchProduct(this,1)">${name}</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="grey-back-div">
			<div class="middle-content">
				<div class="order-list-box clearfix">
					<ul class="order-list"> 
						<li <c:if test="${searchType == ''}"> class="active first"</c:if>>
							<a onclick="searchProduct(this,11)" >推荐</a>
						</li>
						<li <c:if test="${searchType == '价格高'}"> class="active first"</c:if>>
							<a onclick="searchProduct(this,12)">价格高</a>
						</li>
						<li <c:if test="${searchType == '价格低'}"> class="active first"</c:if>>
							<a onclick="searchProduct(this,13)">价格低</a>
						</li>
						<li <c:if test="${searchType == '评价'}"> class="active first"</c:if>>
							<a onclick="searchProduct(this,14)">评价多</a>
						</li>
					</ul>
					<ul class="type-list"> 
						<li class="light">
							<input type="checkbox" <c:if test="${requireCondition == '评价'}"> checked="true"</c:if> onclick="searchProduct(this,21)" />
							<a>显示评价</a>
						</li>
						<li class="">
							<input type="checkbox" <c:if test="${requireCondition == '有货'}"> checked="true"</c:if> onclick="searchProduct(this,22)" />
							<a>只显示有货</a>
						</li>
					</ul>
				</div>
				<div class="goods-list-box">
					<div class="goods-list clearfix">
						<c:forEach items="${searchResults}" var="result">
						<c:if test="${commentFormat == 0}">
						<div class="goods-item">
							<div class="figure figure-img">
								<a href=""><img src="../${result.picUrl}" width="200" height="200" alt=""></a>
							</div>
							<p class="desc"></p>
							<h2 class="title"><a href="${result.productOriginalName}" >${result.productName}</a></h2>
							<p class="price">${result.productPrice}</p>
							<div class="thumbs">
								<c:forEach items="${result.products}" var="product">
								<a id="p${product.productId}"><p style="display: none;"><c:if test="${product.likeProduct == 0}">0</c:if><c:if test="${product.likeProduct == 1}">1</c:if></p><img src="../${product.picUrl}" width="34" height="34" onmouseover="changePic(this,${product.productId})"></a>
								</c:forEach>
							</div>
							<div class="actions clearfix">
								<c:forEach items="${result.products}" var="product" varStatus="i">
								<c:if test="${i.index < 1}">
								<c:if test="${product.likeProduct == 0}">
								<a class="btn-like J_likeGoods"><i class="fa fa-heart-o" aria-hidden="true" style="color:#e53935;cursor: pointer;" onclick="like(this)"></i><p style="display: none;">${product.productId}</p></a>
								</c:if>
								<c:if test="${product.likeProduct == 1}">
								<a class="btn-like J_likeGoods"><i class="fa fa-heart" aria-hidden="true" style="color:#e53935;cursor: pointer;" onclick="like(this)"></i><p style="display: none;">${product.productId}</p></a>
								</c:if>
								</c:if>
								</c:forEach>
							</div>
						</div>
						</c:if>
						<c:if test="${commentFormat == 1}">
						<div class="goods-item">
							<div class="figure figure-img">
								<a href=""><img src="../${result.picUrl}" width="200" height="200" alt=""></a>
							</div>
							<p class="desc"></p>
							<h2 class="title"><a href="${result.productOriginalName}" >${result.productName}</a></h2>
							<p class="price">${result.productPrice}</p>
							<div class="thumbs">
								<c:forEach items="${result.products}" var="product">
								<a><p style="display: none;"><c:if test="${product.likeProduct == 0}">0</c:if><c:if test="${product.likeProduct == 1}">1</c:if></p><img src="../${product.picUrl}" width="34" height="34" onmouseover="changePic(this)"></a>
								</c:forEach>
							</div>
							<div class="actions clearfix">
								<c:forEach items="${result.products}" var="product" varStatus="i">
								<c:if test="${i.index < 1}">
								<c:if test="${product.likeProduct == 0}">
								<a class="btn-like J_likeGoods"><i class="fa fa-heart-o" aria-hidden="true" style="color:#e53935;cursor: pointer;" onclick="like(this)"></i><p style="display: none;">${product.productId}</p></a>
								</c:if>
								<c:if test="${product.likeProduct == 1}">
								<a class="btn-like J_likeGoods"><i class="fa fa-heart" aria-hidden="true" style="color:#e53935;cursor: pointer;" onclick="like(this)"></i><p style="display: none;">${product.productId}</p></a>
								</c:if>
								</c:if>
								</c:forEach>
							</div>
						</div>
						<div class="goods-item" style="margin-left: -14px;background: #fafafa;padding: 50px;">
							<c:forEach items="${result.products}" var="product" varStatus="i">
							<c:if test="${i.index < 1}">
							<c:if test="${not empty prproduct.comment.commentContent}">
							<p style="float: left;">小米用户：</p>
							<p class="desc" style="width: 100%;"></p>
							<p>${product.comment.commentContent}</p>
							</c:if>
							<c:if test="${empty prproduct.comment.commentContent}">
							<p style="float: left;"> </p>
							<p class="desc" style="width: 100%;"></p>
							<p>暂无评价</p>
							</c:if>
							</c:if>
							</c:forEach>
						</div>
						</c:if>
						</c:forEach>
					</div>
					<div class="result-foot">
						<div class="page-turner" style="width: 1350px;">
							<ul class="pagination pagination-lg">
								<li class="disabled">
									<a href="#"><i class="fa fa-angle-left"></i></a>
								</li>
								<li class="active">
									<a href="#">1</a>
								</li>
								<li>
									<a href="#"><i class="fa fa-angle-right"></i></a>
								</li>
							</ul>
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