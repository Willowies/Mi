$(function(){
	var checkLogin;//标记是否登录
	$(".link-category").hover(function(){
		$(".site-category").css("display","block");
	},function(){
		$(".site-category").css("display","none");
	});
	$(".site-category").hover(function(){
		$(".site-category").css("display","block");
	},function(){
		$(".site-category").css("display","none");
	});
	//判断登录
	checkLoginState();
	console.log("登录状态"+checkLogin);
	$(".proLoginClose").click(function(){
		$(".login-notic").css("display","none");
	});
	//设置版本及对应价格
	$("#selectVersion li:first").addClass("active");	
	var versionlist = $("#selectVersion").children("li");
	for(var i = 0; i < versionlist.length; i++){
		var price = $(versionlist[i]).find(".productPrice").text();
		//console.log(price);
		$(versionlist[i]).find(".price").text(parseInt(price)+"元");
	}
 	//根据版本刷新颜色	
    selectProductByVersion();
	function selectProductByVersion(){
		var version = $("#selectVersion li.active span.name").text();
		var productName = $("#pro-title").text();
		$.ajax({
			type:"post",
			async:true,
			url:"selectProductColor.action?productName="+productName+"&version="+version,
			success:function(data){
				$("#desc").text(data[0].description);
				var colorHtml = "";
				var imgHtml = "";
				var carouselIndex = "";
				for(var i = 0; i < data.length; i++){
					colorHtml = colorHtml+"<li class=\"but but-biglarge\" ><a id=\"color"+i+"\" >"+data[i].color+"</a></li>"
					imgHtml = imgHtml+"<div id=\"sliderView\" class=\"sliderWrap item\" style=\"width: auto; position: relative;\"><img class=\"slider done\" src=\"../"+data[i].picUrl+"\" style=\"width:560px; height:560px;\"/></div>";
					carouselIndex = carouselIndex+"<li data-target=\"#myCarousel\" data-slide-to=\""+i+"\" class=\"\"></li>";					
					
				}
				$("#selectColor ul").html(colorHtml);
				$(".ui-viewport").html(imgHtml);
				$(".carousel-indicators").html(carouselIndex);
				$("ol.carousel-indicators li:first").addClass("active");
				$(".ui-viewport div:first").addClass("active");
				$("#selectColor ul li:first").addClass("active");
				selectProduct();
				selectProductStock();
				$("#selectColor ul li").click(function(){
					$("#selectColor ul li").removeClass("active");
					$(this).addClass("active");
					selectProduct();
					selectProductStock();
				});
			}		
		});
	}
	//设置选中的参数高亮
	$("#selectVersion li").click(function(){
		$("#selectVersion li").removeClass("active");
		$(this).addClass("active");					
		selectProductByVersion();
	});
	
	
	//根据版本颜色刷新价格
	function selectProduct(){
		var version = $("#selectVersion li.active span.name").text();
		var color = $("#selectColor ul li.active a").text();
		$.ajax({
			type:"post",
			async:true,
			url:"selectProduct.action?productName="+$("#pro-title").text()+"&version="+version+"&color="+color,	
			success:function(data){
				$(".pro-price").text(data.productPrice);
				//更新选中产品信息
				var prolist = data.productName + " "+ data.version + " " + data.color + " " + data.size +"<span>  "+data.productPrice+"元</span><p id=\"productId\" style=\"display:none\">"+data.productId+"</p>";
				$("#totalName").html(prolist);
				$(".totalPrice").text("  总计  ："+data.productPrice+"元 ");
				//显示对应图片
				var imgs = $(".sliderWrap").children();				
				//console.log(imgs);
                for(var i = 0; i < imgs.length; i++){
                	var myUrl = "/"+data.picUrl.substr(data.picUrl.lastIndexOf("/")+1);
                	var url = $(imgs[i]).attr("src");
                	url = url.substr(url.lastIndexOf("/"));
            		//console.log(myUrl+" "+url);
					if(myUrl == url){
						$(imgs[i]).parent().addClass("active");
					}else{
						$(imgs[i]).parent().removeClass("active");
					}
				}
			}
	    });	
	}
	//获取选中的参数发送至后台返回库存信息
	function selectProductStock(){
		//alert("stock");
		var version = $("#selectVersion li.active span.name").text();
		var color = $("#selectColor ul li.active a").text();
		$.ajax({
				type:"post",
				async:true,
				dataType:"text",
				url:"selectProductStock.action?productName="+$("#pro-title").text()+"&version="+version+"&color="+color,	
				success:function(data){
					console.log("库存信息:"+data);
					if(data == "有货"){
						//alert("有货");
						$("span.sale").css("display","inline-block");
						$("span.over").css("display","none");
						$("#buyOrNotice").text("加入购物车");
					}
					if(data == "暂时缺货"){
						$("span.over").css("display","inline-block");
						$("span.sale").css("display","none");
						$("#buyOrNotice").text("到货通知");
						$("#buyOrNotice").addClass("setRemind");
						$("#buyOrNotice").removeClass("proBuyBtn");
						$("#buyOrNotice").css({"border-color":"#ff6700","background":"#ff6700","color":"rgb(255, 103, 0)"});
					}
				}		        
		});
	}
	//设置到货通知		
		$("#buyOrNotice").click(function(){
			//checkLoginState();//判断登录
			var notice = $("#buyOrNotice").text();
			alert(notice);
			if(notice == "到货通知"){
				if(checkLogin == "true"){
					//已登录
					var version = $("#selectVersion li.active span.name").text();
					var color = $("#selectColor ul li.active a").text();
					$.ajax({
						type:"post",
						async:true,
						dataType:"text",
						url:"noticeArrival.action?productName="+$("#pro-title").text()+"&version="+version+"&color="+color,
						success:function(data){
							$("#modalNoticeArrival").modal("show");
							//console.log($("h4.isSetted").length);
							$("h4.isSetted").text(data);
							$("a.known").click(function(){
								$("#buyOrNotice").css({"pointer-events":"none","opacity":"0.4"});
								$("#buyOrNotice").text("已设置到货通知");
							});											
						}
					});
				}else{
					//未登录
					window.location.href = "login.jsp";
				}
			}

						
		});
	//领取优惠券
	$("body").on("click",".getCoupon",function(){
		checkLoginState();//判断登录
		if(checkLogin == "true"){
			//已登录
			var couponId = $(this).parent().find(".couponId").text();
			var discount = $(this).parent().find(".couponDiscount").text();
			var range = $(this).parent().find(".couponName").text().split(" ");
			var couponRange = range[0]+" "+range[1];
			var startDate = $(this).parent().find(".startDate").text();
			var endDate = $(this).parent().find(".endDate").text();
			startDate = new Date(startDate);		
			endDate = new Date(endDate);
			var start = startDate.getFullYear() + "-" +((startDate.getMonth()+1)<10?"0":"")+(startDate.getMonth()+1)+"-"+(startDate.getDate()<10?"0":"")+startDate.getDate();
			var end = endDate.getFullYear() + "-" +((endDate.getMonth()+1)<10?"0":"")+(endDate.getMonth()+1)+"-"+(endDate.getDate()<10?"0":"")+endDate.getDate();
			$.ajax({
				type:"post",
				async:true,
				dataType:"text",
				url:"receiveCoupon.action?couponId="+couponId,
				success:function(data){
					$("#couponModal").modal("show");
					$("p.tips").text(data);					
					$(".coupon-txt span").text("适用于"+couponRange);
					$(".coupon-price").html("<sup>￥</sup>"+discount);
					$(".coupon-time").text("有效时间："+start+"-"+end);
				}
				
			});
		}else{
			//未登录
			window.location.href = "login.jsp";
		}		
				
	});
	
	//购买商品

	$("#buyOrNotice").click(function(){
		var notice = $("#buyOrNotice").text();
		if(notice == "加入购物车"){
			var productName = $("#pro-title").text();
			//alert("商品名称"+productName);
			//判断登录
			checkLoginState();
			if(checkLogin == "true"){
				//已登录 进行购买
				window.location.href = "addCartItem.action?productIdString="+$("#productId").text()+"&productName="+productName;
			}else{
				//未登录 跳转到登录界面
				window.location.href = "login.jsp";
			}
		}
	});
	
	//设置图片滚动样式
	var offset = $("#img").offset();
	$(window).scroll(function(){
		var scrollTop = $(window).scrollTop();
		var diffTop = $("#buyBox").offset().top;
		var addrTop = $("#userDefaultAddress").offset().top;
		if(scrollTop >= diffTop){
			$("#img").addClass("fix");
			if(scrollTop >= addrTop){
				$("#img").removeClass("fix");
				$("#img").css("margin-top","250px");
			}else{
				$("#img").addClass("fix");
				$("#img").css("margin-top","0px");
			}
		}else{
			$("#img").removeClass("fix");
		}
	});

	
	//判断登录
	function checkLoginState(){
		//alert("检查登录");
		$.ajax({
			type:"post",
			async:false,
			dataType:"text",
			url:"checkLoginState.action",
			success:function(data){
				//alert("判断登录内部ajax"+data);
				checkLogin = data;
				if(checkLogin == "true"){					
					$(".login-notic").css("display","none");
				}
			}
		});
	    //alert("判断登录内部"+checkLogin);
		
	}
});