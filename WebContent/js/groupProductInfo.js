$(function(){
	initData2();
});
/* initiate data */
function initData2(){
	$.ajax({
		type:"POST",
		async:false,
		data:{
//			groupProductId:$("#groupProductId").text()
			groupProductId:getQueryString("groupProductId")
		},
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_groups.action",
		success:function(data){
			console.log(data);
			for(var i=0;i<data.length;i++){
				var str="<div class='groupitem'><span id='groupId"+i+"' style='width:0px; height:0px; visibility:hidden;'>"
					+data[i].groupId+"</span>"+"<p class='num'>"+(i+1)+"</p><div class='info'><p>创建者："+data[i].creator+"</p>"
					+"<p>当前人数："+data[i].groupMember.length+"人 / "+data[i].groupProduct.leastGroupNum+"人</p></div><select class='person'>";
				for(var j=0;j<data[i].groupMember.length;j++){
					str += "<option value='"+data[i].groupMember[j].userName+"'>"+data[i].groupMember[j].userName+"</option>";
				}
				str += "</select><input type='button' id='joinGroup"+i+"' class='joinGroup' value='我要参团'></div>";
				$(".groupList").append(str);
				/*
				 * join in group button
				 */
				var joinGroup = "#joinGroup"+i;
				var groupId = "#groupId"+i;
//				console.log("groupProductId "+$("#groupProductId").text());
//				console.log("groupId "+$(groupId).text());
				$(joinGroup).click(function(){
					provideOrderProduct();//异步
					window.location.href="joinGroup.action?groupProductId="+$("#groupProductId").text()+"&groupId="+$(groupId).text();
				});
			}
			//
			if(data.length!=0){
				/*
				 *  insert groupProduct Info into page
				 */
				$("#groupProductId").text(data[0].groupProduct.groupProductId);
				$(".groupProductName").text(data[0].groupProduct.product.productName);
				$(".groupProductDesc").text(data[0].groupProduct.product.description);
				$(".groupProductPrice").append(data[0].groupProduct.groupPrice+"元"+"&nbsp;<del class='productPrice'></del>");
				$(".productPrice").text(data[0].groupProduct.product.productPrice+"元");
				$(".groupProduct_show").append("<img src='../"+data[0].groupProduct.product.picUrl+"' width='600px' height='600px'  />");
				
				var beforeLocal = new Date();
				var serverDate = getServerDate();
				var serverTime = serverDate.getTime();//server time
				var afterLocal = new Date();
				var countDown = data[0].groupProduct.endDate-serverTime;
				console.log("endDate:"+ data[0].groupProduct.endDate);
				console.log("serverTime:"+ serverTime);
				console.log("serverDate:"+ serverDate);
				console.log("afterLocal:"+afterLocal);
				
				var ajax = afterLocal.getTime()-beforeLocal.getTime();
				console.log("ajax:"+ajax);
				var endTime = afterLocal.getTime()+countDown-ajax;//remove error
				console.log("endTime:"+endTime);
				startCount(endTime);
			}else{
				getSelectedGroupProduct();//没有团，单独获取团购商品信息
				console.log("暂时没有group数据！");
				var str="<div class='groupitem'><p style='width:180px; font-size:20px;color:#b0b0b0;margin:26px auto;'>未查询到任何团信息</p></div>";
				$(".groupList").append(str);
			}
			//
			console.log("Load finish--groups info");
		},
	});

	function getSelectedGroupProduct(){
		$.ajax({
			type:"POST",
			async:false,
			data:{
				groupProductId:getQueryString("groupProductId")
			},
			dataType:"json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url:"getGroupProductById.action",
			success:function(data){
				console.log(data);
				/*
				 *  insert groupProduct Info into page
				 */
				$("#groupProductId").text(data.groupProductId);
				$(".groupProductName").text(data.product.productName);
				$(".groupProductDesc").text(data.product.description);
				$(".groupProductPrice").append(data.groupPrice+"元"+"&nbsp;<del class='productPrice'></del>");
				$(".productPrice").text(data.product.productPrice+"元");
				console.log(data.product.picUrl);
				$(".groupProduct_show").append("<img src='../"+data.product.picUrl+"' width='600px' height='600px'  />");
			},
		});
	}
	/*
	 * parse the argument from url
	 */
	function getQueryString(name) {
	    var result = window.location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
	    if (result == null || result.length < 1) {
	        return "";
	    }
	    return result[1];
	}
}

$(document).ready(function(){
	/*
	 * create group button
	 */
	$("#createGroup").click(function(){
		$.ajax({
			type:"POST",
			async:true,
			data:{
				groupProductId:$("#groupProductId").text()
			},
			dataType:"json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url:"createGroup.action",
			success:function(data){
//				console.log(data);
				if(data==0){
					//can't create
					console.log("Can't create group anymore!");
					alert("团数已达上限，您可以尝试参团！");
				}else{
					console.log("Create finish--product group");
					provideOrderProduct();//异步
					window.location.href="addGroup.action?groupProductId="+$("#groupProductId").text()+"groupId="+data;
				}
			},
		});
	});
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
	
	/*
	 * 参团、开团，提供数据给确认订单。
	 */
	function provideOrderProduct(){
		$.ajax({
			type:"POST",
			async:true,
			data:{
				groupProductId:$("#groupProductId").text()
			},
			dataType:"json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url:"provideOrderProduct.action",
			success:function(data){
			},
		});
	}
	
});

/*
 *COUNT DOWN 
 */
function startCount(endTime) { 
    var countTimer = setInterval( function() { 
        var nowDate = new Date();
        var nowTime = nowDate.getTime();//local current time
        var leftTime = endTime-nowTime;
//        var leftTime = nowTime-endTime;
        if (!isNaN(leftTime) && leftTime >= 0) {
        	var day = Math.floor(leftTime / 1000 / 60 / 60 / 24); 
            var hour = Math.floor(leftTime / 1000 / 60 / 60 % 24); 
            var minute = Math.floor(leftTime / 1000 / 60 % 60);
            var second = Math.floor(leftTime / 1000 % 60); 
            //将倒计时赋值到div中
            document.getElementById("_d").innerHTML = day+"天";
            document.getElementById("_h").innerHTML = hour+"时";
            document.getElementById("_m").innerHTML = minute+"分";
            document.getElementById("_s").innerHTML = second+"秒";
            //递归每秒调用countTime方法，显示动态时间效果
            setTimeout(startCount,1000);
        }
        if (leftTime < 0) {
//        	clearInterval(countTimer);
        	console.log("leftTime:"+leftTime);
        	//开始清算,ajax
        	
        }
  },1000);
}

function getServerDate(){
    return new Date($.ajax({async: false}).getResponseHeader("Date"));
}

/*
 * 1.统计不同groupId各自的order数，与groupproduct的最小成团人数比较，
 * 2.<则不成团，这些人对应的order被取消
 * 3.>则成团，order变成待收货
 * 4.库存stock的
 */
//function updateClearing(){
//	$.ajax({
//		type:"POST",
//		async:true,
//		data:{
//			groupProductId:$("#groupProductId").text(),
////			userId:$.session.get('user').userId
//		},
//		dataType:"json",
//		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
//		url:"updateClearing.action",
//		success:function(data){
////			console.log(data);
//			
//		},
//	});
//}

