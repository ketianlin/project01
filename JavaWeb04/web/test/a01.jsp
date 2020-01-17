<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/30
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
${pageContext.request.scheme}<br>
${pageContext.request.serverName}<br>
${pageContext.request.serverPort}<br>
${pageContext.request.servletPath}<br>
${pageContext.request.contextPath}<br>
${pageContext.request.remoteHost}<br>
${pageContext.session.id}<br>
<hr>
${header['user-Agent']}<br>
${cookie.JSESSIONID.name}<br>
${cookie.JSESSIONID.value}<br>
${initParam.username}<br>
</body>
</html>
