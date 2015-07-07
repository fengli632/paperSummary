<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论文管理</title>

</head>
<body>
	

		<!--<div class="main main-index fn-clear">-->

		<div class="news">
			<!--<h1>新闻动态</h1>-->

			<div class="gray-box" style="margin-top: 80px">
				<div class="title bt-title" >
					<h2>论文列表 &nbsp;
					</h2>			
				</div>		
					
							<span class="title-bt-span">
								<a class="title-button" href="<%=request.getContextPath() %>/paperCategory/list">论文类别管理</a> 
								<a class="title-button" href="<%=request.getContextPath() %>/paper/addPaper">添加论文</a>  
							</span>
					
	
				<div class="position-list-head">
					<span class="position-name">标题</span> <span class="position-type">类别</span>
					<span class="position-place">上传人</span> <span class="position-time">操作</span>
				</div>
				<ul class="position-list">
					<c:forEach items="${paperSummaryList.datas }" var="p">
						<li>
						<c:set var="str" value="${fn:substring(p.name,0,30) }" />
							<span class="position-name2"><a href="<%=request.getContextPath() %>/admin/paper/${p.id }/show">${str}</a></span>
							<span class="position-type"><a href="<%=request.getContextPath() %>/paper/${p.paperCategory.categoryId }/showPaperByCategory">${p.paperCategory.categoryName }</a></span> 
							<span class="position-place"><a href="<%=request.getContextPath() %>/paper/${p.paperUser.id}/showPaperByUser">${p.paperUser.nickname }</a></span> 
							<span class="position-time">
								<a href="<%=request.getContextPath() %>/admin/paper/${p.id }/show">详情</a> &nbsp;
								<a href="<%=request.getContextPath() %>/admin/paper/${p.id}/update">更新</a> &nbsp;
								<a href="<%=request.getContextPath() %>/admin/paper/${p.id}/delete" onclick="return confirm('是否确认删除?')">删除</a> &nbsp;
							</span>
						</li>

					</c:forEach>


				</ul>
			</div>
			
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="adminPaperList" name="url"/>
			<jsp:param value="${paperSummaryList.total }" name="items"/>
		</jsp:include>

	

			<!--<div class="side-bar">
                <div class="faq-nav">
                    <div class="title">
                        <h3>常用链接</h3>
                    </div>
                    <ul>
                        <li><a href="news.htm">社区新闻</a></li>
                        <li><a href="#">社区通知</a></li>
                        <li><a href="#">社区论坛</a></li>
                        <li><a href="#">智慧家庭</a></li>
                        <li><a href="#">物业管理</a></li>
                        <li><a href="#">会所管理</a></li>
                        <li class="last"><a href="#">能源管理</a></li>

                    </ul>
                </div>
            </div>-->

		</div>
</body>
</html>