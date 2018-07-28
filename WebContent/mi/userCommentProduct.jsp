<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="../js/jquery.min.js" ></script>
		<script type="text/javascript">
			$(function() {
				//为所有的li标签绑定mouseout和mouseover事件。bind({事件名：function(){},事件名：function(){}})的方法绑定多个事件
				$("#div li").bind({
					mouseout: function() {
						//$(this).css("color", "black").html("☆").prevAll().css("color", "black").html("☆")
					},
					mouseover: function() {
						$(this).css("color", "black").html("☆").nextAll().css("color", "black").html("☆")
						$(this).css("color", "yellow").html("★").prevAll().css("color", "yellow").html("★")

					}
				});
				//=实时显示分数.【index】搜索匹配的元素，并返回相应元素的索引值，从0开始计数。
				$("#div li").mouseover(function() {
					$("#p").html(parseInt($(this).index("#div li")) + 1);
				});
				//鼠标按下时，确定分数。。
				$("#div li").mousedown(function() {
					$("#score").html(("你选择的分数是" + (parseInt($(this).index("#div li")) + 1)));
					$(this).css("color", "yellow").html("★").prevAll().css("color", "yellow").html("★");
					$("input[name='commentRank']").val(parseInt($(this).index("#div li")));
					//全部li标签的绑定事件全部清除--unbind方法可以加参数清除特定的事件。不加全部清除
					//$(this).unbind().prevAll().unbind().nextAll().unbind();
				});
			})
		</script>
		<style type="text/css">
			#menu {
				font: 12px verdana, arial, sans-serif;
				/* 设置文字大小和字体样式 */
			}
			
			#menu,
			#menu li {
				list-style: none;
				/* 将默认的列表符号去掉 */
				padding: 0;
				/* 将默认的内边距去掉 */
				margin: 0;
				/* 将默认的外边距去掉 */
				float: left;
				/* 往左浮动 */
			}
		</style>
	</head>

	<body>
		<p>商品名称：${product.productName} ${product.version} ${product.color}</p>
		<p>商品价格：${product.productPrice} </p>
		<p>${product.productCommentNum}人评价 </p>
		<img src="../${product.picUrl}" width="160px" height="160px" />
		<div id="div">
			<ul id="menu">
				<li>☆</li>
				<li>☆</li>
				<li>☆</li>
				<li>☆</li>
				<li>☆</li>
			</ul>
		</div>
		<p id="p"></p>
		<p id="score"></p>
		<form action="commentProduct.action" method="post" enctype="multipart/form-data">
			<input name="productId" value="${product.productId}" style="display: none;" />
			<input name="commentRank" value="5" style="display: none;" />
			<input type="file" name="commentPic" accept="image/*">
			<textarea name="commentContent" clos=",50" rows="5" warp="virtual"></textarea>
			<button type="submit">提交</button> 
		</form>
	</body>

</html>