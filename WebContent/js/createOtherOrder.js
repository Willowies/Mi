$(document).ready(function(){
	
	/*$.ajax({
		type:"post",
		async:false,
		url:"getAddress.action",
		success:function(data){
			$("#userAddress").text("");
			 //var jsonData = JSON.parse(data); //jsonData是该下路下的所有区间（json格式） 
		     for (var i = 0; i < data.length; i++) {
		    	   alert(data[i].receiverAddressId);
		    	   alert("数组长度为"+data.length);
		           var addressHtml ="<div class=\"address-item address\"><dl><dt><span class=\"tag\"></span><em class=\"uname\" id=\"aName\">"
		        	   		+data[i].receiverName+"</em></dt><dd class=\"utel\" id=\"aPhone\">"
		        	   		+data[i].receiverPhone+"</dd><dd class=\"uaddress\"><em style=\"font-style:normal;\" id=\"aProvince\">"
		        	   		+data[i].receiverProvince+"</em><em style=\"font-style:normal;\" id=\"aCity\">" 
		        	   		+data[i].receiverCity+"</em><em style=\"font-style:normal;\" id=\"aDistrict\">"
		        	   		+data[i].receiverDistrict+"</em><br /><em style=\"font-style:normal;\" id=\"aAddress\">" 
		        	   		+data[i].address+"</em></dd></dl></div>";
		           $("#userAddress").append(addressHtml);
		     }
		}
	});*/
	
	$("#noLimit").click(function(){
		$("#sPeroid").val(1);
		//alert($("#sPeroid").val());
		$("#deliveryTime li").removeClass("selected");
		$(this).addClass("selected");
	});
	
	$("#workday").click(function(){
		$("#sPeroid").val(2);
		//alert($("#sPeroid").val());
		$("#deliveryTime li").removeClass("selected");
		$(this).addClass("selected");
	});
	
	$("#weekday").click(function(){
		$("#sPeroid").val(3);
		//alert($("#sPeroid").val());
		$("#deliveryTime li").removeClass("selected");
		$(this).addClass("selected");
	});
	
	$("#eInvoice").click(function(){
		$("#iType").val(1);
		//alert($("#iType").val());
		$("#pInvoice").removeClass("selected");
		$(this).addClass("selected");
		$("#pInvoiceTip").hide();
		$("#eInvoiceTip").show();
		$("#eInvoicePhone").show();
		$("#eInvoiceEmail").show();
	});
	
	$("#pInvoice").click(function(){
		$("#iType").val(2);
		//alert($("#iType").val());
		$("#eInvoice").removeClass("selected");
		$(this).addClass("selected");
		$("#eInvoiceTip").hide();
		$("#pInvoiceTip").show();
		$("#eInvoicePhone").hide();
		$("#eInvoiceEmail").hide();
	});
	
	$("#personInvoice").click(function(){
		$("#rType").val(1);
		//alert($("#rType").val());
		$("#companyInvoice").removeClass("selected");
		$(this).addClass("selected");
		$("#taxBlock").hide();
	});
	
	$("#companyInvoice").click(function(){
		$("#rType").val(2);
		//alert($("#rType").val());
		$("#personInvoice").removeClass("selected");
		$(this).addClass("selected");
		$("#taxBlock").show();
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
		$("#iReceiver").val("-1");
		$("#iTaxNum").val(-1);
		$("#iPhone").val("-1");
		$("#iEmail").val("-1");
		$("#rType").val(1);
		$("#iType").val(1);
	});
	
	$("#invoice-close").click(function(){
		$(".invoice-box").hide();
		$("#mask").hide();
	});
	
	$("#save-invoice").click(function(){
		$(".invoice-box").hide();
		$("#mask").hide();
	});
	
	$("#close-address").click(function(){
		$(".edit-address").hide();
		$("#mask").hide();
	})
	
	//选择地址样式变化
	$(".address-item").click(function(){
		$(".address-item").removeClass("selected");
		$(this).addClass("selected");
	});
	
	$("body").on("click",".address",function(){
		$("#rName").val($(this).find("#aName").text());
		$("#rPhone").val($(this).find("#aPhone").text());
		var address = " "+$(this).find("#aProvince").text()+$(this).find("#aCity").text()+$(this).find("#aDistrict").text()+$(this).find("#aAddress").text()
		$("#rAddress").val(address);
		//alert($("#rName").val());
		//alert($("#rPhone").val());
		//alert($("#rAddress").val());
	});
	
	$("#addAddressButton").click(function(){
		$(".edit-address").hide();
		$("#mask").hide();
		$.ajax({
			type:"post",
			async:false,
			contentType: "application/json; charset=utf-8",
		    data:JSON.stringify(getAddressJson()),
			dataType:"json",
			url:"addAddress.action",
			success:function(data){
				$("#userAddress").text("");
				 //var jsonData = JSON.parse(data); //jsonData是该下路下的所有区间（json格式） 
			     for (var i = 0; i < data.length; i++) {
			    	   //alert(data[i].receiverAddressId);
			    	   //alert("数组长度为"+data.length);
			           var addressHtml ="<div class=\"address-item address\"><dl><dt><span class=\"tag\"></span><em class=\"uname\" id=\"aName\">"
			        	   		+data[i].receiverName+"</em></dt><dd class=\"utel\" id=\"aPhone\">"
			        	   		+data[i].receiverPhone+"</dd><dd class=\"uaddress\"><em style=\"font-style:normal;\" id=\"aProvince\">"
			        	   		+data[i].receiverProvince+"</em><em style=\"font-style:normal;\" id=\"aCity\">" 
			        	   		+data[i].receiverCity+"</em><em style=\"font-style:normal;\" id=\"aDistrict\">"
			        	   		+data[i].receiverDistrict+"</em><br /><em style=\"font-style:normal;\" id=\"aAddress\">" 
			        	   		+data[i].address+"</em></dd></dl></div>";
			           $("#userAddress").append(addressHtml);
			     }
			}
		});
		return false;
	});
	
	function getAddressJson(){
		//alert("在获得JSON");
		var addressJson = {
			"receiverName":$("#inputReceiverName").val(),
			"receiverPhone":$("#inputReceiverPhone").val(),
			"receiverProvince":$("#inputReceiverProvince").val(),
			"receiverCity":$("#inputReceiverCity").val(),
			"receiverDistrict":$("#inputReceiverDistrict").val(),
			"address":$("#inputAddress").val(),
			"addressLabel":$("#inputAddressLabel").val()
		};
		return addressJson;
	}
	
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
	
	$("#submitButton").click(function(){
		var ok1 = $("#rName").val() == "" && $.trim($("#rName").val()).length == 0;
		var ok2 = $("#iReceiver").val() == "" && $.trim($("#iReceiver").val()).length == 0;
		var ok3 = $("#iTaxNum").val() == "" && $.trim($("#iTaxNum").val()).length == 0;
		var ok4 = $("#iPhone").val() == "" && $.trim($("#iPhone").val()).length == 0;
		var ok5 = $("#iEmail").val() == "" && $.trim($("#iEmail").val()).length == 0;
		if(ok1){
			//未选择地址
	        alert("地址不能为空！");
	        return false;
		}else{
			//选择了地址
			if(ok2){
				$("#iReceiver").val("-1");
			}
			if(ok3){
				$("#iTaxNum").val(-1);
			}
			if(ok4){
				$("#iPhone").val("-1");
			}
			if(ok5){
				$("#iEmail").val("-1");
			}
			//满足所有条件
			$("form").submit();
		}
	})
});
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