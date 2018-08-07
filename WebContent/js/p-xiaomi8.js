function  changImg(index,maxPicNum){
	var imgId = "#p-img-"+index;
	$(imgId).addClass("active");
	var i = 0;
	while(i <= maxPicNum){
		i++;
		if(i==index) continue;
		hideImg(i);
	}
}
function  hideImg(index){
	var imgId = "#p-img-"+index;
	$(imgId).removeClass("active");
}
