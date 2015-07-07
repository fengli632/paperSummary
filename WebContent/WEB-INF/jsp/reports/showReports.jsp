<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>周报详情</title>

	<style type="text/css">
	
	.search-input{
		display: table;
		
	}
	.upload{
		vertical-align: middle;
		display: table-cell;
		
	}
	</style>
</head>
<body>

	<div class=paper-box>
<!-- <span class="title-span">周报详情</span> -->
	<div class="paper-content">
		<p class="p-title">
			周报：  【${weeklyReports.reportsUser.nickname }】 &nbsp;&nbsp; ${weeklyReports.time }
		</p>
		<hr class="show-hr">

		<div >
		<div class="paper-atr">本周工作总结:</div>
			<div class="p-content">
				${weeklyReports.summary }
			</div>
		</div>
		<br/> 
		<div class="paper-atr">下周工作预期:</div>
			<div class="p-content">
				${weeklyReports.plan }
			</div>
		</div>
		
		<br/> 
		<c:choose>

			<c:when test="${weeklyReports.reportsFilePath == null||weeklyReports.reportsFilePath == ''}">
				<p class="p-content">
					---
				</p>
			</c:when> 
			<c:otherwise>
				<p class="p-content">
					附件： <a href="<%=request.getContextPath() %>/reports/${weeklyReports.id }/download ">${weeklyReports.fileName}</a>
				</p>
			</c:otherwise> 
		</c:choose>
	</div>
	

</body>
</html>