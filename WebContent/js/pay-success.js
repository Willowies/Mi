$(document).ready(function(){
	var allButtons = $(".pagers li");
	$(allButtons[0]).on('click',function(event){
		$(".carousel-list").css("margin-left","0");
		$(".pager").removeClass("pager-active");
		$(this).addClass("pager-active");
	});
	$(allButtons[1]).on('click',function(event){
		$(".carousel-list").css("margin-left","-1240px");
		$(".pager").removeClass("pager-active");
		$(this).addClass("pager-active");
	});
});