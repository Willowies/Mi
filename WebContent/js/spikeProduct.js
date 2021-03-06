$(function(){
	var checkLogin;//标记是否登录
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
	var liList = $(".spike-banner ul").children("li");
	var countIndex = 0;  //定位要显示的秒杀场次
	var flag = "";  //标记”即将开始“or”正在进行“
	var lastEndTime = null;	
	var focusSpikeTime = $(".spike-banner ul li.active button").attr("id");//选中的秒杀时间
	var focusTime = $(".spike-banner ul li.active button").attr("value");
	setSpikeBanner();	
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
		lastEndTime = lastTime + 60*60*1000;
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
		focusTime = $(".spike-banner ul li.active button").attr("value");
		getSpikeProduct();
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
			if(!isNaN(remainTime) && remainTime >= 0){
				var hour = Math.floor(remainTime / 1000 / 60 / 60 % 24);
				var minute = Math.floor(remainTime / 1000 / 60 % 60);
				var second = Math.floor(remainTime / 1000 % 60);
				//显示倒计时
				var showTime = (hour<10?"0":"")+hour+":"+(minute<10?"0":"")+minute+":"+(second<10?"0":"")+second;
				if(flag == "正在进行"){
					$(liList[countIndex]).find("span").html("<em>正在进行<br>距结束   "+showTime+"</em>");
					if(hour == 0 && minute == 0 && second == 0){
						setSpikeBanner();
						//getSpikeProduct();
		    		}
				}
				if(flag == "即将开始"){
					$(liList[countIndex]).find("span").html("<em>即将开始<br>距开始   "+showTime+"</em>");	
					if(hour == 0 && minute == 0 && second == 0){
						setSpikeBanner();
						//getSpikeProduct();
		    		}
				}
				for(var i = 0; i < countIndex; i++){
					$(liList[i]).find("span").html("已结束");
				}
				for(var i = countIndex+1; i < liList.length; i++){
					$(liList[i]).find("span").html("即将开始");
				}
				if(nowTime >= lastEndTime){
					for(var i = 0; i < liList.length; i++){
						$(liList[i]).find("span").empty();
						$(liList[i]).find("span").html("已结束");
					}
				}
			}
			
		},1000);
	}
	
	//获取当前秒杀时间的商品列表
	function getSpikeProduct(){
		var nowDate = new Date($.ajax({async: false}).getResponseHeader("Date"));//当前服务器时间		
		//console.log(nowDate);
		focusSpikeTime = $(".spike-banner ul li.active button").attr("id");
		console.log("当前时间"+focusTime);
		var focusStamp = Date.parse(focusTime.replace(/-/g,"/"));
		var focusDate = new Date(focusStamp);//选中秒杀时间
		//console.log(focusDate);
		//计算选中秒杀时间与当前时间的差
		var diff = Math.abs(focusDate-nowDate)/1000/60;
		var diffMinute = parseInt(diff);//计算相差分钟数
		//console.log(diffMinute);
		$.ajax({
			type:"post",
			async:false,
			url:"selectSpikeProduct.action?focusSpikeTime="+focusSpikeTime,
			success:function(data){
				//判断登录
				checkLoginState();
				//alert("方法调用后"+checkLogin);
				if(checkLogin == "true"){
					//已登录
					//alert("已登录");
					console.log("时间差"+diffMinute);
					//可设置提醒但不可抢购		
					if(diffMinute > 15 && focusDate > nowDate){
						$(".spike-con ul.active").empty();
						for(var i = 0; i < data.length; i++){
							var html = ""+" <li><p style=\"display:none;\" class=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
							+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].color)
							+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process hide\"><span></span><em></em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
							+(data[i].previousPrice)+"元 </del></p><a class=\"but btn-green btn-remind btn-small remind\" data-toggle=\"modal\" >提醒我</a></div></li>";
							$(".spike-con ul.active").append(html);
					    }
					}
					//不可设置提醒也不可抢购
					if(diffMinute > 0 && diffMinute <= 15 && focusDate > nowDate){
						$(".spike-con ul.active").empty();
						for(var i = 0; i < data.length; i++){
							var html = "<p style=\"display:none;\" class=\"spikeProductId\">"+(data[i].spikeProductId)+"</p>"+" <li><p style=\"display:none;\" id=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
							+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].color)
							+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process hide\"><span></span><em></em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
							+(data[i].previousPrice)+"元 </del></p><a class=\"but btn-green btn-disabled btn-small nostart\" onclick=\"\">即将开抢</a></div></li>";
							$(".spike-con ul.active").append(html);
											
						}
					}
					//可以抢购
					if(diffMinute <= 60 && diffMinute >= 0 && focusDate < nowDate){
						$(".spike-con ul.active").empty();
						for(var i = 0; i < data.length; i++){
							var percent = 100 * data[i].currentSpikeNum / data[i].spikeQuantity;	
							console.log(percent);
							var html = ""+" <li><p style=\"display:none;\" class=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
							+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].color)
							+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process \"><span style=\"width:"+percent+"%;\"></span><em>"+percent+"%</em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
							+(data[i].previousPrice)+"元 </del></p><a class=\"but btn-green btn-remind btn-small start\" style=\"background: #ff6700 !important; border-color: #ff6700 !important; data-toggle=\"modal\">立即抢购</a></div></li>";
							$(".spike-con ul.active").append(html);
					    }
					}
					//抢购已结束
					if(diffMinute > 60 && focusDate < nowDate){
						$(".spike-con ul.active").empty();
						for(var i = 0; i < data.length; i++){
							var percent = 100 * data[i].currentSpikeNum / data[i].spikeQuantity;	
							console.log(percent);
							var html = ""+" <li><p style=\"display:none;\" class=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
							+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].color)
							+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process \"><span style=\"width:"+percent+"%;\"></span><em>"+percent+"%</em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
							+(data[i].previousPrice)+"元 </del></p><a class=\"but btn-green btn-disabled btn-small over\" onclick=\"\">已结束</a></div></li>";
							$(".spike-con ul.active").append(html);
					    }
					}
				}else{
					//未登录
					$(".spike-con ul.active").empty();
					for(var i = 0; i < data.length; i++){
						var html = ""+" <li><p style=\"display:none;\" class=\"spikeProductId\">"+(data[i].spikeProductId)+"</p><div class=\"img-con\"><img class=\"done\" src=\"../"
						+(data[i].picUrl)+"\" /></div><div class=\"pro-con\"><a class=\"name\" style=\"cursor:pointer;\">"+(data[i].productName)+(data[i].version)+(data[i].color)
						+"</a><p class=\"desc tips\">"+(data[i].description)+"</p><p class=\"process hide\"><span></span><em></em></p><p class=\"price\">"+(data[i].spikePrice)+"元<del>"
						+(data[i].previousPrice)+"元 </del></p><a href=\"login.jsp\" class=\"but btn-green btn-remind btn-small login\" style=\"background: #ff6700 !important; border-color: #ff6700 !important;\">登录后抢购</a></div></li>";
						$(".spike-con ul.active").append(html);
				    }
					//秒杀结束 按钮显示已结束
					var activityStatus = $(".spike-banner ul li.active span").text();
					//alert(activityStatus);
					if(activityStatus == "已结束"){
						//alert($(".pro-con").children("a.login").length);
						$(".pro-con").children("a.login").text("已结束");
						$(".pro-con").children("a.login").removeClass("btn-remind");
						$(".pro-con").children("a.login").addClass("btn-disabled");
						$(".pro-con").children("a.login").css({"background": "#f2f2f2","border-color":"#f2f2f2"});
						$(".pro-con").children("a.login").attr("href","javascript:void(0)");
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
	$("body").on("click",".start",function(){
		//alert("购买");
		checkLoginState();//判断登录
		if(checkLogin == "true"){
			//已登录
			var thisPro = $(this);
			var spikeProductId = $(this).parent().parent().find(".spikeProductId").text();
			console.log("秒杀商品ID"+spikeProductId);
			$.ajax({
				type:"post",
				async:false,
				dataType:"text",
				url:"buySpikeProduct.action?spikeProductId="+spikeProductId,
				success:function(data){
					if(data == "超过上限"){
						//更改抢购按钮为“已结束”
						$(thisPro).text("已结束");
						$(thisPro).removeClass("btn-remind");
						$(thisPro).addClass("btn-disabled");
						$(thisPro).css({"background": "#f2f2f2","border-color":"#f2f2f2"});
						$(thisPro).attr("href","javascript:void(0)");
						//弹出提醒
						$("#modalMax").modal("show");
						$("body").on("click",".iknown",function(){
							$("#modalMax").modal("hide");
						});

					}
	                if(data == "抢购已结束"){
						//更改所有的抢购按钮为“已结束”
						$(".pro-con").children("a.login").text("已结束");
						$(".pro-con").children("a.login").removeClass("btn-remind");
						$(".pro-con").children("a.login").addClass("btn-disabled");
						$(".pro-con").children("a.login").css({"background": "#f2f2f2","border-color":"#f2f2f2"});
						$(".pro-con").children("a.login").attr("href","javascript:void(0)");
						//弹出提醒
						$("#modalOver").modal("show");
						$("body").on("click",".iknown",function(){
							$("#modalOver").modal("hide");
						});
					}
	                if(data == "抢购成功"){
	                	//alert("抢购成功");
						$.ajax({
							type:"post",
							async:false,
							dataType:"json",
							url:"findSpikeProduct.action?spikeProductId="+spikeProductId,
							success:function(data){
								//alert("准备跳转购买");
								window.location.href = "updateSpikeOrder.action";
							}
						});
					}
				}
			});
		}else{
			//未登录
			window.location.href = "login.jsp";
		}

	});

	//发送秒杀提醒请求
	$("body").on("click",".remind",function(){	
		var spikeProductId = $(this).parent().parent().find(".spikeProductId").text();
		console.log("秒杀的商品"+spikeProductId);
		checkLoginState();//判断登录
		if(checkLogin == "true"){
			//已登录			
			//修改提醒样式
			$(this).text("已提醒");
			$(this).removeClass("remind");
			$(this).addClass("btn-disabled");
			$(this).css({"background": "#f2f2f2","border-color":"#f2f2f2"});
			$(this).attr("href","javascript:void(0)");
			//设置提醒
			var focusTime = $(".spike-banner ul li.active button").attr("value");
			var focusStamp = Date.parse(focusTime.replace(/-/g,"/"));//选中秒杀时间
			var focusDate = new Date(focusStamp);
			console.log("当前场次"+focusDate);
			var remindTime = focusStamp-15*60*1000;
			//console.log(remindTime);
			
			$.ajax({
				type:"post",
				async:false,
				dataType:"text",
				url:"addSpikeRemind.action?spikeProductId="+spikeProductId+"&remindTime="+remindTime,
				success:function(data){
					$("#modalRemind").modal("show");
					console.log(data);
					$("#isSetted").text(data);					
					$("body").on("click",".iknown",function(){
						$("#modalRemind").modal("hide");
					});
				}
			});	
			//设置定时消息
			
			$.ajax({
				type:"post",
				async:false,
				url:"addSpikeMessage.action?spikeProductId="+spikeProductId+"&sendTime="+remindTime,
				success:function(){
					//更改提醒状态
					console.log("已设置定时提醒");
					$.ajax({
						type:"post",
						async:false,
						url:"updateSpikeRemind.action?spikeProductId="+spikeProductId+"&remindTime="+remindTime,
						success:function(){
							console.log("已更改提醒状态");
						}
					});
				}
			});
		}else{
			//未登录
			window.location.href = "login.jsp";
		}		
	});

	
	//判断登录
	function checkLoginState(){
		//alert("检查登录");
		$.ajax({
			type:"post",
			async:false,
			dataType:"text",
			url:"checkLoginState.action",
			success:function(data){
				//alert("判断登录内部ajax"+data);
				checkLogin = data;
			}
		});
	    //alert("判断登录内部"+checkLogin);
		
	}
	
});

//显示选中时间的秒杀商品
/*

*/
