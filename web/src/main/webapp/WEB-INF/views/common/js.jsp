<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="static/js/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="static/js/bootstrap/3.3.0/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		var $nav = $("#navbar .nav:first");
		$nav.find("li").removeClass("active");
		if(currentPath){
			$nav.find("li a[href='"+currentPath+"']").parent().addClass("active");
		}
	});
</script>