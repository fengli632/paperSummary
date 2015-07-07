<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html id="" lang="zh">
<head>
<title>论文总结周报提交系统</title>

<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/content/main.css">
<script src="<%=request.getContextPath()%>/content/linkid.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/content/hm.htm"></script>
<script src="<%=request.getContextPath()%>/content/preload.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/content/csshide1.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/content/abprule.css">
 --%>
</head>
<body>
	<!-- <div style="" class="wrapper"> -->

		<div class="inner news-center">
			<h1 >通知</h1>
			<div class="js-content content">
				<div class="article">
					<div class="article-lists">
						<ul id="news-list">
						<c:if test="${informPager.total le 0 }">
							<li class="fn-clear ">
								<h2>
									目前还没有发布通知...
								</h2>
							</li>
						</c:if>
						<c:if test="${informPager.total gt 0 }">
							<c:forEach items="${informPager.datas }" var="p">
								<li class="fn-clear ">
								<h2>
									<a href="<%=request.getContextPath()%>/inform/show/${p.infoId }">${p.infoTitle }</a>
								</h2>
								<p class="public-date">
				
								<span style="color: #000">发布人:</span> ${p.infoUser.nickname } &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">发布时间:</span> ${p.infoTime } 
								</p>
								<div class="article-content">
								<c:set var="infoContent" value="${fn:substring(p.infoContent,0,30)}"/>
									<p>
										${infoContent }
									</p>
								</div> <a class="readmore" href="<%=request.getContextPath() %>/inform/show/${p.infoId }">阅读更多&gt;</a>
							</li>
								
							</c:forEach>
							
						</c:if>												

						</ul>
					</div>
					
					<!--分页  -->
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="informHome" name="url"/>
			<jsp:param value="${informPager.total }" name="items"/>
		</jsp:include>
					
					<!-- <div id="pager" class="page-view">
						<span class="js-prev page-prev disabled">
						<a title="上一页" data-page="prev">上一页</a></span> 
						<span class="js-next page-next">
						<a title="下一页" data-page="next">下一页</a></span>
						<ul>
							<li class="on"><a data-page="1">1</a></li>
							<li class=""><a data-page="2">2</a></li>
						</ul>
					</div> -->
					
					
				</div>
				<div class="article-sider">
					<div class="faq-nav">
						<div class="title">
							<h3 id="showAll">数据库导航</h3>
						</div>
						<ul id="archive">
							
							<li class=""><a href="http://www.cnki.net/ " target="_blank">中国知网</a></li>
							<li class=""><a href="http://www.isiknowledge.com" target="_blank">Web of Knowledge</a></li>
							<li class=""><a href="http://dl.acm.org/" target="_blank">ACM Digital Library</a></li>
							<li class=""><a href="http://ieeexplore.ieee.org/Xplore/home.jsp" target="_blank">IEEE/IEE </a></li>
							<li class=""><a href="http://link.springer.com/" target="_blank">SpringerLink</a></li>
							<li class="last"><a href="http://www.sciencedirect.com/" target="_blank">Elsevier</a></li>
							
							
						</ul>
					</div>
				</div>
			</div>
		</div>
 <div class="to-top">
	<a href="javascript:scroll(0,0)" >
		<img alt="返回顶部" src="<%=request.getContextPath() %>/image/to-top.png">
	</a>
</div> 
		<!-- </div>-->

</body>
</html>
