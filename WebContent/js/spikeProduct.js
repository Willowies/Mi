$(function(){
	//判断登录
	function checkLoginState(){
		var checkResult = "";
		$.ajax({
			type:"post",
			astnc:true,
			url:"checkLoginState.action",
			success:function(data){
				checkResult = data;
			}
		});
		return checkResult;
	}
	
	$(".proLoginClose").click(function(){
		$(".login-notic").css("display","none");
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
	//通过时间锁定载入页面时active的秒杀时间
	
	var now = new Date($.ajax({async: false}).getResponseHeader("Date")); //获取当前服务器时间
	var date = now.getFullYear() + "-" +((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
	//把每个秒杀时间转换成时间戳存入button的value中
	changeSpikeTime();
	//setInterval(,1000);
	var liList = $(".spike-banner ul").children("li");
	var countIndex = 0;  //定位要显示的秒杀场次
	var flag = "";  //标记”即将开始“or”正在进行“
	setSpikeBanner();
	var focusSpikeTime = $(".spike-banner ul li.active button").attr("id");//选中的秒杀时间
	//console.log(focusSpikeTime);
	var focusTime = $(".spike-banner ul li.active button").attr("value");
	getSpikeProduct();	
	$(".spike-banner ul li").click(function(){
		$(".spike-banner ul li.active").removeClass("active");
		$(this).addClass("active");
		focusSpikeTime = $(".spike-banner ul li.active button").attr("id");
		focusTime = $(".spike-banner ul li.active button").attr("value");
		console.log(focusTime);
		getSpikeProduct();
				
	});
	
	//定位获取要倒计时的秒杀场次
	function setSpikeBanner(){				
		var lastDate = $(".spike-banner ul li:last").find(".focustime").attr("value");//最晚的秒杀时间
		var lastTime = Date.parse(lastDate.replace(/-/g,"/"));
		var serverDate = new Date($.ajax({async: false}).getResponseHeader("Date"));
		var serverTime = serverDate.getTime();
		var gapTime = lastTime + 60*60*1000 - serverTime;//最大秒杀时间与当前时间间隔		
		for(var i = 0; i < liList.length; i++){
			var spikeDate = $(liList[i]).find(".focustime").attr("value");
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
		$(liList).removeClass("active");
		$(liList[countIndex]).addClass("active");
		//请求倒计时
		var countDate = $(liList[countIndex]).find(".focustime").attr("value");
		//console.log(countDate);
		console.log(flag);
		var countTime = Date.parse(countDate.replace(/-/g,"/"));
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
			if(!isNaN(remainTime)){
				var hour = Math.floor(remainTime / 1000 / 60 / 60 % 24);
				var minute = Math.floor(remainTime / 1000 / 60 % 60);
				var second = Math.floor(remainTime / 1000 % 60);
				//显示倒计时
				var showTime = (hour<10?"0":"")+hour+":"+(minute<10?"0":"")+minute+":"+(second<10?"0":"")+second;
				if(flag == "正在进行"){
					$(liList[countIndex]).find("span").html("<em>正在进行<br>距结束   "+showTime+"</em>");
					if(hour == 0 && minute == 0 && second == 0){
						setSpikeBanner();
						getSpikeProduct();
		    		}
				}
				if(flag == "即将开始"){
					$(liList[countIndex]).find("span").html("<em>即将开始<br>距开始   "+showTime+"</em>");	
					if(hour == 0 && minute == 0 && second == 0){
						setSpikeBanner();
						getSpikeProduct();
		    		}
				}
				for(var i = 0; i < countIndex; i++){
					$(liList[i]).find("span").html("已结束");
				}
				for(var i = countIndex+1; i < liList.length; i++){
					$(liList[i]).find("span").html("即将开始");
				}
			}
			
		},1000);
	}
	//发送秒杀提醒请求
	function reminded(){
		var isLogin = checkLoginState();//判断登录
		if(isLogin == "true"){
			//已登录
			
		}else{
			//未登录
		}
		var focusDate = new Date(Date.parse(focusTime.replace(/-/g,"/")));//选中秒杀时间
		var focusTime = focusDate.getTime();
		var remindTime = focusDate.getTime()-15*60*1000;
		var remindDate = new Date(remindTime);
		$.ajax({
			type:post,
			astnc:true,
			url:"addSpikeRemind.action?remindTime="+remindDate,
			success:function(data){
				$("#isSetted").text(data);
				$("#bodyfoot").css("display","none");
			}
		});	
		$("a.remind").text("已提醒");
		$.ajax({
			type:post,
			astnc:true,
			url:"addSpikeMessage.action?sendTime="+remindDate,
			success:function(data){
				
			}
		});
	}
	
	//获取当前秒杀时间的商品列表
	function getSpikeProduct(){
		var nowDate = new Date($.ajax({async: false}).getResponseHeader("Date"));//当前服务器时间		
		//console.log(nowDate);
		var focusDate = new Date(Date.parse(focusTime.replace(/-/g,"/")));//选中秒杀时间
		//console.log(focusDate);
		//计算选中秒杀时间与当前时间的差
		var diff = Math.abs(focusDate-nowDate)/1000/60;
		var diffMinute = parseInt(diff);//计算相差分钟数
		//console.log(diffMinute);
		$.ajax({
			type:"post",
			astnc:true,
			url:"selectSpikeProduct.action?focusSpikeTime="+focusSpikeTime,
			success:function(data){
				//判断登录
				var isLogin = checkLoginState();
				if(isLogin == "true"){
					//已登录
					
				}else{
					//未登录
					/*for(var i = 0; i < data.length; i++){
						var html = ""+" <li><p style=\"display:none;\" id=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
						+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].size)+(data[i].color)
						+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process hide\"><span></span><em></em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
						+(data[i].previousPrice)+"元 </del></p><a href=\"\" class=\"but btn-green btn-remind btn-small remind\" style=\"background: #ff6700 !important; border-color: #ff6700 !important;\" href=\"login.jsp\">登录后抢购</a></div></li>";
						$(".spike-con ul.active").html(html);
				    }*/
				}
				//可设置提醒但不可抢购		
				if(diffMinute > 15 && focusDate > nowDate){
					$(".spike-con ul.active").empty();
					for(var i = 0; i < data.length; i++){
						var html = ""+" <li><p style=\"display:none;\" id=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
						+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].size)+(data[i].color)
						+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process hide\"><span></span><em></em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
						+(data[i].previousPrice)+"元 </del></p><a href=\"\" class=\"but btn-green btn-remind btn-small remind\" data-toggle=\"modal\" data-target=\"#modalRemind\">提醒我</a></div></li>";
						$(".spike-con ul.active").html(html);
				    }
				}
				//不可设置提醒也不可抢购
				if(diffMinute > 0 && diffMinute <= 15 && focusDate > nowDate){
					$(".spike-con ul.active").empty();
					for(var i = 0; i < data.length; i++){
						var html = "<p style=\"display:none;\" id=\"spikeProductId\">"+(data[i].spikeProductId)+"</p>"+" <li><p style=\"display:none;\" id=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
						+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].size)+(data[i].color)
						+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process hide\"><span></span><em></em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
						+(data[i].previousPrice)+"元 </del></p><a href=\"\" class=\"but btn-green btn-disabled btn-small nostart\" onclick=\"\">即将开抢</a></div></li>";
						$(".spike-con ul.active").html(html);
										
					}
				}
				//可以抢购
				if(diffMinute <= 60 && diffMinute >= 0 && focusDate < nowDate){
					$(".spike-con ul.active").empty();
					for(var i = 0; i < data.length; i++){
						var percent = 10 * data[i].currentSpikeNum / data[i].spikeQuantity;	
						console.log(percent);
						var html = ""+" <li><p style=\"display:none;\" class=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
						+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].size)+(data[i].color)
						+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process \"><span style=\"width:"+percent+"px;\"></span><em>"+percent+"%</em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
						+(data[i].previousPrice)+"元 </del></p><a href=\"\" class=\"but btn-green btn-remind btn-small start\" data-toggle=\"modal\" data-target=\"#startModal\">立即抢购</a></div></li>";
						$(".spike-con ul.active").html(html);
				    }
				}
				//抢购已结束
				if(diffMinute > 60 && focusDate < nowDate){
					$(".spike-con ul.active").empty();
					for(var i = 0; i < data.length; i++){
						var html = ""+" <li><p style=\"display:none;\" id=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
						+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].size)+(data[i].color)
						+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process \"><span style=\"width: 100%;\"></span><em>100%</em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
						+(data[i].previousPrice)+"元 </del></p><a href=\"\" class=\"but btn-green btn-disabled btn-small over\" onclick=\"\">已结束</a></div></li>";
						$(".spike-con ul.active").html(html);
				    }
				}
			}
		});
	}
	//将秒杀时间转换成标准格式
	function changeSpikeTime(){
		var date0 = date + " 10:00:00";
		var date1 = date + " 12:00:00";
		var date2 = date + " 18:00:00";
		var date3 = date + " 20:00:00";
		var date4 = date + " 22:00:00";
		
		$("#0").val(date0);
		$("#1").val(date1);
		$("#2").val(date2);
		$("#3").val(date3);
		$("#4").val(date4);
	}
	
	//抢购商品
	$(".start").click(function(){
		alert($(".start").text());
		var isLogin = checkLoginState();//判断登录
		if(isLogin == "true"){
			//已登录
			
		}else{
			//未登录
		}
		var spikeProductId = $(this).parent().find(".spikeProductId").text();
		console.log("商品ID"+spikeProductId);
		$.ajax({
			type:post,
			astnc:true,
			dataType:"text",
			url:"buySpikeProduct.action?spikeProductId="+spikeProductId,
			function(data){
				console.log(data);
				if(data == "超过上限"){
					$("#modalMax").modal("show");
				}
                if(data == "抢购已结束"){
					$("#modalOver").modal("show");
				}
                if(data == "抢购成功"){
					$.ajax({
						type:post,
						astnc:true,
						dataType:"json",
						url:"findSpikeProduct.action?spikeProductId="+spikeProductId,
						function(data){
							window.location.href = "updateSpikeOrder.action?orderProduct="+data;
						}
					});
				}
			}
		});
	});

	
	
});

//显示选中时间的秒杀商品
/*

*/
