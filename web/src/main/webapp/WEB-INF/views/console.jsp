<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>控制台</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/top_nav.jsp" />
	<div class="container">
		<a href="audio">音乐播放器</a>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</div>
	<!-- /container -->
	<jsp:include page="/WEB-INF/views/common/js.jsp" />
</body>
</html>