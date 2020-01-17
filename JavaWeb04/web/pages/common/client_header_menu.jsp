<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/9
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
<a href="user?action=logout">注销</a>&nbsp;&nbsp;
<a href="pages/order/order.jsp">我的订单</a>
<a href="pages/cart/cart.jsp">购物车</a>
<a href="pages/manager/manager.jsp">后台管理</a>
