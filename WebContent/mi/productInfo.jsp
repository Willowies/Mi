<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"   %>
<!DOCTYPE html>
<html>
	<head>
		<link href="../css/productInfo.css" rel='stylesheet' type='text/css' />
		<link href="../css/font-awesome.css" rel='stylesheet' type='text/css' />
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<script src="../js/jquery-3.2.0.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/productInfo.js"></script>
		<meta charset="UTF-8">
		<title>商品详情</title>
	</head>
	<body>
		
		<div class="buyBox" id="buyBox">
			<div class="box clearfix">
				<div class="login-notic">
					<!--未登录提示-->
					<div class="page-container">						
                                                                                 为方便您购买，请提前登录 
                        <a href="" class="proLogin" onclick="" style="color: #ff6700 !important;text-decoration: none;margin-left:25px">立即登录</a> 
                        <span class="proLoginClose fa fa-close" style="color: #b5b5b5;" onclick=""></span>
					</div>
				</div>
				<div class="pro-choose-main page-container clearfix">
					<div class="pro-view span10">
						<!--左侧轮播图-->
						<div class="imgload hide"></div>
						<div id="img" class="img-con" style="left: 62.5px; margin-top: 0px;">
							<div class="ui-wrapper" style="max-width: 100%;">
								<div class="ui-viewport" style="width: 100%; overflow: hidden; position: relative; height: 560px;">
									
								</div>
								<div class="ui-controls">
									<div class="ui-pager ui-default-pager">
										<div class="ui-pager-item">
											<a href data-slide-index="0" class="ui-pager-link active">1</a>
										</div>
									</div>
									<div class="ui-controls-direction">
										<a class="ui-prev " style="cursor:pointer" onclick="">上一张</a>
										<a class="ui-next " style="cursor:pointer" onclick="">下一张</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="pro-info span10">
						<h1 id="pro-title" class="pro-title">${productName}</h1>
						<!--提示-->
						<p class="sale-desc" id="desc"></p>
						<!--选择第一级别-->
						<span class="pro-price"></span>
						<div class="loading hide">
							<div class="loader"></div>
						</div>
						<c:if test="${couponList.size() != 0}">
						    <div class="saleWrap">
						    <c:forEach items="${couponList}" var="c">
						      <form action="receiveCoupon.action?couponId=${c.couponId}" method="post">
                                <div class="coupon-wrap">
								    <span class="coupon-tag">优惠券</span>
								    <span class="couponName">${c.couponName}</span>
								    <span class="couponId" style="display:none;">${c.couponId}</span>
								    <span class="couponDiscount" style="display:none;">${c.discountAmount}</span>
								    <span class="startDate" style="display:none;">${c.startDate}</span>
								    <span class="endDate" style="display:none;">${c.endDate}</span>
								    <a class="getCoupon" style="color: #ff6700 !important; cursor: pointer; display: inline-block; text-decoration: none;" 
									    data-toggle="modal">立即领取</a>
							    </div>
							  </form>
                            </c:forEach>
                            </div>
						</c:if>
			
						<!--商品信息主体-->
						<div class="pro-main">
							<!--当前仓库-->
							<div class="address-wrap">
								<div class="user-default-address" id="userDefaultAddress">
									<i class="fa fa-location-arrow"></i>
									<div>
										<div class="address-info">
											<span class="item">${receiverAddress.receiverProvince}</span>
											<span class="item">${receiverAddress.receiverCity}</span>
											<span class="item">${receiverAddress.receiverDistrict}</span>
											<span class="item">${receiverAddress.address}</span>
										</div>
									</div>
									<div class="product-status active" id="productStatus">
										<span class="sale">有现货</span>										
										<span class="over">暂时缺货</span>
									</div>
								</div>
							</div>
							<!--产品版本-->
							<div class="list-wrap" id="versionList">
								<!--选择版本-->
								<div class="pro-choose pro-choose-col" data-index="0">
									<div class="step-title version" data-name="选择版本">选择版本</div>
									<ul id="selectVersion" class="step-list step-one clearfix">
									  <c:forEach items="${productList}" var="p">
										  <li class="but but-biglarge">
											  <a onclick="">
												  <span class="name">${p.version}</span>
											  </a>
										  </li>
									  </c:forEach>	
									</ul>
								</div>
								<!--选择颜色-->
								<div id="selectColor" class="pro-choose pro-choose-col" data-index="1">
									<div class="step-title" data-name="选择颜色"> 选择颜色  </div>
									<ul class="step-list clearfix">										
										
									</ul>
								</div>
								<!--已选择的产品-->
								<div class="pro-list" id="proList">
									<ul>
										<li id="totalName">
										    
											
										</li>
										<li class="totalPrice"></li>
									</ul>
								</div>
								<!--购买按钮-->
								<ul class="btn-wrap clearfix" id="buyBtnBox">
									<li>
										<a id="buyOrNotice" class="but but-primary but-biglarge proBuyBtn" data-type="common" onclick=""></a>
									</li>
								</ul>
								<div class="pro-policy" id="policy">
									<a>
										<span class="support">
											<i class="fa fa-info"></i>
											<em>7天无理由退货</em>
										</span>
										<span class="support">
											<i class="fa fa-info"></i>
											<em>15天换货</em>
										</span>
										<span class="support">
											<i class="fa fa-info"></i>
											<em>365天保修</em>
										</span>
									</a>								
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--特别说明-->
				<div class="infor-con">
					<div class="section is-visible preload">
						<div class="page-container">
							<h3>特别说明</h3>
							<div class="con">
								<img src="../images/dbcd8c4fa60093939c2dfffe62428535_aaee9db8790426631abc3b76fa3da617.jpg"/>
							</div>
						</div>
					</div>
					<div class="section is-visible preload">
						<div class="page-container">
							<h3>官方微信  </h3>
							<div class="con">
								<img src="../images/d1ba7e773402c9b145587ccca967f7fa_1a84b2b629512205bf528aae91361efb.jpg"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--领取优惠券-->
		<div class="modal fade modal-coupon modal-hide in" id="couponModal" style="display: none;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
			</button>
			<div class="modal-body">
				<div class="list">
					<h3 style="margin: 0; padding: 0; text-align: center; font-size: 30px; color:#424242">领取优惠券</h3>
					<p class="tips" style="line-height: 20px;"></p>
					<div class="con">
						<ul>
							<li>
								<div class="coupon-price">
									
									
								</div>
								<div class="coupon-con">
									<p class="coupon-txt" style="line-height: 20px; margin: 0;">
										使用范围：
										<span></span>
									</p>
									<p class="coupon-time">有效时间：</p>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--到货通知提醒设置-->
		<div class="modal fade modal-hide modal-setRemind in" id="modalNoticeArrival" style="display: none;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
			</button>
			<div class="modal-body" style="max-height: 400px; padding: 40px 60px;">
				<h4 id="#isSetted" style="margin: 10px 0 20px; font-size: 30px; font-weight: normal; color: #ff6700;text-align: center;"></h4>
				<p style="margin: 1em 0;"></p>
				<div>
					<a class="but btn-primary known" data-dismiss="modal" style="width: 158px; height: 38px; background: #ff6700; border-color: #ff6700; font-size: 14px; line-height: 38px; margin-left: 61px;">我知道了</a>
				</div>
			</div>
		</div>
	</body>
</html>
