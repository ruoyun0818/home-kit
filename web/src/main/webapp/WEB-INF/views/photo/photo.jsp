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
		<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" data-backdrop="false">
		  上传图片
		</button>
		<br/>
		<input id="photo" type="file" />
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
	        <input id="up_file" name="file" type="file" multiple />
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
			showClose: false,
			showUploadedThumbs: false,//是否显示上传完成的图片,false在另外选择上传文件后会清空已上传完成的图片
			removeFromPreviewOnError: true,
			maxFileSize: 31744,//单位为kb，如果为0表示不限制文件大小
			maxFileCount: 10, //表示允许同时上传的最大文件个数
			enctype: 'multipart/form-data',
			validateInitialCount:true,
			msgFilesTooMany: "允许最大上传的文件数量({n})！",
			previewSettings : {
        	    image: {width: "213px", height: "160px"},
        	    video: {width: "213px", height: "160px"},
        	    audio: {width: "213px", height: "80px"},
        	    flash: {width: "213px", height: "160px"},
        	}
		});
		$("#photo").fileinput({
			language:'zh',
			showUpload:false,
			showClose:false,
			allowedFileTypes:['image', 'video', 'audio'],
			previewSettings : {
        	    image: {width: "213px", height: "160px"},
        	    video: {width: "213px", height: "160px"},
        	    audio: {width: "213px", height: "80px"},
        	    flash: {width: "213px", height: "160px"},
        	},
        	initialPreviewFileType:"video/mp4",
        	initialPreview: [
				"<video class='kv-preview-data' width=\"213px\" height=\"160px\" controls>\n"
				+"<source src='res/photo/1477993959207.mp4' type='video/mp4'/>\n"
				+"Your browser does not support HTML5 video.\n</video>",
				
             ],
		});
	</script>
</body>
</html>