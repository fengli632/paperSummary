<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知详情</title>

</head>
<body>

	<div class=paper-box>
<!-- <span class="title-span"></span> -->
	<div class="paper-content">
		<p class="p-title">
			${inform.infoTitle }
		</p>
		
		<p class="p-info" >
			<span>发布时间:</span> ${inform.infoTime }  &nbsp;&nbsp;
			<span >发布人:</span> ${inform.infoUser.nickname } 
		</p>
		<hr class="show-hr">
		<p class="p-content">
			${inform.infoContent }
		</p>	
		<br/> 
		
			<br/> 
		
		<c:choose>
			<c:when test="${inform.infoFilePath == null||inform.infoFilePath == ''}">
				<p class="p-content">
					
				</p>
			</c:when> 
			<c:otherwise>
				<p class="p-content">
					附件： <a href="<%=request.getContextPath() %>/inform/download/${inform.infoId } ">${inform.infoFileName}</a>
				</p>
			</c:otherwise> 
		</c:choose>
		
		
	</div>
	</div>

</body>
</html>