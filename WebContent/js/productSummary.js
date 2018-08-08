$(document).ready(function(){
	//alert("进入了js");
	var height1 = $("#box").offset().top;
	//alert(height1);
	$(window).scroll(function(){
		//alert("进到了方法里");
		var this_scrollTop = $(this).scrollTop();
		//alert(this_scrollTop);
		if(this_scrollTop+400>height1){
			//alert("超过了");
			$("#paragraph1").fadeIn(2500);
			$("#paragraph2").fadeIn(3000);
		}
	});
	
	$('.carousel').carousel();
});
