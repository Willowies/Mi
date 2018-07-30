$(function(){
	initData();
});
/* initiate data */
function initData(){
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/load_cart.action",
		success:function(data){
			console.log(data);
//			$("#J_miniCartMenu").append(str);
			$(".cart-mini-num").html("&nbsp;("+data+") ");
			console.log("Load finish--shopping cart number");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/load_gp.action",
		success:function(data){
			console.log(data);
			//images/T1bXKjBQAT1RXrhCrK.jpg 彩虹7号电池（10粒装）无汞无镉 环保电池
			for(var i=0;i<data.length;i++){
				var str="<div class='goods-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
					+"<img src='"+ data[i].productId.picUrl +"' width='160px' height='160px'></div>"
					+"<h3 class='title'><a>"+data[i].productId.productName+"</a></h3><p class='desc'>"+data[i].productId.description+"</p>"
					+"<p class='price'><span>"+data[i].groupPrice+"</span>&nbsp;<span>元&nbsp;</span><del>"
					+data[i].productId.productPrice+"元</del></p></div></div>";
				$("#addGoodItem").append(str);
			}
			console.log("Load finish--groupproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/load_phone.action",
		success:function(data){
			console.log(data);
			for(var i=0;i<data.length;i++){
				var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
					+"<img src='"+data[i].picUrl + "' width='160px' height='160px'>"
					+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='desc'>"+data[i].description
					+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p></div></div>";
				$(".phoneInfo").append(str);
			}
			console.log("Load finish--phoneproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/load_popularAppliance.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
//			for(var i=0;i<data.length;i++){
//				var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
//					+"<img src='"+data[i].picUrl + "' width='150px' height='150px'>"
//					+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='desc'>"+data[i].description
//					+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p></div></div>";
//				$(".elecInfo").append(str);
//			}
			console.log("Load finish--popular applianceproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/load_appliance.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				if(data[i].secondClassId==1){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<img src='"+data[i].picUrl + "' width='150px' height='150px'>"
						+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='desc'>"+data[i].description
						+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p></div></div>";
					$(".elecInfo").append(str);
				}
				if(data[i].secondClassId==2){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<img src='"+data[i].picUrl + "' width='150px' height='150px'>"
						+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='desc'>"+data[i].description
						+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p></div></div>";
					$(".elecInfo").append(str);
				}
			}
			console.log("Load finish--applianceproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/load_popularCollocation.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
//			for(var i=0;i<data.length;i++){
//				var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
//					+"<img src='"+data[i].picUrl + "' width='150px' height='150px'>"
//					+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='price'>"
//					+"<span>"+data[i].productPrice+"元</span></p><p class='rank'>";
//				if(data[i].productCommentNum!=0){
//					str = str+data[i].productCommentNum+"人评价</p><div class='review-wrapper'></div></div></div></div>";
//				}else{
//					str = str+"</p><div class='review-wrapper'></div></div></div></div>";
//				}
//				$(".accessoryInfo").append(str);
//			}
			console.log("Load finish--popular collocationproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/load_collocation.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				if(data[i].secondClassId==1){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<img src='"+data[i].picUrl + "' width='150px' height='150px'>"
						+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='price'>"
						+"<span>"+data[i].productPrice+"元</span></p><p class='rank'>";
					if(data[i].productCommentNum!=0){
						str = str+data[i].productCommentNum+"人评价</p><div class='review-wrapper'></div></div></div></div>";
					}else{
						str = str+"</p><div class='review-wrapper'></div></div></div></div>";
					}
					$(".accessoryInfo").append(str);
				}
				if(data[i].secondClassId==2){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<img src='"+data[i].picUrl + "' width='150px' height='150px'>"
						+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='price'>"
						+"<span>"+data[i].productPrice+"元</span></p><p class='rank'>"
						if(data[i].productCommentNum!=0){
							str = str+data[i].productCommentNum+"人评价</p><div class='review-wrapper'></div></div></div></div>";
						}else{
							str = str+"</p><div class='review-wrapper'></div></div></div></div>";
						}
					$(".accessoryInfo").append(str);
				}
			}
			console.log("Load finish--collocationproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/load_recommend.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				var str="<div class='goods-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
					+"<img src='"+data[i].picUrl + "' width='140px' height='140px'>"
					+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='price'>"
					+"<span>"+data[i].productPrice+"元</span></p><p class='rank'>";
				if(data[i].productCommentNum!=0){
					str = str+data[i].productCommentNum+"人评价</p></div></div></div>";
				}else{
					str = str+"</p></div></div></div>";
				}
				$("#addGoodItemSecond").append(str);
			}
			console.log("Load finish--recommendproduct");
		},
	});
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/load_popular.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				var str="<div class='contentItem'><div class='picItem'><img src='"
					+data[i].picUrl+"' width='296' height='220' alt='"+data[i].productName
					+"'></div><p class='review'>"+data[i].comment.commentContent+"</p><p class='author'>"
					+"来自于 "+data[i].coupon.user.userName+" 的评价 </p><div class='info'><h3 class='title'>"
					+"<a href='' >"+data[i].productName+"</a></h3><span class='sep'> | </span>"
					+"<p class='price'><span class='num'>"+data[i].productPrice+"</span>元</p></div></div>";
				$(".contentin").append(str);
			}
			console.log("Load finish--popularproduct");
		},
	});
}


