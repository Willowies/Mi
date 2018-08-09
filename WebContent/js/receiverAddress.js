/*document.getElementById("j_selectAddress").addEventListener("click",displaySearch);
function displaySearch() {
   
}*/

$(function() {
	$('#j_selectAddress').click(function() {
		var d = document.getElementById("j_wrapperSelectAddress");
		d.setAttribute("class", "wrapper-select-address");
	});
	$('#commit-recieverAddressForm').click(function() {
		$('#recieverAddressForm').submit();
	});
	$('#close-receiverAddress-hide').click(function() {
		/*关闭添加地址页面*/
		$('#receiverAddress-hide').addClass("windown-hide");
	});
	//校验手机号码位数
	/*$(ContactNumber).blur(checkContactNumber())
	$('#j_select_addressItem').click(function() {
		alert('j_select_addressItem');
		$('#j_selectAddress').addClass("windown-hide");
		var province = $('#j_addressItem').attr('province');
		var city = $('#j_addressItem').attr('city');
		var district = $('#j_addressItem').attr('district');
		alert(province+city+district);
	});*/
	
	$("#j_search_input").off().on({
		compositionend: function() {
			var keyWord = $("#j_search_input").val()
			var url = 'http://api.map.baidu.com/place/v2/suggestion?query='+keyWord+'&region=全国&city_limit=false&output=json&ak=Srngzf0hguQ2nGs4csUlpLcIiErsxgho'
			/*alert(url);*/
			/*$.getJSON(url,function(json){ 
				alert(json);
			}); */
			$.ajax({
				url: 'http://api.map.baidu.com/place/v2/suggestion?query='+keyWord+'&region=全国&city_limit=false&output=json&ak=Srngzf0hguQ2nGs4csUlpLcIiErsxgho',
				type: 'post',
				dataType: 'jsonp', 
				success: function(data) {
					var jsons = data.result;
					$("#j-search-address-result").val("");
					var ulContent = "";
				　　　  $.each( jsons, function(index, content)
					{ 
					   ulContent = ulContent + 
					   '<li'+' province="'+content.province+'"'+' city="'+content.city+'"'+' district="'+content.district+'"'+' id="'+'j_addressItem'+index+'"'+'>'+
					   '<div class="address-title">'+
					   '<span class="item">'+content.name+'</span>'+
					   '</div>'+
					   '<div class="address-desc">'+
					   	content.province+' '+content.city+' '+content.district+
					   '</div>'+
					   '<a class="btn btn-primary" onclick="select_addressItem('+index+')">选择</a>'+
					   '</li>'
					   if(index == 5){
						   return false;
					   }
					});
				    
				    $("#j-search-address-result").html(ulContent);
				}
			});
			/* 以json格式会出现跨域请求问题
			 * $.ajax({
				url: 'http://api.map.baidu.com/place/v2/suggestion?query='+keyWord+'&region=全国&city_limit=false&output=json&ak=Srngzf0hguQ2nGs4csUlpLcIiErsxgho',
				type: 'post',
				dataType: 'text', 
				success: function(data) {
					console.log(data);
					alert(data.status);
				}
			});*/
		}
	})

});

function showReceiverAddressHide(){
	$('#receiverAddress-hide').removeClass("windown-hide");
}
function select_addressItem(index){
	$('#j_wrapperSelectAddress').addClass("windown-hide");
	var province = $('#j_addressItem'+index).attr('province');
	var city = $('#j_addressItem'+index).attr('city');
	var district = $('#j_addressItem'+index).attr('district');
	$('#province').val(province);
	$('#city').val(city);
	$('#district').val(district);
	
}
function updateReceiverAddress(receiverAddressId){
	$('#receiverAddress-hide').removeClass("windown-hide");
	var r =$("#"+receiverAddressId);
	var receiverName = r.attr("receiverName");
	var receiverPhone = r.attr("receiverPhone");
	var addressLabel = r.attr("addressLabel");
	var receiverProvince = r.attr("receiverProvince");
	var receiverCity = r.attr("receiverCity");
	var receiverDistrict = r.attr("receiverDistrict");
	var address = r.attr("address");

	$('#addrecieverAddressForm').attr("action","updateReceiverAddress.action?receiverAddressId="+receiverAddressId);
	
	$('#receiverName').val(receiverName);
	$('#receiverPhone').val(receiverPhone);
	$('#province').val(receiverProvince);
	$('#city').val(receiverCity);
	$('#district').val(receiverDistrict);
	$('#address').val(address);
	$('#addressLabel').val(addressLabel);
}

/*function checkContactNumber() {
	$("#error").css("display", "none");
	var mobile = $.trim($("#ContactNumber").val());
	var isMobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1})|(14[0-9]{1}))+\d{8})$/;
	var isPhone = /^(?:(?:0\d{2,3})-)?(?:\d{7,8})(-(?:\d{3,}))?$/;;
	var error = "<label id=\"error\" class=\"validate_input_error\">请正确填写电话号码，例如:13511111111或010-11111111</label>";
	//如果为1开头则验证手机号码
	if(mobile.substring(0, 1) == 1) {
		if(!isMobile.exec(mobile) && mobile.length != 11) {
			$("#ContactNumber").attr("class","input-text input-error");
			$("#ContactNumber").focus();
			return false;
		}
	}
	//如果为0开头则验证固定电话号码
	else if(mobile.substring(0, 1) == 0) {
		if(!isPhone.test(mobile)) {
			$("#ContactNumber").attr("class","input-text input-error");
			$("#ContactNumber").focus();
			return false;
		}
	}
	//否则全部不通过
	else {
		$("#ContactNumber").attr("class","input-text input-error");
		$("#ContactNumber").focus();
		return false;
	}
	return true;
}*/
