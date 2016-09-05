<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${userInfo.uname}</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
</head>
<body>
  <div class="container">
    <jsp:include page="/WEB-INF/views/common/top_nav.jsp" />
    <div class="jumbotron">
      <h1>Welcome! ${userInfo.uname}</h1>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
  </div>
<jsp:include page="/WEB-INF/views/common/js.jsp" />
<script type="text/javascript">
	
</script>
</body>
</html>