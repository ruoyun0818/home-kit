<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="static/js/jquery.min.js"></script>
<c:if test="${!empty param.fileinput}">
<script src="static/js/fileinput.min.js"></script>
<script src="static/js/fileinput_locale_zh.js"></script>
</c:if>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="static/js/bootstrap.min.js"></script>
