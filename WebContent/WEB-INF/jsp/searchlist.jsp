
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="" lang="zh">
<head>

<title>搜索结果</title>

</head>
<body>
		<div class="inner news-center">
			<h1 >搜索结果</h1>
			<div class="js-content content">
				<div class="article">
				
				<div class="article-msg"> 
					搜索关键字：<span class="xing">${keyString } </span>
				</div>
					<div class="article-lists">
						<ul id="news-list">
						<c:if test="${searchResult.total le 0 }">
							<li class="fn-clear ">
								<h2>
									没有找到相关内容...
								</h2>
							</li>
						</c:if>
						<c:if test="${searchResult.total gt 0 }">
							<c:forEach items="${searchResult.datas }" var="p">
								<li class="fn-clear ">
								<h2>
									<a href="<%=request.getContextPath() %>/paper/${p.id }/show">${p.name }</a>
								</h2>
								<p class="public-date">
									<span style="color: #000">类别:</span> <a href="<%=request.getContextPath() %>/paper/${p.paperCategory.categoryId }/showPaperByCategory">${p.paperCategory.categoryName }</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
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
					
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="search" name="url"/>
			<jsp:param value="${searchResult.total }" name="items"/>
		</jsp:include>
				
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

		

</body>
</html>
