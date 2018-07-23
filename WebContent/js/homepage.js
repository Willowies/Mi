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