$(function(){	
    var flag = "";  //标记”即将开始“or”正在进行“
    var lastEndTime = null;
    showBanner();
    //根据时间显示场次
    function showBanner(){
    	var dateList = getDateList();
    	//console.log(dateList);
    	var countIndex = 0; //定位要显示的秒杀场次
    	var lastDate = dateList[4].valueOf();
    	var lastTime = Date.parse(lastDate.replace(/-/g,"/"));
    	lastEndTime = lastTime + 60*60*1000;
    	var serverDate = new Date($.ajax({async: false}).getResponseHeader("Date"));
		var serverTime = serverDate.getTime();
		console.log(serverDate);
		//console.log(serverTime);
		var gapTime = lastTime + 60*60*1000 - serverTime;//最大秒杀时间与当前时间间隔
		console.log(gapTime);
    	for(var i = 0; i < dateList.length; i++){
    		var spikeDate = dateList[i].valueOf();
			var startTime = Date.parse(spikeDate.replace(/-/g,"/"));
			var endTime = Date.parse(spikeDate.replace(/-/g,"/"))+60*60*1000;
			if(endTime - serverTime >= 0 && endTime - serverTime <= gapTime){
				gapTime = endTime - serverTime;
				if(startTime - serverTime <= 0){
					//抢购中
					countIndex = i;
					flag = "正在进行";
				}else{
					//即将开始
					countIndex = i;
					flag = "即将开始";
				}				
			}
    	}
    	console.log(flag);
    	//查询秒杀商品
    	selectProductList(dateList[4].valueOf());
    	//定位要倒计时的秒杀场次
    	var countDate = dateList[countIndex].valueOf();
    	console.log(countDate);
    	var recentTime = countDate.split(" ")[1].split(":");
    	var recentActivity = recentTime[0]+":"+recentTime[1];
    	$(".time-title").text(recentActivity+" 场");
    	var countTime = Date.parse(countDate.replace(/-/g,"/"));
    	//请求倒计时
    	setTimer(countTime);
   	
    }
    
    //获取倒计时时间
	function setTimer(countTime){		
		var localBefore = new Date();//发送请求之前的本地时间	
		var serverDate = new Date($.ajax({async: false}).getResponseHeader("Date"));//请求当前服务器时间
		var localAfter = new Date();//返回请求之后的本地时间
		console.log(localBefore);
		console.log(serverDate);
		console.log(localAfter);
		var requestPeriod = localAfter.getTime()-localBefore.getTime();//Ajax请求的时间
		var period = countTime - serverDate.getTime();//实际秒杀时间段
		var countDownPeriod = period - requestPeriod + localAfter.getTime();//在本地倒计时的时间
		console.log(countDownPeriod);
		countDown(countDownPeriod);
	}
	
	//倒计时
	function countDown(period){
		//定时一秒执行一次倒计时
		var countTimer = setInterval(function(){
			var nowTime = new Date().getTime();
			var remainTime = Math.abs(period - nowTime);
			if(flag == "正在进行"){
				remainTime = 60*60*1000 - remainTime;
			}
			//console.log(remainTime);
			if(!isNaN(remainTime) && remainTime >= 0){
				var hour = Math.floor(remainTime / 1000 / 60 / 60 % 24);
				var minute = Math.floor(remainTime / 1000 / 60 % 60);
				var second = Math.floor(remainTime / 1000 % 60);
				
				//显示倒计时				
				var showTime = (hour<10?"0":"")+hour+":"+(minute<10?"0":"")+minute+":"+(second<10?"0":"")+second;
				//console.log(showTime);
				if(flag == "正在进行"){
		    		$(".sub").text("距离结束还有");
		    		if(hour == 0 && minute == 0 && second == 0){
		    			//$(".sub").text("已结束 期待下场");
		    			showBanner();
		    		}
		    	}
		    	if(flag == "即将开始"){
		    		$(".sub").text("距离开始还有");
		    		if(hour == 0 && minute == 0 && second == 0){
		    			//$(".sub").text("正在进行 点击进入");
		    			showBanner();
		    		}
		    	}
				if(nowTime >= lastEndTime){
					$(".sub").text("今日秒杀已结束");
					showTime = "00:00:00";
				}
		    	var timePart = showTime.split(":");
		    	var target = $(".countdown").children(".box");
		    	for(var i = 0; i < target.length; i++){
		    		$(target[i]).text(timePart[i]);
		    	}
			}
		},1000);
	}
	
    //获取秒杀时间数组
    function getDateList(){
    	var list = new Array();
    	var now = new Date($.ajax({async: false}).getResponseHeader("Date")); //获取当前服务器时间
    	var date = now.getFullYear() + "-" +((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
    	var date0 = date + " 10:00:00";
		var date1 = date + " 12:00:00";
		var date2 = date + " 18:00:00";
		var date3 = date + " 20:00:00";
		var date4 = date + " 22:00:00";
		list.push(date0);
		list.push(date1);
		list.push(date2);
		list.push(date3);
		list.push(date4);
		return list;
    }
    
    //查询显示场次商品列表
    function selectProductList(spikeTime){
    	$.ajax({
    		type:"post",
    		astnc:true,
    		url:"selectIndexSpikeProduct.action?currentDate="+spikeTime,
    		success:function(data){
    			var length = data.length;
    			if(data.length > 8) length = 8;
    			$(".carousel-wrapper ul").empty();
    			for(var i = 0; i < length; i++){
    				var proInner = "<li class=\"item rainbow-item-"+(i+1)+"\">";
    				proInner = proInner+"<a href=\"../mi/spikeProduct.jsp\" target=\"_blank\" onclick=\"\"><div class=\"bg\"></div></a><div class=\"content\"><a class=\"thumb\"><img src=\"../"+data[i].picUrl+
		    		   "\"/></a><h3 class=\"title\"><a onclick=\"\">"+data[i].productName+data[i].version+data[i].color+data[i].size+"</a></h3><p class=\"desc\">"+data[i].description
		    		   +"</p><p class=\"price\"><span>"+data[i].spikePrice+"</span>&nbsp;<span>元</span>&nbsp;<del>"+data[i].previousPrice+"元</del></p></div></li>";
    				$(".carousel-wrapper ul").append(proInner);
    			}
    		}
    	});
    }
    //设置商品列表滑动效果
	let allButtons = $("span.control");
	$(allButtons[0]).click(function(){
		$(this).addClass("control-disabled");
		$(".control-next").removeClass("control-disabled");
	    $(".flashPurchase-list").css("margin-left","0");
    });
    $(allButtons[1]).click(function(){
    	$(".control-prev").removeClass("control-disabled");
	    $(this).addClass("control-disabled");
	    $(".flashPurchase-list").css("margin-left","-992px");
    });
});
