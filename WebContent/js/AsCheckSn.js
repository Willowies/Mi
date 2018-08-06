
function creatXMLHTTPRequest(){
	var xmlHttp;
	/*
	 * XMLHTTPRequest
	 * 1. 创建对象
	 * 2. 建立要连接的URL
	 * 3. 打开到服务器的连接
	 * 4. 设置回调函数
	 * 5. 发送请求
	 */
	if(window.XMLHttpRequest){
		//非IE浏览器
		xmlHttp = new XMLHttpRequest();
	}else if(window.ActiveXObject){
		//IE浏览器
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
}

function validate(){
	creatXMLHTTPRequest();
	//获取SN
	var asSn = document.getElementById("asSn");
	//将内容发送到指定地址
	var url = "${pageContext.request.contextPath }/checkSn.action" + escape(asSn.value);
	xmlHttp.open("POST",url,true);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState==4 && xmlHttp.status==200){
			var color = "red";
			
		}
	}
}





