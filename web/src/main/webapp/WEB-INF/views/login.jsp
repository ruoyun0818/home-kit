<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
<link rel="stylesheet" href="static/css/signin.css" />
</head>
<body>
  <jsp:include page="/WEB-INF/views/common/top_nav.jsp" />
  <div class="container">
    <form class="form-signin" role="form" method="post" action="<%=request.getContextPath()%>/doLogin">
      <div class="alert alert-warning alert-dismissible ${empty error ? 'hide' : 'show'}" role="alert">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <strong>${error }</strong> 
      </div>
      <h2 class="form-signin-heading"></h2>
      <input name="name" type="text" class="form-control" placeholder="请输入用户名" required autofocus /> 
      <input name="password" type="password" class="form-control" placeholder="请输入密码" required />
      <div class="checkbox">
        <label> <input name="remember_me" type="checkbox" value="remember-me"> 记住用户名
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
                              登陆
      </button>
    </form>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
  </div>
  <!-- /container -->
<jsp:include page="/WEB-INF/views/common/js.jsp" />
<script type="text/javascript">
	$(function(){
		
	});
</script>
</body>
</html>