
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html id="" lang="zh">
<head>
<title>PaperSummary</title>

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
			<h1 >论文动态</h1>
			<div class="js-content content">
				<div class="article">
					<div class="article-lists">
						<ul id="news-list">
						<c:if test="${paperSummaryList.total le 0 }">
							<li class="fn-clear ">
								<h2>
									目前还没有论文...
								</h2>
							</li>
						</c:if>
						<c:if test="${paperSummaryList.total gt 0 }">
							<c:forEach items="${paperSummaryList.datas }" var="p">
								<li class="fn-clear ">
								<h2>
									<a href="<%=request.getContextPath()%>/paper/${p.id }/show">${p.name }</a>
								</h2>
								<p class="public-date">
								<span style="color: #000">类别:</span> <a href="<%=request.getContextPath() %>/paperCategory/${p.paperCategory.categoryId }/show"> ${p.paperCategory.categoryName } </a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">期刊:</span> ${p.periodical } &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">上传人:</span> ${p.paperUser.nickname } &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">发布时间:</span> ${p.publishTime } 
								</p>
								<div class="article-content">
									<p>
										${p.goal }
									</p>
								</div> <a class="readmore" href="<%=request.getContextPath() %>/paper/${p.id }/show">阅读更多&gt;</a>
							</li>
								
							</c:forEach>
							
						</c:if>												

						</ul>
					</div>
					
					
					<div id="pager" class="page-view">
						<span class="js-prev page-prev disabled">
						<a title="上一页" data-page="prev">上一页</a></span> 
						<span class="js-next page-next">
						<a title="下一页" data-page="next">下一页</a></span>
						<ul>
							<li class="on"><a data-page="1">1</a></li>
							<li class=""><a data-page="2">2</a></li>
						</ul>
					</div>
					
					
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

		<!-- </div>-->

</body>
</html>
