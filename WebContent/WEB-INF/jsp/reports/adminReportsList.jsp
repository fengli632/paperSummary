<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>周报管理</title>

</head>
<body>
		<!--<div class="main main-index fn-clear">-->

		<div class="news">
			<!--<h1>新闻动态</h1>-->

			<div class="gray-box" style="margin-top: 80px">
				<div class="title ">
					<h2>周报列表</h2>
				</div>
				<div class="position-list-head">
					<span class="position-name">本周总结</span> <span class="position-type">提交人</span>
					<span class="position-place">周报时间</span> <span class="position-time">操作</span>
				</div>
				<ul class="position-list">
					<c:forEach items="${allReports.datas }" var="p">
					
						<li>
							<c:set var="str" value="${fn:substring(p.summary,0,30)}"/>
							<span class="position-name2" >${str}</span>
							<span class="position-type">
								<a href="<%=request.getContextPath()%>/reports/${p.reportsUser.id}/reportsList">
									${p.reportsUser.nickname }
								</a>
							</span> 
							
							<c:if test="${p.time == '' }">
								<span class="position-place">--未填写---</span>
							</c:if>
							<c:if test="${p.time != '' }">
								<span class="position-place">${p.time }</span> 
							</c:if>
							
							<span class="position-time">
								<a href="<%=request.getContextPath() %>/admin/reports/${p.id }/showReports">详情</a> &nbsp;
								<a href="<%=request.getContextPath() %>/admin/reports/${p.id}/updateReports">更新</a> &nbsp;
								<a href="<%=request.getContextPath() %>/admin/reports/${p.id}/deleteReports" onclick="return confirm('是否确认删除?')">删除</a> &nbsp;
							</span>
						</li>

					</c:forEach>


				</ul>
			</div>
			
	<!--分页  -->
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="reportsListAll" name="url"/>
			<jsp:param value="${allReports.total }" name="items"/>
		</jsp:include>

			<!-- <div id="pager" class="page-view"
				style="margin-top: 80px; margin-bottom: 50px">
				<span class="js-prev page-prev disabled"><a title="上一页"
					data-page="prev">上一页</a></span> <span class="js-next page-next"><a
					title="下一页" data-page="next">下一页</a></span>
				<ul>
					<li class="on"><a data-page="1">1</a></li>
					<li class=""><a data-page="2">2</a></li>
				</ul>
			</div> -->

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