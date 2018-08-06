$(document).ready(function(){
	//选择配送时间样式变化
	var allButtons = $("#deliveryTime li");
	$(allButtons[0]).on('click',function(event){
		$("#deliveryTime li").removeClass("selected");
		$(this).addClass("selected");
	});
	$(allButtons[1]).on('click',function(event){
		$("#deliveryTime li").removeClass("selected");
		$(this).addClass("selected");
	});
	$(allButtons[2]).on('click',function(event){
		$("#deliveryTime li").removeClass("selected");
		$(this).addClass("selected");
	});
	
	//选择地址样式变化
	$(".address-item").click(function(){
		$(".address-item").removeClass("selected");
		$(this).addClass("selected");
	});
	
	$("#eInvoice").click(function(){
		$("#pInvoice").removeClass("selected");
		$(this).addClass("selected");
		$("#pInvoiceTip").hide();
		$("#eInvoiceTip").show();
		$("#eInvoicePhone").show();
		$("#eInvoiceEmail").show();
	});
	
	$("#pInvoice").click(function(){
		$("#eInvoice").removeClass("selected");
		$(this).addClass("selected");
		$("#eInvoiceTip").hide();
		$("#pInvoiceTip").show();
		$("#eInvoicePhone").hide();
		$("#eInvoiceEmail").hide();
	});
	
	$("#personInvoice").click(function(){
		$("#companyInvoice").removeClass("selected");
		$(this).addClass("selected");
		$("#taxBlock").hide();
	});
	
	$("#companyInvoice").click(function(){
		$("#personInvoice").removeClass("selected");
		$(this).addClass("selected");
		$("#taxBlock").show();
	});
	
	$("#invoice-close").click(function(){
		$(".invoice-box").hide();
		$("#mask").hide();
	});
	
	$("#updateInvoice").click(function(){
		$(".invoice-box").show();
		$("#mask").show();
		$("#mask").css({
  			height: $(document).height()
		})
	});
	
	$("#cancel-invoice").click(function(){
		$(".invoice-box").hide();
		$("#mask").hide();
	});
	
	$("#save-invoice").click(function(){
		$(".invoice-box").hide();
		$("#mask").hide();
	});
	
	$(".theCoupon").click(function(){
		$(".theCoupon").removeClass("selected");
		$(this).addClass("selected");
	});
	
	$("#useCoupon").click(function(){
		$(".coupon-box").hide();
	})
	
	$("#noUseCoupon").click(function(){
		$(".coupon-box").hide();
		$(".theCoupon").removeClass("selected");
		
	})
	
	$("#chooseCoupon").click(function(){
		$(".coupon-box").show();
	})
	
	$("#close-address").click(function(){
		$(".edit-address").hide();
		$("#mask").hide();
	})
	
	$("#save-addresee").click(function(){
		$(".edit-address").hide();
		$("#mask").hide();
	})
	
	$("#cancel-address").click(function(){
		$(".edit-address").hide();
		$("#mask").hide();
	})
	
	$("#add-new-address").click(function(){
		$(".edit-address").show();
		$("#mask").show();
		$("#mask").css({
  			height: $(document).height()
		})
	})
});

