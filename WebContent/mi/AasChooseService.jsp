<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
				<a rel="nofollow" class="cart-mini" id="J_miniCartBtn" href="">
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
					<li id="navItem9" class="nav-item">服务</li>
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
					<div class="span16 ">

						<div class="service-box service-main-box ">
							<div class="service-content-box ">
								<div class="box-hd ">
									<h1 class="title ">申请售后服务</h1>
								</div>
								<div class="box-bd ">
									<div class="service-progress ">
										<ol class="service-progress-list service-progress-list-col-3 clearfix ">
											<li class="step step-first step-active ">
												<div class="progress "><span class="text ">选择产品和服务</span></div>
											</li>
											<li class="step ">
												<div class="progress "><span class="text ">填写申请单</span></div>
											</li>
											<li class="step step-last ">
												<div class="progress "><span class="text ">完成申请</span></div>
											</li>
										</ol>
									</div>

									<div id="J_serviceDetail " class="service-step-box ">
										<form action="asChooseService.action" method="post" enctype="multipart/form-data">
											<div class="service-section ">
												<div class="section-hd ">
													<h2 class="section-title ">选择进行售后的商品</h2>
												</div>
												<div class="section-bd ">
													<div class="product-detail ">
														<dl class="detail-list ">
															<dt class="name ">${asTableChoosePro.productName}&nbsp;&nbsp;&nbsp;${asTableChoosePro.version}&nbsp;&nbsp;&nbsp;${asTableChoosePro.color}</dt>
															<dd class="item-no ">单品号：${asTableChoosePro.asProId}</dd>
															<dd class="imei-no ">SN号： ${asTableChoosePro.asSn}</dd>
														</dl>
														<img class="thumb " src="//i1.mifile.cn/a1/pms_1524621222.66011593!100x100.jpg " alt=" " />
													</div>
												</div>
											</div>
											<div class="service-section" data-step="1 ">
												<div class="section-hd ">
													<h2 class="section-title ">为您的产品选择服务类型</h2>
												</div>

												<div class="section-bd ">

													<ul class="service-label-list service-label-list-large clearfix ">
														<li class="" data-toggle="step " ><label><input type="radio" onclick="showDetail() " name="asWay" value="维修"  /><i class="icon icon-11 "></i>维修</label></li>
													</ul>
													<p class="tip ">* 您的商品支持维修服务 </p>
												</div>

											</div>
								<div id="serviceDetail " style="display:none ">
											<div class="service-section " data-step="2 ">
												<div class="section-hd ">
													<h2 class="section-title ">产品问题描述</h2>
												</div>
												<div class="section-bd ">
													<div class="other-input J_otherInput ">
														<textarea placeholder="请输入具体问题... " class="input-text "  name="asDescription " id="issue-other " required="required"></textarea>
													</div>
													<h3 class="label-title label-title-row ">上传机器图片（请注意拍摄画质尽量清晰，突出机器故障问题。非必填项）</h3>
													<fieldset class="form-section ">
														<div id="faultImgContainer " class="uploader clearfix ">
															<!-- <a id="faultImgUploader " class="btn-uploader J_btnUploader " href="javascript: void(0); " data-uploader-name="faultImg " data-biz-name="fault ">添加图片</a> -->
															 <label class="btn-uploader J_btnUploader" for="uploadImage">上传图片</label>
                                                              <input type="file" name="asRepairProUrl" value="" id="uploadImage" hidden="hidden" accept="image/gif, image/jpg, image/png" >
														</div>
														<!-- <input type="hidden" name="faultImgUrl " /> -->
													</fieldset>
												</div>
											</div>

											

											<div class="service-section " data-step="3 ">
												<div class="section-hd ">
													<h2 class="section-title ">选择服务方式</h2>
												</div>
												<div class="section-bd ">
													<ul id="J_serviceWayList " class="service-label-list service-label-list-large-detail clearfix J_labelList ">
														<li data-toggle="step " class="sw " id=wx>
															<label>
                                            <input type="radio" name="asBack" value="寄修" onclick="nextStep()" /> 寄修  
                                            <span class="desc ">审核通过后，寄送商品，小米售后为您服务。</span>
                                        </label>
														</li>
														<li data-toggle="step " class="sw " id=wx>
															<label>
                                            <input type="radio" name="asBack" value="到家" onclick="nextStep()" /> 到家
                                            <span class="desc ">审核通过后，工程师上门为您服务。</span>
                                        </label>
														</li>
														<li data-toggle="step " class="sw" id=wx>
															<label>
                                            <input type="radio" name="asBack" value="到店" onclick="nextStep()" />到店
                                            <span class="desc ">亲临授权门店，售后专家为您服务。</span>
                                        </label>
														</li>
													</ul>
												</div>
											</div>
								</div>		
								        <div id="showNextStep " style="display: none">
											<div class="service-section ">
												<input class="btn btn-primary " type="submit" value="下一步 " />
											</div>
										</div>	
										</form>
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
<script>
	function showDetail(){
		document.getElementById("serviceDetail ").style.display="block ";
	}
</script>
<script>
	function nextStep(){
		document.getElementById("showNextStep ").style.display="block ";
	}
</script>
</html>