$(document).ready(function(){
	/*shopping cart*/
	$("#J_miniCartTrigger").hover(function(){
		$("#J_miniCartTrigger").addClass("topbar-cart-active");
		$("#J_miniCartMenu").slideDown();
		$("#J_miniCartMenu").css("display","flex");
		//insert load.gif
		//get data
		$.ajax({
			type:"POST",
			async:true,
			dataType:"json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url:"mi/load_cartItem.action",
			success:function(data){
				console.log(data);
//				$("#J_miniCartMenu").append(str);
				//delete load.gif
				for(var i=0;i<data.length;i++){
					var str = "<div id='cartItem"+i+"'>"+"<p id='cartItemId"+i+"'>"+data[i].cartItem+"</p>"+"<p>&nbsp;&nbsp;"+data[i].product.picUrl
					+"&nbsp;&nbsp;"+data[i].product.productPrice+" x "
					+data[i].quantity+"&nbsp;&nbsp;"+data[i].amount+"</p>"
					+"<a href='javascript:void(0);' onclick='deleteCartItem"+i+"'()' ><i class='fa fa-close'></i></a></div>";
//					console.log(str);
					$("#J_miniCartMenu").append(str);
				}
				console.log("Get finish--shopping cart items");
			},
		});
	},function(){
		$("#J_miniCartMenu").slideUp();
		//delete load.gif when the data is not loaded out
		$("#J_miniCartMenu").empty();
		$("#J_miniCartTrigger").removeClass("topbar-cart-active");
	});
	
	$("#J_miniCartMenu").hover(function(e){
//		var ev = $(".cart-menu").children()?window.event:e;
//		var v_id = $(ev.target);
//		v_id.css("color","#000");
		$("#J_miniCartMenu i").css("color","#000");
	},function(){
		$("#J_miniCartMenu i").css("color","#b0b0b0");
	});
	
	
	/* navigator */
	$("#navItem1").hover(function(){
		$("#navItem1>div.header-nav-menu").slideDown();
		$.ajax({
			type:"POST",
			async:true,
			data:{
				productName:$("#navItem1").val()
				},
			dataType:"json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url:"mi/getNavmenu.action",
			success:function(data){
//				console.log(data+"delete success");
				console.log("delete finish--shopping cartItem");
			},
		});
	});
	},function(){
		$("#navItem1>div.header-nav-menu").slideUp();
	});
	
	/* category-item */
	$("#category-item1").mouseover(function(){
		$("#category-item1").addClass("category-item-active");
		$("#category-item1>div.children").css("display","flex");
	$("#category-item1").mouseout(function(){
		$("#category-item1").removeClass("category-item-active");
		$("#category-item1>div.children").css("display","none");
	});
	
});

function deleteCartItem0(){
	$("#cartItem0").remove();
	$.ajax({
		type:"POST",
		async:true,
		data:{
			cartItemId:$("#cartItemId0").html()
			},
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"mi/deleteCartItem.action",
		success:function(data){
//			console.log(data+"delete success");
			console.log("delete finish--shopping cartItem");
		},
	});
}

