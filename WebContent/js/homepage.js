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
		url:"mi/load.action",
		success:function(data){
			console.log(data);
//			$("#J_miniCartMenu").append(str);
			$(".cart-mini-num").html("&nbsp;("+data[0].totalCartQuantity+") ");
			//images/T1bXKjBQAT1RXrhCrK.jpg 彩虹7号电池（10粒装）无汞无镉 环保电池
//			console.log((data[1].groupProduct)[0].product.productName);
			var str="<div class='goods-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
				+"<img src='"+ data[1].groupProduct[0].product.piUrl +"' width='160px' height='160px'></div>"
				+"<h3 class='title'><a>"+data[1].groupProduct[0].product.productName+"</a></h3><p class='desc'>"+data[1].groupProduct[0].product.description+"</p>"
				+"<p class='price'><span>"+data[1].groupProduct[0].groupProductPrice+"</span>&nbsp;<span>元</span><del>"
				+data[1].groupProduct[0].product.productPrice+"</del></p></div></div>";
			$("#addGoodItem").append(str);
			console.log("finish!")
		},
	});
}


$(document).ready(function(){
	/*shopping cart*/
	$("#J_miniCartTrigger").mouseover(function(){
		$("#J_miniCartTrigger").addClass("topbar-cart-active");
		$("#J_miniCartMenu").slideDown();
		$("#J_miniCartMenu").css("display","flex");
		
	});
	$("#J_miniCartTrigger").mouseout(function(){
		$("#J_miniCartMenu").hide();
		$("#J_miniCartTrigger").removeClass("topbar-cart-active");
	});
	$("#J_miniCartMenu").mouseover(function(){
		$("#J_miniCartTrigger").addClass("topbar-cart-active");
		$("#J_miniCartMenu").css("display","flex");
	});
	$("#J_miniCartMenu").mouseout(function(){
		$("#J_miniCartMenu").hide();
		$("#J_miniCartTrigger").removeClass("topbar-cart-active");
	});
	
	/* navigator */
	$("#navItem1").hover(function(){
		$("#navItem1>div.header-nav-menu").slideDown();
	},function(){
		$("#navItem1>div.header-nav-menu").slideUp();
	});
	
	/* category-item */
	$("#category-item1").mouseover(function(){
		$("#category-item1").addClass("category-item-active");
		$("#category-item1>div.children").css("display","flex");
	});
	$("#category-item1").mouseout(function(){
		$("#category-item1").removeClass("category-item-active");
		$("#category-item1>div.children").css("display","none");
	});
	
	
});