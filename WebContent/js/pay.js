$(document).ready(function(){
	$(".weixin,.zfb,.yinlian,.xiaomi").click(function(){
		$("#mask").css({
			display: 'block',
  			height: $(document).height()
		})
		$(".weixin-pay").css("display","block");
	})
	
	$(".close").click(function(){
		$(".weixin-pay").css("display","none");
		$("#mask").css("display","none");
	})
	
	$("#showDetail").click(function(){
		$(".post-info").toggleClass("post-info-hide");
		$(".order-detail").slideToggle(500);
	})
	
	$("#submitButton").click(function(){
		$("form").submit();
	})
})

$(document).ready(function(){
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
});
