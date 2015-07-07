<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户[${loginUser.nickname }]详细信息</title>
</head>
<body>
	<div class="news">
			<!--<h1>新闻动态</h1>-->
			<div class="gray-box" style="margin-top: 80px">
				<div class="title">
				<h2>个人信息</h2>
				</div>
				<ul class="position-list">
				<li><span class="position-name2">我 【${loginUser.nickname }】共上传 ${loginUserPaper.total } 篇论文; ${loginUserReports.total } 篇周报。</span>   
					<span class="position-type"><a href="<%=request.getContextPath()%>/user/${loginUser.id}/update">个人信息</a></span>
					<span class="position-place"><a href="<%=request.getContextPath()%>/user/${loginUser.id}/changePassword">修改密码</a></span>
					<span class="position-time"><a href="<%=request.getContextPath()%>/reports/${loginUser.id}/reportsList">我的周报</a></span>
				</li>
				</ul>
			</div>

			<div class="gray-box" style="margin-top: 20px">
				<div class="title">
					<h2>论文列表</h2> 
				</div>
				<div class="position-list-head">
					<span class="position-name">标题</span> <span class="position-type">类别</span>
					<span class="position-place">上传人</span> <span class="position-time">操作</span>
				</div>
				<ul class="position-list">
					<c:forEach items="${loginUserPaper.datas }" var="p">
						<li><span class="position-name2"><a href="<%=request.getContextPath()%>/paper/${p.id }/show">${p.name }</a></span>
							<span class="position-type"><a href="<%=request.getContextPath() %>/paper/${p.paperCategory.categoryId }/showPaperByCategory">${p.paperCategory.categoryName }</a></span> 
							<span class="position-place">${p.paperUser.nickname }</span> 
							<span class="position-time"><a href="<%=request.getContextPath()%>/paper/${p.id}/update">更新</a>&nbsp;
							<a href="<%=request.getContextPath()%>/paper/${p.id}/delete" onclick="return confirm('是否确认删除?')">删除</a>
							</span>
						</li>

					</c:forEach>

				</ul>
			</div>

		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="${loginUser.id}" name="url"/>
			<jsp:param value="${loginUserPaper.total }" name="items"/>
		</jsp:include>

		</div>
</body>
</html>  