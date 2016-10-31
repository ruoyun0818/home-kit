<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>登陆</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
<link rel="stylesheet" href="static/css/signin.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/top_nav.jsp" />
	<div class="container">
		<form class="form-signin" role="form" method="post" action="doLogin">
			<div class="alert alert-warning alert-dismissible ${empty login_error ? 'hide' : 'show'}" role="alert">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span>
					<span class="sr-only">Close</span>
				</button>
				<strong>${login_error }</strong>
			</div>
			<h2 class="form-signin-heading"></h2>
			<input name="password" type="password" class="form-control" placeholder="请输入注册码" required />
			<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
		</form>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</div>
	<!-- /container -->
	<jsp:include page="/WEB-INF/views/common/js.jsp" />
	<script type="text/javascript">
		$(function() {

		});
	</script>
</body>
</html>