<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <base href="http://localhost:8080/web04/">
    <style>
        li{list-style: none;margin: 20px;border-bottom: solid 1px #ccc;}
        li img{width: 200px;}
        li a{    margin-right: 50px;
            float: left;
            top: 100px;
            position: relative;}
    </style>
</head>
<body>
<ul>
    <li><img src="uploads/a.jpg" alt="">&nbsp;&nbsp;<a href="<c:url value="/download"><c:param name="name" value="a.jpg"></c:param> </c:url>">下载</a></li>
    <li><img src="uploads/b.jpg" alt="">&nbsp;&nbsp;<a href="<c:url value="/download"><c:param name="name" value="b.jpg"></c:param> </c:url>">下载</a></li>
    <li><img src="uploads/c.jpg" alt="">&nbsp;&nbsp;<a href="<c:url value="/download"><c:param name="name" value="c.jpg"></c:param> </c:url>">下载</a></li>
    <li><img src="uploads/d.jpg" alt="">&nbsp;&nbsp;<a href="<c:url value="/download"><c:param name="name" value="d.jpg"></c:param> </c:url>">下载</a></li>
    <li><img src="uploads/e.jpg" alt="">&nbsp;&nbsp;<a href="<c:url value="/download"><c:param name="name" value="e.jpg"></c:param> </c:url>">下载</a></li>
    <li><img src="uploads/f.jpg" alt="">&nbsp;&nbsp;<a href="<c:url value="/download"><c:param name="name" value="f.jpg"></c:param> </c:url>">下载</a></li>
    <li><img src="uploads/g.jpg" alt="">&nbsp;&nbsp;<a href="<c:url value="/download"><c:param name="name" value="g.jpg"></c:param> </c:url>">下载</a></li>

</ul>
</body>
</html>
