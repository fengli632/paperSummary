<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布通知</title>

</head>
<body>

	<div class=paper-box>
<span class="title-span">发布通知</span>
	<div class="paper-content">
		<sf:form method="post" modelAttribute="inform" enctype="multipart/form-data"> 

		<p class="paper-text">通知标题:</p>
		<!-- 	 <textarea id="container1" name="infoTitle"></textarea>  -->
			 <sf:textarea  class="sf-textarea-sm" path="infoTitle"/> <sf:errors path="infoTitle"/>  
		<br/> 
		
		<p class="paper-text">通知内容:</p>
			<%-- <sf:textarea class="sf-textarea" path="infoContent"/>  <sf:errors path="infoContent"/>  --%>
			<textarea id="container1" name="infoContent"></textarea>  
		
		<br/> 
		
<%-- 		<p class="paper-text">通知时间:</p>
		<div class="input-field">
			<div class="input-field-content">
				<sf:input class="input-field" path="infoTime"/> 
				
			</div>
		</div>
		<br/> 
		<br/>  --%>
		
		<p class="paper-text">上传附件:</p>
 		<div class="search-input">		
				<div class="upload">
					<input class="search-input-content" type="file" name="attach"  >
				</div>		
		</div>
		<br><br><br><br>

				<input  class="bt-submit-input" type="submit" value="提交">

		</sf:form> 
	</div>
	</div>

<!--Ueditor 配置文件 -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/ueditor/ueditor.all.js"></script>
	<script type="text/javascript">	
		var tbs = [
           	['FullScreen', 'Source','|', 'Undo', 'Redo','|',
           		'fontfamily', 'fontsize', 'insertcode', '|',
           		'bold','test', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript','removeformat','formatmatch','autotypeset', 'blockquote','pasteplain', '|', 
           		'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc','|',
           		'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
           		
           		/* 'directionalityltr', 'directionalityrtl', 'indent', '|',
           		'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 
           		'link', 'unlink', 'anchor', '|',
           		'simpleupload', 'insertimage', '|','emotion', 'scrawl', 'insertvideo', 'music',  'map',  '|',
           		'horizontal', 'date', 'time', '|',
           		'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
           	 	'print', 'preview', 'searchreplace','|' */
           	]    
               ];
        var editor = UE.getEditor('container1',{
                //这里可以选择自己需要的工具按钮名称,此处仅选择如下五个
         		toolbars:tbs,
                //focus时自动清空初始化时的内容
                //autoClearinitialContent:true,
               // 关闭字数统计
                wordCount:false,
                //关闭elementPath
                elementPathEnabled:false,
               // 默认的编辑区域高度
                initialFrameHeight:150,
                initialFrameWidth:1000
               //  更多其他参数，请参考ueditor.config.js中的配置项
            });
      
       </script>

</body>
</html>