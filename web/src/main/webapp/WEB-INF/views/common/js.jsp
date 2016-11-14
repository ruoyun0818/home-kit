<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="static/js/jquery.min.js"></script>
<c:if test="${!empty param.fileinput}">
<script src="static/js/fileinput.min.js"></script>
</c:if>
<<c:if test="${!empty param.videojs }">
<script src="//vjs.zencdn.net/5.8/video.min.js"></script>
</c:if>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="static/js/bootstrap.min.js"></script>
<c:if test="${!empty param.fileinput}">
<script src="static/js/fileinput_locale_zh.js"></script>
<script type="text/javascript">
	(function ($) {
	    "use strict";
	    //上传插件在模式窗口中预览窗口显示问题
	    //解决方法:将预览窗口移动到BODY元素下
	    var $tmp=$.fn.fileinput.Constructor.prototype._initZoom
	    $.fn.fileinput.Constructor.prototype._initZoom=function(){
	    	var self = this;
			$tmp.call(self)
			if (self.$modal || self.$modal.length) {
				self.$modal.insertAfter("body:last")
			}
		};
	})(window.jQuery);
</script>
</c:if>