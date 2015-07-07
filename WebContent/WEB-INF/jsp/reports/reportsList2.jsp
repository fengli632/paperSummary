
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html id="" lang="zh">
<head>

<title>周报列表</title>

<style type="text/css">
	h2{
		font-size: 18px;
	}
	.article{
		margin-top: 100px;
	}
</style>
</head>
<body>
	<div style="" class="wrapper">

		<div class="inner news-center">
			 <!-- <h1 style="color: red">论文动态</h1>   -->
			<div class="js-content content">
				<div style="margin-top: 100px;" class="article">
					<div class="article-lists">
						<ul id="news-list">
						<c:if test="${loadByReportsUser.total le 0 }">
							<li class="fn-clear ">
								<h2>
									目前还没有周报...
								</h2>
							</li>
						</c:if> 
						 <c:if test="${loadByReportsUser.total gt 0 }">
							<c:forEach items="${loadByReportsUser.datas }" var="p"> 
								<li class="fn-clear ">
								<h2>
									<a href="">本周工作总结：</a>
								</h2> 
								<br>
								<p>${p.summary }</p>
								
								<br>
								<h2>
									<a href="">下周工作安排：</a>
								</h2>
								<br>
								<p>${p.plan }</p>
								<%-- <p class="public-date">
								<span style="color: #000">类别:</span> ${p.category } &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">期刊:</span> ${p.periodical } &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">上传人:</span> ${p.paperUser.nickname } &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">发布时间:</span> ${p.publishTime } 
								</p>
									<div class="article-content">
									<p>
										${p.goal }
									</p>
								</div> --%>
								<div style="float: right;">
								
								<span class="readmore2" href="">上传人: ${p.reportsUser.nickname } &nbsp;</span> 
								<span> 时间:&nbsp; ${p.time } &nbsp;&nbsp;</span>
								<a href="<%=request.getContextPath() %>/reports/${p.id}/updateReports">更新</a> &nbsp;
								<a href="<%=request.getContextPath() %>/reports/${p.id}/deleteReports" onclick="return confirm('是否确认删除?')">删除</a> &nbsp;
								<a class="readmore" href="<%=request.getContextPath() %>/reports/${p.id }/show">阅读更多&gt;</a>
								</div>
								 
							</li>
								
							</c:forEach>
							
						</c:if>	 										

						</ul>
					</div>
					
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="${loginUser.id}" name="url"/>
			<jsp:param value="${loadByReportsUser.total }" name="items"/>
		</jsp:include>
	
					
				</div>
				<div class="article-sider" style="margin-top: 100px;">
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

		</div>

</body>
</html>
