$(function(){
	initData();
});
/* initiate data */
function initData(){
	$.ajax({
		type:"POST",
		async:false,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"checkLoginState2.action",
		success:function(data){
			console.log(data);
			if(data.userId!=0){
				var str = "<span class='user'><a class='username'>"
						+"<span class='name'>"+data.userName+" </span>"
						+"<i class='fa fa-angle-down fa-lg'></i></a><ul class='user-menu' style='display:none;'>"
						+"<li><a href='disPlayMyPersonalCenter.action'>个人中心</a></li><li><a href='getWaitCommentProduct.action'>评价晒单</a></li><li><a href='displayLikeProduct.action'>我的喜欢</a></li>"
						+"<li><a href='selectUser.jsp'>小米账户</a></li><li><a onclick='quitLogin()'>退出登录</a></li></ul></span><span class='sep'>|</span>"
						+"<span class='message'><a rel='nofollow' href='displayMessage.action'>消息通知</a></span><span class='sep'>|</span>"
						+"<a rel='nofollow' href='getAllOrder.action' class='myOrder'>我的订单</a>";
				$(".topbar-info").append(str);
				//for groupPurchase.jsp
				sessionStorage.setItem("user_login","true");
				$(".cart-mini").attr("href","findCartItem.action");
				console.log("Has logged in!");
			}
			if(data.userId==0){
				var str = "<a rel='nofollow' class='link' href='login.jsp' >登录</a><span class='sep'>|</span><a rel='nofollow' class='link' href='addUser.jsp' >注册</a>"
					+"<span class='sep'>|</span><span class='message'><a rel='nofollow' href='login.jsp'>消息通知</a></span>";
				$(".topbar-info").append(str);
				sessionStorage.setItem("user_login","false");
				$(".cart-mini").attr("href","javascript:void(0)");
				console.log("Has not logged in!");
			}
			console.log("Check login state finished--shopping cart number");
		},
	});
	$(".user").hover(function(){
		$(".username").css("background","#fff");
		$(".user-menu").css("display","block");
	},function(){
		$(".username").css("background","#333");
		$(".user-menu").css("display","none");
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_cart.action",
		success:function(data){
			console.log(data);
//			$("#J_miniCartMenu").append(str);
			$(".cart-mini-num").html("（"+data+"）");
			console.log("Load finished--shopping cart number");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_gp.action",
		success:function(data){
			console.log(data);
			//images/T1bXKjBQAT1RXrhCrK.jpg 彩虹7号电池（10粒装）无汞无镉 环保电池
			for(var i=0;i<data.length;i++){
				var str="<div class='goods-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
					+"<a href='groupPurchase.jsp' style='height:160px; display:block;'><img src='../"+ data[i].product.picUrl +"' width='160px' height='160px'></div>"
					+"<h3 class='title'><a href='groupPurchase.jsp'>"+data[i].product.extremeName+"</a></h3><p class='desc'>"+data[i].product.description+"</p>"
					+"<p class='price'><span>"+data[i].groupPrice+"</span>&nbsp;<span>元&nbsp;</span><del style='color:#b0b0b0;'>"
					+data[i].product.productPrice+"元</del></p></div></div>";
				$("#addGoodItem").append(str);
			}
			console.log("Load finished--groupproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_phone.action",
		success:function(data){
			console.log(data);
			for(var i=0;i<data.length;i++){
				var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
					+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='160px' height='160px'></a>"
					+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='desc'>"+data[i].description
					+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p></div></div>";
				$(".phoneInfo").append(str);
			}
			//浮动特效
			$(".phoneInfo div.phoneInfo-item").hover(function(){
				$(this).addClass("brick-item-active");
			},function(){
				$(this).removeClass("brick-item-active");
			});
			console.log("Load finished--phoneproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_popularAppliance.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
					+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='150px' height='150px'></a>"
					+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='desc'>"+data[i].description
					+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"+data[i].comment.commentContent+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div>";
				$(".elecInfo").children("div").eq(0).append(str);
			}
			//浮动特效
			$(".elecInfo .elecInfoEle div.phoneInfo-item").hover(function(){
				$(this).addClass("brick-item-active");
			},function(){
				$(this).removeClass("brick-item-active");
			});
			console.log("Load finished--popular applianceproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_appliance.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				if(data[i].secondClassId==3){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='150px' height='150px'></a>"
						+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='desc'>"+data[i].description
						+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p>"
						+"<div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"+data[i].comment.commentContent+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div>";
					$(".elecInfo").children("div").eq(1).append(str);
				}
				if(data[i].secondClassId==4){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='150px' height='150px'></a>"
						+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='desc'>"+data[i].description
						+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"
						+data[i].comment.commentContent+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div>";
					$(".elecInfo").children("div").eq(2).append(str);
				}
				if(data[i].secondClassId==5){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='150px' height='150px'></a>"
						+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='desc'>"+data[i].description
						+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"
						+data[i].comment.commentContent+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div>";
					$(".elecInfo").children("div").eq(3).append(str);
				}
			}
			//浮动特效
			$(".elecInfo .elecInfoEle div.phoneInfo-item").hover(function(){
				$(this).addClass("brick-item-active");
			},function(){
				$(this).removeClass("brick-item-active");
			});
			console.log("Load finished--applianceproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_popularCollocation.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
					+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='150px' height='150px'></a>"
					+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='price'>"
					+"<span>"+data[i].productPrice+"元</span></p><p class='rank'>";
				if(data[i].productCommentNum!=0){
					str = str+data[i].productCommentNum+"人评价</p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"
					+data[i].comment.commentContent+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div></div>";
				}else{
					str = str+"</p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"+data[i].comment.commentContent+"</span><span class='author'>来自于 "
					+data[i].comment.userId+" 的评价</span></a></div></div></div></div>";
				}
				$(".accessoryInfo").children("div").eq(0).append(str);
			}
			//浮动特效
			$(".accessoryInfo .elecInfoEle div.phoneInfo-item").hover(function(){
				$(this).addClass("brick-item-active");
			},function(){
				$(this).removeClass("brick-item-active");
			});
			console.log("Load finished--popular collocationproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_collocation.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				if(data[i].secondClassId==6){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='150px' height='150px'></a>"
						+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='price'>"
						+"<span>"+data[i].productPrice+"元</span></p><p class='rank'>";
					if(data[i].productCommentNum!=0){
						str = str+data[i].productCommentNum+"人评价</p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"
						+data[i].comment.commentContent+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div></div>";
					}else{
						str = str+"</p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"+data[i].comment.commentContent
						+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div></div>";
					}
					$(".accessoryInfo").children("div").eq(1).append(str);
				}
				if(data[i].secondClassId==7){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='150px' height='150px'></a>"
						+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='price'>"
						+"<span>"+data[i].productPrice+"元</span></p><p class='rank'>";
					if(data[i].productCommentNum!=0){
						str = str+data[i].productCommentNum+"人评价</p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"
						+data[i].comment.commentContent+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div></div>";
					}else{
						str = str+"</p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"+data[i].comment.commentContent
						+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div></div>";
					}
					$(".accessoryInfo").children("div").eq(2).append(str);
				}
				if(data[i].secondClassId==8){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='150px' height='150px'></a>"
						+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='price'>"
						+"<span>"+data[i].productPrice+"元</span></p><p class='rank'>";
					if(data[i].productCommentNum!=0){
						str = str+data[i].productCommentNum+"人评价</p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"
						+data[i].comment.commentContent+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div></div>";
					}else{
						str = str+"</p><div class='review'><a href='selectProductInfo.action?productName="+data[i].productName+"'><span class='comment'>"+data[i].comment.commentContent
						+"</span><span class='author'>来自于 "+data[i].comment.userId+" 的评价</span></a></div></div></div></div>";
					}
					$(".accessoryInfo").children("div").eq(3).append(str);
				}
			}
			//浮动特效
			$(".accessoryInfo .elecInfoEle div.phoneInfo-item").hover(function(){
				$(this).addClass("brick-item-active");
			},function(){
				$(this).removeClass("brick-item-active");
			});
			console.log("Load finished--collocationproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_recommend.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				var str="<div class='goods-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
					+"<a style='display:inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"+data[i].picUrl + "' width='140px' height='140px'></a>"
					+"</div><h3 class='titleP'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"+data[i].extremeName+"</a></h3><p class='price'>"
					+"<span>"+data[i].productPrice+"元</span></p><p class='rank'>";
				if(data[i].productCommentNum!=0){
					str = str+data[i].productCommentNum+"人好评</p></div></div></div>";
				}else{
					str = str+"</p></div></div></div>";
				}
				$("#addGoodItemSecond").append(str);
			}
			//浮动特效
			$("#addGoodItemSecond div.goods-item").hover(function(){
				$(this).addClass("brick-item-active");
			},function(){
				$(this).removeClass("brick-item-active");
			});
			console.log("Load finished--recommendproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_popular.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				var str="<div class='contentItem'><div class='picItem'><a style='inline-block;' href='selectProductInfo.action?productName="+data[i].productName+"'><img src='../"
					+data[i].picUrl+"' width='296' height='220' alt='"+data[i].productName
					+"'></a></div><a  href='selectProductInfo.action?productName="+data[i].productName+"'><p class='reviewHot'>"+data[i].comment.commentContent+"</p></a><p class='author'>"
					+"来自于 "+data[i].coupon.user.userName+" 的评价 </p><div class='info'><h3 class='title'>"
					+"<a  href='selectProductInfo.action?productName="+data[i].productName+"' >"+data[i].productName+"</a></h3><span class='sep'> | </span>"
					+"<p class='price'><span class='num'>"+data[i].productPrice+"</span>元</p></div></div>";
				$(".contentin").append(str);
			}
			
			//浮动特效——热评产品
			$(".contentin div.contentItem").hover(function(){
				$(this).addClass("brick-item-active");
			},function(){
				$(this).removeClass("brick-item-active");
			});
			console.log("Load finished--popularproduct");
		},
	});
	
}
//一定要放在init和docuemnt外面才能被onclick调用到
function quitLogin(){
	$.ajax({
		type:"POST",
		async:false,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"quitLogin.action",
		success:function(data){
			if(data==1){
				console.log("Quit!!!!!!");
			}
			window.location.href="homepage.jsp";
		},
	});
}
$(document).ready(function(){
	/*shopping cart*/
	$("#J_miniCartTrigger").hover(function(){
		$("#J_miniCartTrigger").addClass("topbar-cart-active");
		$("#J_miniCartMenu").stop(true,false).slideDown(500);
		$("#J_miniCartMenu").css("display","flex");
		
		//insert load.gif
		//get data
		$.ajax({
			type:"POST",
			async:true,
			dataType:"json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url:"load_cartItem.action",
			success:function(data){
				console.log(data);
//				$("#J_miniCartMenu").append(str);
				//delete load.gif
				var str="<ul class='cartList'></ul>";
				$("#J_miniCartMenu").append(str);
				var totalQuantity=0;
				var totalAmount=0;
				for(var i=0;i<data.length;i++){
					var cartItem="<li><div class='cartItem'><a class='cartItemId' style='visibility:hidden;width:0px;'>"+data[i].cartItem+"</a>"
						+"<a href='' class='image'><img src='../"
						+data[i].product.picUrl+"' width='60' height='60'></a><a href='' class='name'>"
						+data[i].product.extremeName+"</a><span class='price'>"
						+data[i].product.productPrice+"元 x "+data[i].quantity
						+"</span><a class='delete' style='display:none'><i class='fa fa-close'></i></a></div></li>";
					$("#J_miniCartMenu").children().append(cartItem);
					totalQuantity+=data[i].quantity;
					totalAmount+=data[i].amount;
				}
				$("div.cartItem:first").css("border-top","0");
				var total = "<div class='clear'><span class='total'><span>共"
					+totalQuantity+"件商品</span><span style='color:#ff6700;'><strong class='totalPrice'>"
					+totalAmount+"</strong>元</span></span><a class='clearBtn' href=''>去购物车结算</a></div>";
				$("#J_miniCartMenu").append(total);
				$(".cart-mini-num").html("（"+totalQuantity+"）");
				console.log("Get finished--shopping cart items");
				
				$("div.cartItem").hover(function(e){
					var cartItem = $(this);
					var cartItemLength = $("div.cartItem").length; 
					cartItem.children("a.name").css("color","#ff6700");
					cartItem.children("a.delete").css("display","block");
					
					cartItem.children("a.delete").click(function(){
						var cartItemId = cartItem.children("a.cartItemId");
						
//						console.log("log  cartItemId:"+cartItemId.text());
						cartItem.parent().remove();
						$.ajax({
							type:"POST",
							async:true, 
							data:{
								cartItemId:cartItemId.text()
								},
							dataType:"json",
							contentType: "application/x-www-form-urlencoded; charset=utf-8", 
							url:"deleteCartItem.action",
							success:function(data){
								console.log("delete success");
								console.log("delete finished--shopping cartItem");
							},
						});
						$(".cart-mini-num").html("（"+(cartItemLength-1)+"）");
						if(cartItemLength==1){
							$("#J_miniCartMenu").empty();
							$("#J_miniCartMenu").slideUp();
							$("#J_miniCartTrigger").removeClass("topbar-cart-active");
						}
					});
					e.stopPropagation();
				},function(e){
					$(this).children("a.name").css("color","#333");
					$(this).children("a.delete").css("display","none");
					e.stopPropagation();
				});
			},
		});
	},function(){
		$("#J_miniCartMenu").stop(true,false).slideUp(500);
		//delete load.gif when the data is not loaded out
		$("#J_miniCartMenu").empty();
		$("#J_miniCartTrigger").removeClass("topbar-cart-active");
	});
	
	/* navigator */
	$("ul.nav-list li.nav-item").hover(function(){
//		console.log($(this).text());
		var _this = $(this).children().children().children();//children-list
		$.ajax({
			type:"POST",
			async:true,
			data:{
				navColumnName:$(this).text()
				},
			dataType:"json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url:"getNavmenu.action",
			success:function(data){
				console.log(data);
				for(var i=0;i<data.length;i++){
					var str = "<li class='first'><div class='figure figure-thumb'><a href='selectProductInfo.action?productName="+data[i].productName+"'>"
						+"<img src='../"+data[i].picUrl+"' alt='"+data[i].productName+"' width='160' height='110'>"
						+"</a></div><div class='title'><a href='selectProductInfo.action?productName="+data[i].productName+"' >"+data[i].productName+"</a></div>"
				        +"<p class='price'>"+data[i].productPrice+"起</p></li>";
					_this.append(str);
				}
				console.log("get Navmenu finished--nav product ");
			},
		});
		$(this).children().stop(true,false).slideDown(500);
	},function(){
		$(this).children().stop(true,false).slideUp(500);
		$(this).children().children().children().empty();
	});
	/* category-item */
	$("ul#J_categoryList li").hover(function(){
		$(this).addClass("category-item-active");
		$(this).children("div.children").css("display","flex");
		var _this = $(this).children("div.children");
//		console.log($(this).children("a.title").text());
		$.ajax({
			type:"POST",
			async:true,
			data:{
				categoryItemName:$(this).children("a.title").text()
				},
			dataType:"json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url:"getCategorymenu.action",
			success:function(data){
				console.log(data);
				for(var i=0;i<data.length;i++){
					var str="<div class='childrenItem'><a class='link' href='selectProductInfo.action?productName="+data[i].productName+"'>"
						+"<img alt='"+data[i].productName+"' src='../"+data[i].picUrl+"' width='40' height='40' style='float:left;'><span class='text1'>"
						+data[i].productName+"</span></a></div>";
					_this.append(str);
				}
				console.log("get Categorymenu finished--category menu product");
			},
		});
	},function(){
		$(this).removeClass("category-item-active");
		$(this).children("div.children").css("display","none");
		$(this).children("div.children").empty();
	});
	/* cartItem delete */
	$("div.cartItem").hover(function(){
		var cartItem = $(this);
		$(this).children("a.name").css("color","#ff6700");
		$(this).children("a.delete").css("display","block");
	},function(){
		$(this).children("a.name").css("color","#333");
		$(this).children("a.delete").css("display","none");
	});
	
	/*
	 * switch groupproduct, next previous
	 */
	$(".moreNext").click(function(){
		$("#addGoodItem").css("margin-left","-1240px");
		$(this).css("pointer-events","none");
		$(".morePre").css("pointer-events","auto");
	});
	$(".morePre").click(function(){
		$("#addGoodItem").css("margin-left","0px");
		$(this).css("pointer-events","none");
		$(".moreNext").css("pointer-events","auto");
	});
	$(".moreNextSecond").click(function(){
		$("#addGoodItemSecond").css("margin-left","-1240px");
		$(this).css("pointer-events","none");
		$(".morePreSecond").css("pointer-events","auto");
	});
	$(".morePreSecond").click(function(){
		$("#addGoodItemSecond").css("margin-left","0px");
		$(this).css("pointer-events","none");
		$(".moreNextSecond").css("pointer-events","auto");
	});
	//查看更多
	$(".watchMore").hover(function(){
		$(this).css("color","#ff6700");
		$(this).children().css("color","#ff6700");
	},function(){
		$(this).css("color","#424242");
		$(this).children().css("color","#b0b0b0");
	});
	//切换特效——配件
	$(".switchmore ul li").hover(function(){
		$(this).addClass("tab-active");
		var index = $(this).index();
//		console.log("index+"+index);
		$(".elecInfo").children("div").eq(index).css("display","flex");
		for(var i=0;i<4;i++){
			if(i!=index){
				$(".elecInfo").children("div").eq(i).css("display","none");
				$(".switchmore ul").children("li").eq(i).removeClass("tab-active");
			}
		}
	},function(){
	});
	//切换特效——配件
	$(".switchmoreA ul li").hover(function(){
		$(this).addClass("tab-active");
		var index = $(this).index();
//		console.log("index+"+index);
		$(".accessoryInfo").children("div").eq(index).css("display","flex");
		for(var i=0;i<4;i++){
			if(i!=index){
				$(".accessoryInfo").children("div").eq(i).css("display","none");
				$(".switchmoreA ul").children("li").eq(i).removeClass("tab-active");
			}
		}
	},function(){
	});
	//浮动特效-img
	$("div.phoneInfo-itemImg").hover(function(){
		$(this).addClass("brick-item-active");
	},function(){
		$(this).removeClass("brick-item-active");
	});
	console.log("Load finished--recommendproduct");
	//轮播
	$(".left").click(function(){
		var length = $("div.carouselimgItem").length;
		var carouselimgItem = $("div.carouselimgItem");//图
		var carouselswitchItem = $("a.imgSwitch");//小圆钮
		var currentImgIndex;
		var nextImgIndex;
//		console.log("length:"+length);
		for(var i=0;i<length;i++){
			if(carouselimgItem.eq(i).css("z-index")==50){
				currentImgIndex = i;
			}
		}
		if(currentImgIndex==0){
			nextImgIndex=4;//确定下一个移动到的元素索引,图片和小圆钮是一样的
		}else{
			nextImgIndex = currentImgIndex - 1;
		}
		//改变图片z-index和display
		carouselimgItem.eq(currentImgIndex).css("z-index","0");
		carouselimgItem.eq(currentImgIndex).css("display","none");
		carouselimgItem.eq(nextImgIndex).css("z-index","50");
		carouselimgItem.eq(nextImgIndex).css("display","block");
		//改变小圆钮的样式
		carouselswitchItem.eq(currentImgIndex).removeClass("active");
		carouselswitchItem.eq(nextImgIndex).addClass("active");
	});
	$(".right").click(function(){
		var length = $("div.carouselimgItem").length;
		var carouselimgItem = $("div.carouselimgItem");//图
		var carouselswitchItem = $("a.imgSwitch");//小圆钮
		var currentImgIndex;
		var nextImgIndex;
//		console.log("length:"+length);
		for(var i=0;i<length;i++){
			if(carouselimgItem.eq(i).css("z-index")==50){
				currentImgIndex = i;
			}
		}
		if(currentImgIndex==4){
			nextImgIndex=0;//确定下一个移动到的元素索引,图片和小圆钮是一样的
		}else{
			nextImgIndex = currentImgIndex + 1;
		}
		//改变图片z-index和display
		carouselimgItem.eq(currentImgIndex).css("z-index","0");
		carouselimgItem.eq(currentImgIndex).css("display","none");
		carouselimgItem.eq(nextImgIndex).css("z-index","50");
		carouselimgItem.eq(nextImgIndex).css("display","block");
		//改变小圆钮的样式
		carouselswitchItem.eq(currentImgIndex).removeClass("active");
		carouselswitchItem.eq(nextImgIndex).addClass("active");
	});
	$("a.imgSwitch").click(function(){
		var nextIndex = $(this).index();//获取点击的索引
		var carouselimgItem = $("div.carouselimgItem");//图
		var carouselswitchItem = $("a.imgSwitch");//小圆钮
		var length = carouselimgItem.length;
		var currentImgIndex;
		//获取当前的索引
		for(var i=0;i<length;i++){
			if(carouselimgItem.eq(i).css("z-index")==50){
				currentImgIndex = i;
			}
		}
		//改变当前索引位置的图和小圆钮
		carouselimgItem.eq(currentImgIndex).css("z-index","0");
		carouselimgItem.eq(currentImgIndex).css("display","none");
		carouselswitchItem.eq(currentImgIndex).removeClass("active");
		//改变下一个索引处的图和小圆钮
		carouselimgItem.eq(nextIndex).css("z-index","50");
		carouselimgItem.eq(nextIndex).css("display","block");
		carouselswitchItem.eq(nextIndex).addClass("active");
	});
	$(".carouselImg").hover(function(){
	  clearInterval(window.timer);
	},function(){
	  window.timer=setInterval(moveAuto,3000);
	});
	function moveAuto(){
		var length = $("div.carouselimgItem").length;
		var carouselimgItem = $("div.carouselimgItem");//图
		var carouselswitchItem = $("a.imgSwitch");//小圆钮
		var currentImgIndex;
		var nextImgIndex;
//		console.log("length:"+length);
		for(var i=0;i<length;i++){
			if(carouselimgItem.eq(i).css("z-index")==50){
				currentImgIndex = i;
			}
		}
		if(currentImgIndex==4){
			nextImgIndex=0;//确定下一个移动到的元素索引,图片和小圆钮是一样的
		}else{
			nextImgIndex = currentImgIndex + 1;
		}
		//改变图片z-index和display
		carouselimgItem.eq(currentImgIndex).css("z-index","0");
		carouselimgItem.eq(currentImgIndex).css("display","none");
		carouselimgItem.eq(nextImgIndex).css("z-index","50");
		carouselimgItem.eq(nextImgIndex).css("display","block");
		//改变小圆钮的样式
		carouselswitchItem.eq(currentImgIndex).removeClass("active");
		carouselswitchItem.eq(nextImgIndex).addClass("active");
	}
	
});



