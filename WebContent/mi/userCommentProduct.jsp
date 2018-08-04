<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>评价</title>
		<link href="../css/Reset.css" type="text/css" rel="stylesheet" />
		<link href="../css/homepage.css" type="text/css" rel="stylesheet" />
		<link href="../css/font-awesome.css" rel="stylesheet">
		<link href="../css/model.css" rel="stylesheet">
		<link href="../css/comment.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/homepage.js"></script>
		<script type="text/javascript">
			$(function() {
				//为所有的li标签绑定mouseout和mouseover事件。bind({事件名：function(){},事件名：function(){}})的方法绑定多个事件
				$("#div li").bind({
					mouseout: function() {
						//$(this).css("color", "grey").html("☆").prevAll().css("color", "grey").html("☆")
					},
					mouseover: function() {
						$(this).css("color", "grey").html('<i class="fa fa-star-o" aria-hidden="true"></i>').nextAll().css("color", "grey").html('<i class="fa fa-star-o" aria-hidden="true"></i>')
						$(this).css("color", "yellow").html('<i class="fa fa-star" aria-hidden="true"></i>').prevAll().css("color", "yellow").html('<i class="fa fa-star" aria-hidden="true"></i>')

					}
				});
				//=实时显示分数.【index】搜索匹配的元素，并返回相应元素的索引值，从0开始计数。
				$("#div li").mouseover(function() {
					var rank = parseInt($(this).index("#div li")) + 1;
					var html = "";
					var s = "";
					switch(rank) {
						case 1:
							s = '<span>失望</span>';
							break;
						case 2:
							s = '<span>一般</span>';
							break;
						case 3:
							s = '<span>满意</span>';
							break;
						case 4:
							s = '<span>喜欢</span>';
							break;
						case 5:
							s = '<span>超爱</span>';
							break;
					}
					if(rank == 4 || rank == 5) {
						html = '<i class="fa fa-smile-o" aria-hidden="true"></i>';
					}
					if(rank == 3 || rank == 2) {
						html = '<i class="fa fa-meh-o" aria-hidden="true"></i>';
					}
					if(rank == 1) {
						html = '<i class="fa fa-frown-o" aria-hidden="true"></i>';
					}
					html += " " + s;
					$("#p").html(html);
					$("input[name='commentRank']").val(rank);
				});
				//鼠标按下时，确定分数。。
				$("#div li").mousedown(function() {
					$("#score").html(("你选择的分数是" + (parseInt($(this).index("#div li")) + 1)));
					$(this).css("color", "yellow").html('<i class="fa fa-star" aria-hidden="true"></i>').prevAll().css("color", "yellow").html('<i class="fa fa-star" aria-hidden="true"></i>');
					$("input[name='commentRank']").val(parseInt($(this).index("#div li")));
					//全部li标签的绑定事件全部清除--unbind方法可以加参数清除特定的事件。不加全部清除
					//$(this).unbind().prevAll().unbind().nextAll().unbind();
				});
			})
		</script>
		<script type="text/javascript">
			var loadImageFile = (function() {
				if(window.FileReader) {
					var oPreviewImg = null,
						oFReader = new window.FileReader(),
						rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;

					oFReader.onload = function(oFREvent) {
						if(!oPreviewImg) {
							var newPreview = document.getElementById("imagePreview");
							oPreviewImg = new Image();
							oPreviewImg.style.width = (newPreview.offsetWidth).toString() + "px";
							oPreviewImg.style.height = (newPreview.offsetHeight).toString() + "px";
							newPreview.appendChild(oPreviewImg);
						}
						oPreviewImg.src = oFREvent.target.result;
					};

					return function() {
						var aFiles = document.getElementById("imageInput").files;
						if(aFiles.length === 0) {
							return;
						}
						if(!rFilter.test(aFiles[0].type)) {
							alert("You must select a valid image file!");
							return;
						}
						oFReader.readAsDataURL(aFiles[0]);
					}

				}
				if(navigator.appName === "Microsoft Internet Explorer") {
					return function() {
						alert(document.getElementById("imageInput").value);
						document.getElementById("imagePreview").filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = document.getElementById("imageInput").value;

					}
				}
			})();
		</script>
		<script language="javascript">
			function vaildForm() {
				var id = $("input[name='productId']").val();
				var rank = $("input[name='commentRank']").val();
				var content = $("textarea[name='commentContent']").val();
				if(id) {
					if(rank != 0) {
						if(content == null || content==undefined ||content=="") {
							alert("评价内容不能为空");
						} else {
							return true;
						}
					} else {
						alert("请先打分");
					}

				} else {
					alert("数据错误");
				}

				return false;
			}
		</script>
		<style type="text/css">
			#menu {
				font: 12px verdana, arial, sans-serif;
				/* 设置文字大小和字体样式 */
			}
			
			#menu,
			#menu li {
				cursor: pointer;
				font-size: 30px;
				list-style: none;
				/* 将默认的列表符号去掉 */
				padding: 0;
				/* 将默认的内边距去掉 */
				margin: 5px;
				/* 将默认的外边距去掉 */
				float: left;
				/* 往左浮动 */
			}
		</style>
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
				<a>评价商品</a>
			</div>
		</div>
		<div class="grey-back-div">
			<div class="middle-content">
				<div class="product-info">
					<img src="../${product.picUrl}" alt="" width="auto" height="160px">
					<h3 class="product-name">${product.productName} ${product.version} ${product.color}</h3>
					<div class="product-price">${product.productPrice}元 </div>
					<p class="product-comments-info"> ${product.productCommentNum} 人评价</p>
				</div>
				<div class="comment-details">
					<div id="div" style="margin-top: 50px;">
						<ul id="menu">
							<li><i class="fa fa-star-o" aria-hidden="true" style="color: grey;"></i></li>
							<li><i class="fa fa-star-o" aria-hidden="true" style="color: grey;"></i></li>
							<li><i class="fa fa-star-o" aria-hidden="true" style="color: grey;"></i></li>
							<li><i class="fa fa-star-o" aria-hidden="true" style="color: grey;"></i></li>
							<li><i class="fa fa-star-o" aria-hidden="true" style="color: grey;"></i></li>
						</ul>

						<p id="p" class="rank-face"></p>
						<p id="score"></p>
					</div>

					<form action="commentProduct.action" method="post" enctype="multipart/form-data" onsubmit="return vaildForm()">
						<input name="productId" value="${product.productId}" style="display: none;" />
						<input name="commentRank" value="0" style="display: none;" />
						<textarea name="commentContent" clos=",50" rows="5" warp="virtual" class="comment-text"></textarea>
						<button type="submit" class="comment-button">发表评论</button>
						<div id="imagePreview" style="height:100px;width:110px;margin:10px auto;background-image: url(../images/image-default.png);">
							<input type="file" name="commentPic" class="inputstyle" id="imageInput" style="margin:0 0 10px 0" onchange="loadImageFile();">
						</div>

					</form>
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