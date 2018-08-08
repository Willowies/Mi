$(function(){
	initData2();
});
/* initiate data */
function initData2(){
	
	$.ajax({
		type:"POST",
		async:true,
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"load_groupProducts.action",
		success:function(data){
			console.log(data);
			//
			for(var i=0;i<data.length;i++){
				var quantity = judgeCurrentQuantity(data[i].groupProductId);//check quantity of people
				console.log("quantity "+quantity);
				var nowDate = new Date();
				var nowTime = nowDate.getTime();
				console.log("nowDate:"+nowDate);
				console.log("nowTime:"+nowTime);
				//server date
				var serverDate = getServerDate();
				console.log("serverDate:"+serverDate);
				console.log("serverTime:"+serverDate.getTime());
				//current date
				var currentDate = new Date();
				console.log("currentDate:"+currentDate);
				console.log("currentTime:"+currentDate.getTime());
				//ajax时间差
				var ajaxInterval = currentDate.getTime()-nowTime;
				//end date
				var endDateTime = data[i].endDate;
				console.log("endDate:"+(new Date(endDateTime))+"  endTime:"+endDateTime);
				var countDown = endDateTime-serverDate.getTime()-ajaxInterval;//check time of product
				//活动未过期，并且人数还够，显示
//				console.log("sessionStorage:"+sessionStorage.getItem("user_login"));
				if(sessionStorage.getItem("user_login")=="true"){
					sessionStorage.clear();
					if(countDown>=0 && quantity==1){
						var str="<div class='groupProductItem'><div class='gpImg'><a href='groupProductInfo.jsp?groupProductId="
							+data[i].groupProductId+"' style='height:190px; display:block;'><img src='../"+data[i].product.picUrl+"' width='190px' height='190px'></a>"
							+"</div><div class='gpInfo'><a href='groupProductInfo.jsp?groupProductId="+data[i].groupProductId+"' class='name'>"+data[i].product.extremeName+"</a>"
							+"<p class='desc'>"+data[i].product.description+"</p><p class='price'>"
							+data[i].groupPrice+"元<del style='color:#b0b0b0;'>"+data[i].product.productPrice+"元</del></p>"
							+"<a href='groupProductInfo.jsp?groupProductId="+data[i].groupProductId+"' class='moreInfo'>商品详情</a>"
							+"</div></div>";
						$(".groupProductList").append(str);
					}else{
						console.log("该团购商品活动期已过！");
						var str="<div class='groupProductItem'><div class='gpImg'><img src='../"+data[i].product.picUrl+"' width='190px' height='190px'>"
						+"</div><div class='gpInfo'><a class='name'>"+data[i].product.extremeName+"</a>"
						+"<p class='desc'>"+data[i].product.description+"</p><p class='price'>"
						+data[i].groupPrice+"元<del style='color:#b0b0b0;'>"+data[i].product.productPrice+"元</del></p>"
						+"<a href='javascript:void(0)' class='moreInfo' style='background:#b0b0b0'>已结束</a>"
						+"</div></div>";
						$(".groupProductList").append(str);
					}
				}
				if(sessionStorage.getItem("user_login")=="false"){
					sessionStorage.clear();
					console.log("请登录！");
					var str="<div class='groupProductItem'><div class='gpImg'><img src='../"+data[i].product.picUrl+"' width='190px' height='190px'>"
					+"</div><div class='gpInfo'><a class='name'>"+data[i].product.extremeName+"</a>"
					+"<p class='desc'>"+data[i].product.description+"</p><p class='price'>"
					+data[i].groupPrice+"元<del style='color:#b0b0b0;'>"+data[i].product.productPrice+"元</del></p>"
					+"<a href='login.jsp' class='moreInfo' style='background:red'>请您先登录</a>"
					+"</div></div>";
					$(".groupProductList").append(str);
				}
				
			}
			console.log("Load finish--group products info");
		},
	});
}

function getServerDate(){
    return new Date($.ajax({async: false}).getResponseHeader("Date"));
}
function judgeCurrentQuantity(groupProductId){
	var quantity;
	$.ajax({
		type:"POST",
		async:false,
		data:{
			groupProductId:groupProductId
		},
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		url:"judgeCurrentQuantity.action",
		success:function(data){
//			console.log("judgeCurrentQuantity "+data);
			quantity = data;
//			return data;
		},
	});
//	console.log("judgeCurrentQuantityfunction "+quantity);
	return quantity;
}
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
