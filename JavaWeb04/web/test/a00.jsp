<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2
  Time: 17:06
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
<form method="get" action="hello">
    <input type="submit" value="get提交">
</form>
<hr>
<form method="post" action="hello">
    <input type="submit" value="post提交">
</form>
<hr>
<form action="hello" method="get">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    兴趣爱好：
    <input type="checkbox" name="hobby" value="cpp" />C++
    <input type="checkbox" name="hobby" value="java" />java
    <input type="checkbox" name="hobby" value="js" />javaScript
    <br/>
    <input type="submit" />
</form>
</body>
</html>
