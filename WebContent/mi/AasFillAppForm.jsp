<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>

	<head>
		<!--
    	作者：lauraliu20@163.com
    	时间：2018-07-23
    	描述：填写上门的信息
    -->
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
	

<!-- .site-header END -->

<div class="breadcrumbs ">
    <div class="container ">
        <a href="//www.mi.com/index.html ">首页</a><span class="sep ">&gt;</span><span>申请售后服务</span>
    </div>
</div>

<div class="page-main user-main ">
    <div class="container ">
        <div class="row ">
				<div class="span4">
					<div class="uc-box uc-sub-box">
                    <div class="uc-nav-box">
                        <div class="box-hd">
                            <h3 class="title">订单中心</h3>
                        </div>
                        <div class="box-bd">
                            <ul class="uc-nav-list">
                               <li><a href="getAllOrder.action">我的订单</a></li>
								<li><a href="../mi/getAllGroupOrder.action">团购订单</a></li>
								<li><a href="../mi/getWaitCommentProduct.action">评价晒单</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="uc-nav-box">
                        <div class="box-hd">
                            <h3 class="title">个人中心</h3>
                        </div>
                        <div class="box-bd">
                            <ul class="uc-nav-list">
                               <li><a href="disPlayMyPersonalCenter.action">我的个人中心</a></li>
								<li><a href="displayMessage.action">消息通知</a></li>
								<li><a href="displayLikeProduct.action">喜欢的商品</a></li>
								<li><a href="displayCoupon.action">优惠券</a></li>
								<li><a href="displayReceiverAddress.action">收货地址</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="uc-nav-box">
                        <div class="box-hd">
                            <h3 class="title">售后服务</h3>
                        </div>
                        <div class="box-bd">
                            <ul class="uc-nav-list">
                                <li><a href="asSelectTables.action">服务记录</a> </li>
								<li> <a href="AasApplyWay.jsp">申请服务</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="uc-nav-box">
                        <div class="box-hd">
                            <h3 class="title">账户管理</h3>
                        </div>
                        <div class="box-bd">
                            <ul class="uc-nav-list">
                                <li><a href="../mi/selectUser.jsp">个人信息</a></li>
								<li><a href="../mi/updatePassword.jsp">修改密码</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
				</div>
<div class="span16 ">
    <div class="service-box service-main-box ">
        <div class="service-content-box ">
            <div class="box-hd ">
                <h1 class="title ">
                    申请售后服务
                    <span class="title-tip ">
                        <i class="iconfont ">&#xe617;</i>
                        <span class="popup ">“首选寄修，售后无忧”小米为您提供更方便、更快捷的一站式售后服务。您只需通过在线或拨打热线申请寄修服务，通过审核后寄送商品至小米，我们将在最短的时间内快速响应并为您提供后续服务。</span>
                    </span>
                </h1>
            </div>
            <div class="box-bd ">
                <div class="service-progress ">
                    <ol class="service-progress-list service-progress-list-col-3 clearfix ">
                        <li class="step step-first step-done ">
                            <div class="progress "><span class="text ">选择产品和服务</span></div>
                        </li>
                        <li class="step step-active ">
                            <div class="progress "><span class="text ">填写申请单</span></div>
                        </li>
                        <li class="step step-last ">
                            <div class="progress "><span class="text ">完成申请</span></div>
                        </li>
                    </ol>
                </div>

                <div class="service-step-box">
                    <div class="service-section">
                        <div class="section-hd">
                            <h2 class="section-title ">选择取件方式</h2>
                        </div>
                        <div class="section-bd ">
                            <ul class="service-label-list service-label-list-large-detail clearfix J_labelList J_collectSwitch " data-tab-target="J_collectTypeContainer ">
                                <li data-type="jx "><label class="labelActive"><input type="radio" name="sendToMi" value="寄送" /><i class="icon icon-12 "></i>寄送给小米<span class="desc ">快递至小米维修中心</span></label></li>
                            </ul>
                            <span id="to_pay_tip " style="color:red ">建议使用顺丰快递到付进行邮寄，由小米承担物流费用，其他快递暂时不支持到付 ；<br>7天无理由退货需扣取运费；保外维修会收取额外的快递费用</span>
                        </div>
                    </div>

                    <div id="J_collectTypeContainer " class="tab-container ">
                        
                        <div class="tab-content">
                            <form action="asFillForm.action" method="post">
                                <!--<input type="hidden " name="unique " value="843e544fa3b2c2d7 ">-->
                                <div class="service-section ">
                                    <div class="section-hd ">
                                        <h2 class="section-title ">您的收货地址</h2>
                                    </div>
                                    <div class="section-bd ">
                                        <div class="service-address-form " data-province-id=" " data-city-id=" " 
                                        data-area-id=" " 
                                        data-district-id=" ">
                                            <div class="form-row clearfix ">
                                                <fieldset class="form-section">
                                                    <label class="input-label " for="shouhuo_user_name_2 ">姓名</label>
                                                    <input class="input-text " type="text" id="shouhuo_user_name_2 " name="asPerson" placeholder="姓名 "  required="required"/>
                                                </fieldset>
                                                <fieldset class="form-section">
                                                   <label class="input-label " for="shouhuo_tel_2 ">手机号</label>
                                                    <input class="input-text " type="tel" id="shouhuo_tel_2 " name="asPhone" placeholder="输入你的手机号码 " maxlength="11 " required="required" />
                                                </fieldset>
                                            </div>
                                            <div class="form-row clearfix ">
                                                <fieldset class="form-section ">
                                                    <div class="xm-select ">
                                                        <div class="dropdown ">
                                                            <label class="iconfont " for="province ">&#xe61b;</label>
                                                            <select name="province" id="province" name="province">
                                                                <option value=" ">选择省份</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </fieldset>
                                                <fieldset class="form-section ">
                                                    <div class="xm-select ">
                                                        <div class="dropdown ">
                                                            <label class="iconfont " for="city ">&#xe61b;</label>
                                                            <select name="city" id="city" name="city">
                                                                <option value=" ">选择城市</option>
                                                            </select>
                                                            
                                                        </div>
                                                    </div>
                                                </fieldset>
                                                <fieldset class="form-section ">
                                                    <div class="xm-select ">
                                                        <div class="dropdown ">
                                                            <label class="iconfont " for="town ">&#xe61b;</label>
                                                            <select name="town" id="town" name="town">
                                                                <option value=" ">选择区域</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </fieldset>     
                                            </div>     
                                                <div class="other-input J_otherInput ">
														<textarea placeholder="请输入详细地址.. " class="input-text "  name="asDescription " id="issue-other " required="required"></textarea>
												</div>        
                                        </div>
                                    </div>
                                </div>
                                <input class="btn btn-primary " type="submit" value="提交申请 " />
                            </form>
                        </div>
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
<script type="text/javascript">
	$(".labelActive").click(function(){
		$(".labelActive").removeClass("active");
		$(this).addClass("active");
	})
</script>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="../js/asAreaInfo.js"></script>
<script src="../js/asSelectArea.js"></script>
</html>