<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>控制台</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/top_nav.jsp" />
	<div class="container">
	    <a href="<%=request.getContextPath()%>/static/html/audio.html">音乐播放器</a>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</div>
	<!-- /container -->
	<jsp:include page="/WEB-INF/views/common/js.jsp" />
</body>
</html>