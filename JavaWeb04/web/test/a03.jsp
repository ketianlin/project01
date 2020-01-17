<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <base href="http://localhost:8080/web04/">
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"><br/>
    文件:<input type="file" name="file"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
