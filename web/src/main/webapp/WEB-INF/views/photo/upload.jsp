<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>上传</title>
<jsp:include page="/WEB-INF/views/common/head.jsp?fileinput=1" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/top_nav.jsp?p=photo" />
	<div class="container">
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" data-backdrop="false">
		  上传图片
		</button>
		<br/>
		<input id="photo" type="file" />
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</div>
	<!-- /container -->
	<jsp:include page="/WEB-INF/views/common/js.jsp?fileinput=1" />
	<script type="text/javascript">
		$("#photo").fileinput({
			language:'zh',
			uploadUrl:'photo/save',
			allowedFileTypes:['image', 'video', 'audio'],
			showUpload: true, //是否显示上传按钮
			showClose: false,
			showUploadedThumbs: false,//是否显示上传完成的图片,false在另外选择上传文件后会清空已上传完成的图片
			removeFromPreviewOnError: true,
			maxFileSize: 31744,//单位为kb，如果为0表示不限制文件大小
			maxFileCount: 10, //表示允许同时上传的最大文件个数
			enctype: 'multipart/form-data',
			validateInitialCount:true,
			msgFilesTooMany: "允许最大上传的文件数量({n})！",
			previewSettings : {
        	    image: {width: "240px", height: "160px"},
        	    video: {width: "240px", height: "160px"},
        	    audio: {width: "240px", height: "80px"},
        	    flash: {width: "240px", height: "160px"},
        	}
		});
	</script>
</body>
</html>