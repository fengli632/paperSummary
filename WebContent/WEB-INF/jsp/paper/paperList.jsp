<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>论文管理</title>
</head>
<body>


		<div class="news">
			<!--<h1>新闻动态</h1>-->

			<div class="gray-box" style="margin-top: 80px">
				<div class="title">
					<h2>论文列表</h2>
				</div>
				<div class="position-list-head">
					<span class="position-name">标题</span> <span class="position-type">类别</span>
					<span class="position-place">上传人</span> <span class="position-time">发表时间</span>
				</div>
				<ul class="position-list">
					<c:forEach items="${paperSummaryList.datas }" var="p">
						<li>
						<c:set var="str" value="${fn:substring(p.name,0,30)}"/>
						<span class="position-name2"><a href="<%=request.getContextPath() %>/paper/${p.id }/show">${str }</a></span>
						<span class="position-type"><a href="<%=request.getContextPath() %>/paper/${p.paperCategory.categoryId }/showPaperByCategory">${p.paperCategory.categoryName }</a></span> 
						<span class="position-place"><a href="<%=request.getContextPath() %>/paper/${p.paperUser.id}/showPaperByUser" target="_blank">${p.paperUser.nickname }</a></span> 
						<span class="position-time">${p.publishTime }</span></li>

					</c:forEach>


				</ul>
			</div>

		<!--分页  -->
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="paperList" name="url"/>
			<jsp:param value="${paperSummaryList.total }" name="items"/>
		</jsp:include>

		</div>
</body>
</html>