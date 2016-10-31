<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>相册</title>
<jsp:include page="/WEB-INF/views/common/head.jsp?fileinput=1" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/top_nav.jsp?p=photo" />
	<div class="container">
		<input id="up_file" type="file" class="file" data-preview-file-type="text" multiple />
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</div>
	<!-- /container -->
	<jsp:include page="/WEB-INF/views/common/js.jsp?fileinput=1" />
	<script type="text/javascript">
		$(function() {
			//上传
		});
	</script>
</body>
</html>