<%@page import="com.whitesky.home.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">控制台程序</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">${sessionScope.user.uname}<span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li><a href="<%=request.getContextPath()%>/user">用户信息</a></li>
          <li class="divider"></li>
          <li><a href="<%=request.getContextPath()%>/logout">注销</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
