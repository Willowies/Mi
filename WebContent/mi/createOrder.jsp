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
<link rel="stylesheet" href="../css/basic.css" type="text/css"/>
<link rel="stylesheet" href="../css/createOrder.css" type="text/css"/>
<script type="text/javascript" src="../js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="../js/createOrder.js"></script>
<link href="../css/font-awesome.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写订单信息</title>
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

<div class="head">
		<div class="head-container">
			<div class="head-logo">
				<div class="logo">
					<img src="../images/head-logo.png" style="width: 48px;height: 48px;"/>
				</div>
			</div>
			<div class="head-title">
					<h2 class="head-content">
						确认订单
					</h2>
			</div>
		</div>
	</div>



<form action="createOrder.action" method="post">
		<div id="mask"></div>
		<div class="page-main" style="padding-top:40px;padding-bottom:60px">
			<div class="container">
				<div class="checkout-box">
					<div class="section section-address">
						<div class="section-header clearfix">
							<h3 class="title">收货地址</h3>
						</div>
						<div class="section-body1 clearfix">
							<div id="userAddress">
								<c:forEach items="${addresses}" var="a">
										<div class="address-item address">
											<dl>
												<dt>
													<span class="tag"></span>
													<em class="uname" id="aName">${a.receiverName}</em>
												</dt>
												<dd class="utel" id="aPhone">${a.receiverPhone}</dd>
												<dd class="uaddress">
													<em style="font-style:normal;" id="aProvince">${a.receiverProvince}</em>
													<em style="font-style:normal;" id="aCity">${a.receiverCity}</em>
													<em style="font-style:normal;" id="aDistrict">${a.receiverDistrict}</em>
													<br />
													<em style="font-style:normal;" id="aAddress">${a.address }</em>
												</dd>
											</dl>
										</div>
								</c:forEach>
							</div>
							<div class="address-item new-address" id="add-new-address">
								<span class="addAddress">添加新地址</span>
							</div>
						</div>
					</div>
					<input type="text" name="receiverName" id="rName"  style="display:none">
					<input type="text" name="receiverPhone" id="rPhone"  style="display:none">
					<input type="text" name="receiverAddress" id="rAddress"  style="display:none">
					<div class="section section-option section-shipment clearfix">
						<div class="section-header">
							<h3 class="title">配送方式</h3>
						</div>
						<div class="section-body2 clearfix">
							<ul class="options">
								<li class="option selected">
									快递配送
								</li>
							</ul>
						</div>
					</div>
					<div class="section section-option section-time clearfix">
						<div class="section-header">
							<h3 class="title">配送时间</h3>
						</div>
						<div class="section-body2 clearfix" id="deliveryTime">
							<ul class="option-list options clearfix">
								<li class="option selected" id="noLimit">
									不限送货时间：
									<span>周一到周日</span>	
								</li>
								<li class="option" id="workday">
									工作日送货：
									<span>周一到周五</span>
								</li>
								<li class="option" id="weekday">
									双休日、假日送货：
									<span>周六至周日</span>
								</li>
							</ul>
							<input type="text" name="sendPeroid" value="1" id="sPeroid" style="display:none">
						</div>
					</div>
					<div class="section section-option section-invoice clearfix">
						<div class="section-header">
							<h3 class="title">发票</h3>
						</div>
						<div class="section-body2 clearfix">
							<div class="invoice-result">
								<!-- <span>电子发票</span>
								<span>个人</span> -->
								<span>商品明细</span>
								<a id="updateInvoice">修改 ></a>
							</div>
						</div>
					</div>
					<div class="section section-goods clearfix">
						<div class="section-header clearfix">
							<h3 class="title">商品及优惠券</h3>
							<div class="more">
								<a  href="findCartItem.action">返回购物车</a>
							</div>
						</div>
						<div class="section-body2">
							<ul class="goods-list">
								<c:forEach items="${cartItems}" var="c">
									<li class="clearfix" id="cartItem">
										<div class="col col-img">
											<img src="../${c.product.picUrl}" width="30" height="30"/>
										</div>
										<div class="col col-name">
											<a>${c.product.extremeName}</a>
										</div>
										<div class="col col-price">
											${c.product.productPrice}元  × ${c.quantity}
										</div>
										<div class="col col-status">
										
										</div>
										<div class="col col-total">
											${c.amount}元
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="section section-count clearfix">
						<div class="count-actions">
							<div class="coupon-trigger" id="chooseCoupon">
								<i class="fa fa-plus select"></i>
								使用优惠券
							</div>
							<div class="coupon-box" style="display: none;">
								<ul class="clearfix tab">
									<li>选择优惠券</li>
								</ul>
								<div class="tab-container">
									<div class="tab-content list-content">
										<ul class="coupon-list">
											<c:forEach items="${coupons}" var="coupon">
												<li class="theCoupon">
													${coupon.couponName}
													<p id="cId" style="display:none;">${coupon.couponId}</p>
													<p id="cAmount" style="display:none;">${coupon.discountAmount}</p>
												</li>
											</c:forEach>
										</ul>
										<input type="text" name="coupon.couponId" id="couId" value="0" style="display:none">
										<input type="text" name="coupon.discountAmount" id="couAmount" value="0" style="display:none">
										<div class="coupon-confirm">
											<a class="btn btn-primary" style="margin-right: 3px;" id="useCoupon">确认使用</a>
											<a class="btn btn-gray" style="margin-left: 3px;"id="noCoupon">不使用优惠券</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="money-box">
							<ul>
								<li>
									<label>商品件数：</label>
									<span class="val">${itemNum}件</span>
								</li>
								<li>
									<label>商品总价：</label>
									<span class="val" id="money">${total}</span><span class="val">元</span>
								</li>
								<li>
									<label>优惠券抵扣：</label>
									<span class="val" id="reduce"></span><span class="val">元</span>
								</li>
								<li>
									<label>运费：</label>
									<span class="val" id="delivery">10</span><span class="val">元</span> 
								</li>
								<li class="total-price">
									<label>应付总额：</label>
									<span class="val">
										<em id="actualFee"></em>
										元
									</span>
								</li>
							</ul>
						</div>
					</div>
					<div class="section-bar clearfix">
						<div class="fr">
							<a class="btn" id="submitButton">立即下单</a>
						</div>
					</div>
				</div>
			</div>
			<div class="invoice-box" style="display: none;">
				<div class="modal-bd">
					<span class="title">发票信息</span>
					<a class="close" id="invoice-close"><i class="fa fa-close"></i></a>
				</div>
				<div class="modal-body">
					<div class="in-section clearfix">
						<label class="tit">发票类型：</label>
						<ul class="options option-list clearfix">
							<li class="option selected" id="pInvoice">纸质发票</li>
							<li class="option" id="eInvoice">电子发票</li>
						</ul>
						<input type="text" name="invoice.invoiceType" id="iType" value="1" style="display:none">
						<div class="invoice-tip invoice-paper-tip" id="pInvoiceTip">
							1. 发票不与商品随箱寄出；<br />
							2. 发票将于商品妥投完成7日后单独寄出；<br />
							3. 发票收到后请妥善保存，退货需一同寄回。 <br />
						</div>
						<div class="invoice-tip active" style="display: none;" id="eInvoiceTip">
							电子发票与纸质发票具有相同法律效力，可作为报销、售后、维权凭证。<br />
							<span>推荐使用电子发票，不怕丢失、更方便、更环保。</span><br />
						</div>
					</div>
					<div>
						<div class="in-section clearfix">
							<label class="tit">发票抬头：</label>
							<ul class="options option-list clearfix">
								<li class="option selected" id="personInvoice">个人</li>
								<li class="option" id="companyInvoice">单位</li>
							</ul>
							<input type="text" name="invoice.receiverType" id="rType" value="1" style="display:none">
							<div class="form-section">
								<label class="input-label">请输入发票抬头</label>
								<input class="input-text" type="text" name="invoice.receiver" id="iReceiver" />
							</div>
						</div>
						<div class="in-section clearfix" style="display: none;" id="taxBlock">
							<label class="tit">单位税号：</label>
							<div class="form-section">
								<label class="input-label">请填写购买方纳税人识别号或统一社会信用代码</label>
								<input class="input-text" type="text" name="invoice.taxNum" id="iTaxNum" />
							</div>
						</div>
						<div class="in-section clearfix" style="display: none;" id="eInvoicePhone">
							<label class="tit">收票手机：</label>
							<div class="form-section">
								<label class="input-label">收票人手机</label>
								<input class="input-text" type="text" name="invoice.receivePhone" id="iPhone" />
							</div>
						</div>
						<div class="in-section clearfix" style="display: none;" id="eInvoiceEmail">
							<label class="tit">收票邮箱：</label>
							<div class="form-section">
								<label class="input-label">收票人邮箱</label>
								<input class="input-text" type="text" name="invoice.receiveEmail" id="iEmail" />
							</div>
						</div>
						<div class="in-section clearfix in-section-con">
							<label class="tit">发票内容：</label>
							购买商品明细
						</div>
						<div class="more">
							<dl>
								<dt>发票须知：</dt>
							    <dd>1.发票金额为实际支付金额，不包含优惠券、礼品卡等；</dd>
    							<dd>2.电子发票可以在订单完成后，在订单详情中下载和查看；</dd>
  								<dd>3.纸质发票不与商品同时发出，商品妥投完成7日后发出，收到后请妥善保存，如退货需一同寄回。</dd>
    							<dd>4.第三方商品的发票由相关企业单独开具。</dd>
    						</dl>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<a class="btn btn-gray" id="cancel-invoice">取消</a>
					<a class="btn btn-primary" id="save-invoice">保存</a>
				</div>
			</div>
			<div class="edit-address" style="display: none;">
				<div class="modal-header">
					<span class="title">添加收货地址</span>
					<a class="close" id="close-address"><i class="fa fa-close"></i></a>
				</div>
				<div class="modal-body">
					<div class="form-box clearfix">
						<div class="form-section form-name">
							<div class="input-label">姓名</div>
							<input class="input-text" type="text"  id="inputReceiverName" maxLength="12"/>
						</div>
						<div class="form-section form-phone">
							<div class="input-label">手机号</div>
							<input class="input-text" type="text"  id="inputReceiverPhone" maxLength="15"/>
						</div>
						<div class="form-section form-province">
							<div class="input-label">省</div>
							<input class="input-text" type="text"  id="inputReceiverProvince" maxLength="5" />
						</div>
						<div class="form-section form-city">
							<div class="input-label">市</div>
							<input class="input-text" type="text"  id="inputReceiverCity" maxLength="5"/>
						</div>
						<div class="form-section form-district">
							<div class="input-label">区</div>
							<input class="input-text" type="text"  id="inputReceiverDistrict" maxLength="5" />
						</div>
						<div class="form-section form-detail">
							<div class="input-label">详细地址</div>
							<input class="input-text" type="text"  id="inputAddress" maxLength="200"/>
						</div>
						<div class="form-section form-label">
							<div class="input-label">地址标签</div>
							<input class="input-text" type="text"  id="inputAddressLabel" maxLength="5"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<a class="btn btn-primary" id="addAddressButton">保存</a>
					<a class="btn btn-gray" id="cancel-address">取消</a>
				</div>
			</div>
		</div>
</form>


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