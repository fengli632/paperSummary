
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="" lang="zh">
<head>
<title>论文总结详情</title>
</head>
<body>
		<div class="inner news-center">
			<h1 style="color: red">论文动态</h1>
			<div class="js-content content">
				<div class="article">
					<div class="article-lists">				
								
								<h2>
									<a href="">${paperSummary.name }</a>
								</h2>
								<p class="public-date">
								<span style="color: #000">类别:</span> <a href="<%=request.getContextPath() %>/paper/${paperSummary.paperCategory.categoryId }/showPaperByCategory">${paperSummary.paperCategory.categoryName }</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">期刊/会议:</span> ${paperSummary.periodical } &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">上传人:</span> ${paperSummary.paperUser.nickname } &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<span style="color: #000">发布时间:</span> ${paperSummary.publishTime } 
								</p>
								<div class="article-content">
									<p><span style="color: #000">关键字:</span></p>
									<p class="p-content">${paperSummary.keyWords }</p>
								
									<p><span style="color: #000">目标(论文要解决的问题):</span></p>
									<p class="p-content" >${paperSummary.goal }</p>
									
									<p><span style="color: #000">方法:(何种算法？如何解决的的？):</span></p>
									<p class="p-content">${paperSummary.method }</p>
									
									<p><span style="color: #000">结果:(***性能提升了多少？):</span></p>
									<p class="p-content">${paperSummary.result }</p>
									
									<p><span style="color: #000">不足之处:(到底哪些地方存在缺陷):</span></p>
									<p class="p-content">${paperSummary.shortcomings }</p>
									
									<p><span style="color: #000">展望:(还未完成的事情有哪些？):</span></p>
									<p class="p-content">${paperSummary.outlook }</p>
									
									<p><span style="color: #000">重要性::</span></p>
									<p class="p-content">${paperSummary.significance }</p>
									
									<p><span style="color: #000">思考:(自己对于这篇论文的看法):</span></p>
									<p class="p-content">${paperSummary.thought }</p>
									
									<p><span style="color: #000">下载论文:</span></p>
									<p class="p-content"><a href="${paperSummary.filePath }">${paperSummary.filePath }</a></p>
								</div> 
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

</body>
</html>
