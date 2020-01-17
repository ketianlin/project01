<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/8
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page_nav">
    <c:if test="${page.pageNo > 1}">
        <a href="${page.pageUrl}">首页</a>
        <a href="${page.pageUrl}&pageNo=${page.pageNo-1}">上一页</a>
    </c:if>

    <c:choose>
        <c:when test="${page.pageTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${page.pageTotal}"/>
        </c:when>
        <c:when test="${page.pageTotal > 5}">
            <c:choose>
                <c:when test="${page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <c:when test="${page.pageNo >= page.pageTotal-2}">
                    <c:set var="begin" value="${page.pageTotal-4}"/>
                    <c:set var="end" value="${page.pageTotal}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${page.pageNo-2}"/>
                    <c:set var="end" value="${page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach var="i" begin="${begin}" end="${end}">
        <c:if test="${i == page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != page.pageNo}">
            <a href="${page.pageUrl}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${page.pageNo < page.pageTotal}">
        <a href="${page.pageUrl}&pageNo=${page.pageNo+1}">下一页</a>
        <a href="${page.pageUrl}&pageNo=${page.pageTotal}">末页</a>
    </c:if>
    共${page.pageTotal}页，${page.pageTotalCount}条记录 到第<input value="${page.pageNo}" name="pn" id="pn_input"/>页
    <input id="btnConfirm" type="button" value="确定">
</div>
<script type="text/javascript">
    $(function () {
        $('#btnConfirm').on('click', function () {
            var pageNo = $.trim($('#pn_input').val())
            location.href = '${path}' + '${page.pageUrl}' + "&pageNo=" + pageNo
        })
    });
</script>
