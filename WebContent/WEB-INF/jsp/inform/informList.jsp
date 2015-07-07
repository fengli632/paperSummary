<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知管理</title>

</head>
<body>
		<!--<div class="main main-index fn-clear">-->

		<div class="news">
			<!--<h1>新闻动态</h1>-->
			
			<c:if test="${informList.total le 0 }">
			
				<div class="gray-box" style="margin-top: 80px">
					<div class="title">
					还没有发布通知… 
					<a href="<%=request.getContextPath()%>/inform/informList">通知列表</a> &nbsp;&nbsp;
						<a href="<%=request.getContextPath()%>/inform/add">发布通知</a>
					</div>
				</div>
		
			</c:if> 
			<c:if test="${informList.total gt 0 }">
			<div class="gray-box" style="margin-top: 80px">
				<div class="title bt-title">
					<h2>
						通知列表  &nbsp;&nbsp;
						
					</h2>
				</div>
				
				<span class="title-bt-span"><a class="title-button" href="<%=request.getContextPath()%>/inform/add">发布通知</a></span>
				
				<div class="position-list-head">
					<span class="position-name">通知标题</span> <span class="position-type">内容概要</span>
					<span class="position-place">发布时间</span> <span class="position-time">操作</span>
				</div>
				<ul class="position-list">
					<c:forEach items="${informList.datas }" var="p">
						<c:set var="infoTitle" value="${fn:substring(p.infoTitle,0,30)}"/>
						<c:set var="infoContent" value="${fn:substring(p.infoContent,0,15)}"/>
						<li>
							
							<span class="position-name2" ><a href="<%=request.getContextPath() %>/inform/show/${p.infoId }">${infoTitle}</a></span>
							<span class="position-type">${infoContent }</span> 
							
							<c:if test="${p.infoTime == '' }">
								<span class="position-place">--未填写---</span>
							</c:if>
							<c:if test="${p.infoTime != '' }">
								<span class="position-place">${p.infoTime }</span> 
							</c:if>
							
							<span class="position-time">
								<a href="<%=request.getContextPath() %>/inform/show/${p.infoId }">详情</a> &nbsp;
								<a href="<%=request.getContextPath() %>/inform/admin/update/${p.infoId}">更新</a> &nbsp;
								<a href="<%=request.getContextPath() %>/inform/admin/delete/${p.infoId}" onclick="return confirm('是否确认删除?')">删除</a> &nbsp;
							</span>
						</li>

					</c:forEach>


				</ul>
			</div>
		</c:if>
	<!--分页  -->
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="informList" name="url"/>
			<jsp:param value="${informList.total }" name="items"/>
		</jsp:include>


		</div>
</body>
</html>