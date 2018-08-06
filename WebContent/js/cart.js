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
$(document).ready(function(){
	//复选框
	$("#all").click(function(){
        // this 全选的复选框
        var isChecked=this.checked;
        //获取name=cartItemIds的复选框 遍历输出复选框
        $("input[name=cartItemIds]").each(function(){
            this.checked=isChecked;
        });
        //判断结算框出现或隐藏
        var length=$("input[name=cartItemIds]:checked").length;
        if(length==0){
        	$(".no-select-tip").show();
        }else{
        	 $(".no-select-tip").hide();
        }
        //计算选中的购物车条目的数量
        $("#selectNum").text(length);
      //计算购物车选中商品的钱数
        getTotalAmount();
    });
    
    //给name=cartItemIds的复选框绑定单击事件
   $("input[name=cartItemIds]").click(function(){
       //获取选中复选框长度
        var length=$("input[name=cartItemIds]:checked").length;
       //未选中的长度
        var len=$("input[name=cartItemIds]").length;
        if(length==len){
            $("#all").get(0).checked=true;
        }else{
            $("#all").get(0).checked=false;
        }
        //判断结算框输入或隐藏
        if(length==0){
        	$(".no-select-tip").show();
        }else{
        	$(".no-select-tip").hide();
        }
        //计算选中的购物车条目的数量
        $("#selectNum").text(length);
        //计算购物车选中商品的钱数
        getTotalAmount();
    });
   
    //计算购物车选中商品的钱数
  	function getTotalAmount(){
  		var totalAmount = 0;
		$("input[name=cartItemIds]").each(function(){
			if(this.checked == true){
				var amount = $(this).parent().parent().find("#amount").text();
				totalAmount = totalAmount + parseFloat(amount);
			}
		})
		$("#totalMoney").text(totalAmount);
  	}
   
   //计算购物车中商品总条目
   	var total = $("input[name=cartItemIds]").length;
   	$("#totalNum").text(total);
   	//计算选中的购物车条目的数量
   	$("#selectNum").text(0);
   	//计算购物车选中商品的钱数
   	$("#totalMoney").text(0);
   	
   	$("#calButton").click(function(){
   		var length=$("input[name=cartItemIds]:checked").length;
   		if(length==0){
   			return false;
   		}else{
   			$("form").submit();
   		}
   	});
});
