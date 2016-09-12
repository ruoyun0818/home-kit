<%@page import="com.whitesky.home.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">控制台程序</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
	  <ul class="nav navbar-nav"></ul>
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
  </div>
</nav>
