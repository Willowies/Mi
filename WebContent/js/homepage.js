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
		url:"mi/load_appliance.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				if(data[i].secondClassId==1){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<img src='"+data[i].picUrl + "' width='160px' height='160px'>"
						+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='desc'>"+data[i].description
						+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p></div></div>";
					$(".elecInfo").append(str);
				}
				if(data[i].secondClassId==2){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<img src='"+data[i].picUrl + "' width='160px' height='160px'>"
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
		url:"mi/load_collocation.action",
		success:function(data){
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				if(data[i].secondClassId==1){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<img src='"+data[i].picUrl + "' width='160px' height='160px'>"
						+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='desc'>"+data[i].description
						+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p></div></div>";
					$(".accessoryInfo").append(str);
				}
				if(data[i].secondClassId==2){
					var str="<div class='phoneInfo-item'><a href='' target='_blank'></a><div class='inner'><div class='inner-img'>"
						+"<img src='"+data[i].picUrl + "' width='160px' height='160px'>"
						+"</div><h3 class='titleP'><a>"+data[i].productName+"</a></h3><p class='desc'>"+data[i].description
						+"</p><p class='price'><span>"+data[i].productPrice+"元</span></p></div></div>";
					$(".accessoryInfo").append(str);
				}
			}
			console.log("Load finish--collocationproduct");
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