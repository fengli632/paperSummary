<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类别[${paperCategoryShow.categoryName }]</title>
</head>
<body>
	<div class="news">

			<div class="gray-box" style="margin-top: 20px">
				<div class="title">
					<h2>类别:  ${paperCategoryShow.categoryName }  </h2> 
				</div>
				<div class="position-list-head">
					<span class="position-name">标题</span> <span class="position-type">类别</span>
					<span class="position-place">上传人</span> <span class="position-time">发表时间</span>
				</div>
				<ul class="position-list">
					<c:forEach items="${papersByCategory.datas }" var="p">
						<li>
						<c:set var="str" value="${fn:substring(p.name,0,30)}"/>
						<span class="position-name2"><a href="<%=request.getContextPath() %>/paper/${p.id }/show">${str }</a></span>
						<span class="position-type">${p.paperCategory.categoryName }</span> 
						<span class="position-place"><a href="<%=request.getContextPath() %>/paper/${p.paperUser.id}/showPaperByUser" target="_blank">${p.paperUser.nickname }</a></span> 
						<span class="position-time">${p.publishTime }</span></li>

					</c:forEach>

				</ul>
			</div>

		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="show" name="url"/>
			<jsp:param value="${papersByCategory.total }" name="items"/>
		</jsp:include>

		</div>
</body>
</html>  