<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论文类别管理</title>
<style type="text/css">
	.position-name{
		width:100px;
	}
	.position-type,.position-time{
		width: 250px;
	}
	.position-place{
		width:400px;
	}
	.position-list-head , .position-list{
		text-align:center;
	}
</style>
</head>
<body>
		<!--<div class="main main-index fn-clear">-->

		<div class="news">
			<!--<h1>新闻动态</h1>-->

			<div class="gray-box" style="margin-top: 80px">
				<div class="title bt-title">
					<h2>论文类别管理 &nbsp;&nbsp;&nbsp; 
					</h2> 
				</div>
				
				<span class="title-bt-span"> 
					<a class="title-button" href="<%=request.getContextPath()%>/paperCategory/add">添加类别</a>
				 </span> 
				<%-- <c:if test="${categoryList le 0 }">
					<div class="fn-clear">
						目前还没有论文类别
					</div>
				</c:if> --%>
				
				<%-- <c:if test="${categoryList.total gt 0 }"> --%>
				<div class="position-list-head">
					<span class="position-name">类别ID</span> <span class="position-type">类别名称</span>
					<span class="position-place">备注</span> <span class="position-time">操作</span>
				</div>
				<ul class="position-list">
					<c:forEach items="${categoryList.datas }" var="p">
						<li>
						<c:set var="categoryName" value="${fn:substring(p.categoryName,0,30) }" />
						<c:set var="categoryRemark" value="${fn:substring(p.categoryRemark,0,40) }" />
							<span class="position-name">${p.categoryId }</span>
							<span class="position-type">
								<a href="<%=request.getContextPath() %>/paperCategory/${p.categoryId }/show">${p.categoryName}</a>
							</span> 
							<%-- <c:if test="${categoryRemark.length } gt 15 ">
								${categoryRemark} = ${categoryRemark} +"..."
							</c:if>
							 --%>
							<span class="position-place">${categoryRemark}</span> 
							<span class="position-time">
								<%-- <a href="<%=request.getContextPath() %>/paper/${p.categoryId }/showPaperByCategory">详情1</a> &nbsp; --%>
								<a href="<%=request.getContextPath() %>/paperCategory/${p.categoryId }/show">详情</a> &nbsp;
								<a href="<%=request.getContextPath() %>/paperCategory/${p.categoryId}/update">更新</a> &nbsp;
								<a href="<%=request.getContextPath() %>/paperCategory/${p.categoryId}/delete" onclick="return confirm('是否确认删除?')">删除</a> &nbsp;
							</span>
						</li>
					</c:forEach>
				</ul>
				<%-- </c:if> --%>
			</div>
			
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="list" name="url"/>
			<jsp:param value="${categoryList.total }" name="items"/>
		</jsp:include>

		</div>
</body>
</html>