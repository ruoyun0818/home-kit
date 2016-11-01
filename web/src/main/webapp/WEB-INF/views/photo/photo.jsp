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
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
		  上传图片
		</button>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</div>
	<!-- /container -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel"> 上传图片</h4>
	      </div>
	      <div class="modal-body">
	        <input id="up_file" name="file" type="file" class="file" multiple />
	      </div>
	      <div class="modal-footer">
	      </div>
	    </div>
	  </div>
	</div>
	<jsp:include page="/WEB-INF/views/common/js.jsp?fileinput=1" />
	<script type="text/javascript">
		$("#up_file").fileinput({
			language:'zh',
			uploadUrl:'photo/save',
			allowedFileTypes:['image', 'video', 'audio'],
			showUpload: true, //是否显示上传按钮
			showCaption: false,//是否显示标题
			showClose: false,
			showUploadedThumbs: false,
			removeFromPreviewOnError: true,
			//maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
			//minFileCount: 0,
			maxFileCount: 10, //表示允许同时上传的最大文件个数
			enctype: 'multipart/form-data',
			validateInitialCount:true,
			msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		});
	</script>
</body>
</html>