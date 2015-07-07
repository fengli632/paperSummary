<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论文总结详情</title>

</head>
<body>

	<div class=paper-box>
<!-- <span class="title-span"></span> -->
	<div class="paper-content">
		<p class="p-title">
			 ${paperSummary.name }  
		</p>
		<p class="p-title2">
		<!-- 作者 期刊/会议 发布时间 信息 -->
			<span class="paper-atr"></span>${paperSummary.author }  &nbsp; &nbsp; ${paperSummary.periodical } &nbsp; &nbsp; ${paperSummary.publishTime }
		</p>
		<p class="p-info" >
			<span >类别：</span><a href="<%=request.getContextPath() %>/paper/${paperSummary.paperCategory.categoryId }/showPaperByCategory">${paperSummary.paperCategory.categoryName }</a> &nbsp;&nbsp;
			<span >关键字：</span>${paperSummary.keyWords } &nbsp; &nbsp;
			<span >重要性：</span>${paperSummary.significance }   &nbsp;&nbsp;
			<span >上传时间：</span>${paperSummary.addDate }   &nbsp;&nbsp;
			<span >上传人：</span><a href="<%=request.getContextPath() %>/paper/${paperSummary.paperUser.id}/showPaperByUser">${paperSummary.paperUser.nickname }</a> &nbsp;&nbsp;
		</p>
		<hr class="show-hr">
		<p class="p-content">
			<span class="paper-atr">目标:</span>
			${paperSummary.goal }
		</p>	
		<p class="p-content">
			<span class="paper-atr">方法:</span>
			${paperSummary.method }
		</p>
		<p class="p-content">
			<span class="paper-atr">结果:</span>
			${paperSummary.result }
		</p>
		<p class="p-content">
			<span class="paper-atr">不足之处:</span>
			${paperSummary.shortcomings }
		</p>
		<p class="p-content">
			<span class="paper-atr">展望:</span>
			${paperSummary.outlook }
		</p>
		<p class="p-content">
			<span class="paper-atr">思考:</span>
			${paperSummary.thought }
		</p>
		<br/> 
		
		 <c:choose >
			 <c:when test="${paperSummary.filePath == null||paperSummary.filePath == ''}">
			 	<p class="p-content">
					
				</p>
			 </c:when>	

			<c:otherwise>
				<p class="p-content">
				 	附件： <a href="<%=request.getContextPath() %>/paper/${paperSummary.id }/download ">${paperSummary.fileName}</a>
				 </p>
			</c:otherwise>	
		</c:choose> 
				
				 
	</div>
	</div>

</body>
</html>