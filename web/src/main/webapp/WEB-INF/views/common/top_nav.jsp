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
			<a class="navbar-brand" href="#">
				<img alt="Brand" src="static/images/logo.ico" height="20">
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="${param.p=='console'?'active':'' }"><a href="console">控制台</a></li>
				<li class="${param.p=='audio'?'active':'' }"><a href="audio">音乐</a></li>
				<li class="${param.p=='photo'?'active':'' }"><a href="photo">相册</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<p id="loginText" class="navbar-text ${empty sessionScope.login_key?'hide':'show'}">${sessionScope.login_key}</p>
				</li>
				<li>
					<a id="logout" href="logout" class="${empty sessionScope.login_key?'hide':'show'}">注销</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
