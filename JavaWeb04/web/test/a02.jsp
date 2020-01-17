<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/30
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
保存之前：${requestScope.abc}<br>
<c:set scope="request" value="abc" var="abc"></c:set>
保存之后：${requestScope.abc}<br>
<c:if test="${12>10}">
    <h3>true</h3>
</c:if>
<hr>
<c:forEach begin="1" end="10" var="i">
    ${i}
</c:forEach>
</body>
</html>
