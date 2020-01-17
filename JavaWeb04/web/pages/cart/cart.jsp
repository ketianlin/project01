<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<div>
				<%@include file="/pages/common/client_header_menu.jsp"%>
			</div>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">当前购物车为空！亲，赶快去购物吧！</a></td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="item">
				<tr>
					<td>${item.value.name}</td>
					<td>
						<input type="text" name="count" value="${ item.value.count }"
							   itemId="${ item.value.id }"
							   style="width: 60px;height: 30px;text-align: center;padding: 5px;" class="updateClass" />
					</td>
					<td>${item.value.price}</td>
					<td>${item.value.totalPrice}</td>
					<td><a onclick="return confirm('确定要删除【${item.value.name}】这个商品吗？')" href="cart?action=deleteItem&id=${item.value.id}">删除</a></td>
				</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a onclick="return confirm('确定要清空购物车吗？')" href="cart?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="order?action=create">去结账</a></span>
		</div>
		</c:if>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
<script type="text/javascript">
	$(function(){
		// change事件，会检查你离开后，和原来是不是不相同，如果不相同就会触发事件
		$("input.updateClass").on('change', function(){
			var newCount = this.value;
			var id = $(this).attr("itemId");
			if (confirm("你确定要修改【" + $(this).parent().parent().find("td:first").text() + "】数量为：" + newCount + " 吗?")) {
				// 点击了确认
				location.href = "${path}cart?action=updateItem&count="+newCount+"&id="+id;
			} else {
				// 点击了取消
				this.value = this.defaultValue;
			}

		});


	});
</script>
</html>