<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>错误页面</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/csshide1.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/abprule.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/tab.css">

</head>
<body>
<div style="" class="wrapper">
		<div class="layout-header">
			<div class="header-top-wrapper">
				<div class="header-wrapper">
					<div class="header-container fn-clear">
						<a href="#" class="logo"> 
						<img src="<%=request.getContextPath()%>/content/logobig3.png"  alt="paperSummary" 
							height="60" width="300">
						</a>
						<div class="nav-list js-nav-list">
						<c:if test="${loginUser.username =='admin' }">
							<ul>
								<li class="on"><a href="<%=request.getContextPath() %>/paper/paperHome"><span>网站首页</span> </a></li>
								<li><a href="<%=request.getContextPath() %>/admin/paper/adminPaperList"><span>论文管理</span> </a></li>
								<li><a href="<%=request.getContextPath() %>/admin/reports/reportsListAll"><span>周报管理</span> </a></li>
								<li><a href="<%=request.getContextPath() %>/user/"><span>用户管理</span> </a></li>
								<li><a href="<%=request.getContextPath() %>/search"><span>搜索论文</span> </a></li>					
							</ul>
						</c:if>
						 <c:if test="${loginUser.username !='admin' or empty loginUser }"> 
							<ul>
								<li class="on"><a href="<%=request.getContextPath() %>/paper/paperHome"><span>首页</span> </a></li>
								<li><a href="<%=request.getContextPath() %>/paper/addPaper" target=""><span>添加论文</span> </a></li>
								<li><a href="<%=request.getContextPath() %>/paper/paperList"><span>论文列表</span> </a></li>
								<li><a href="<%=request.getContextPath() %>/search"><span>搜索论文</span> </a></li>
								<li><a href="<%=request.getContextPath() %>/reports/addReports"><span>提交周报</span> </a></li>
								<%-- <li><a href="<%=request.getContextPath() %>/reports/reportsList/${loginUser.id}"><span>我的周报</span> </a></li> --%>
							</ul>
						</c:if> 
							
							
							<div class="buy-col">
							<c:if test="${not empty loginUser }">
								<span><a href="<%=request.getContextPath() %>/user/${loginUser.id}" target="_blank"> ${loginUser.nickname }</a></span>
								<a class="buy-button" href="<%=request.getContextPath() %>/logout" > <span>注销</span></a> 
							</c:if>
							<c:if test="${empty loginUser }">
								<a href="<%=request.getContextPath() %>/login" "><span>登录</span> </a>
								<a  class="buy-button" href="<%=request.getContextPath() %>/register"><span>注册</span></a>
								
							</c:if>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		
<div style="margin: 0px auto;">
	<div class="search-box">

	
		<img alt="404" src="<%=request.getContextPath() %>/image/404.png" width="600px" height="306px">
		<!-- <h1 style="font-size: 60px">404 NOT FOND</h1> -->
		<br>
		
		<h1 style="font-size: 24px;">请更换IE8内核以上的浏览器!</h1>
		<br>
		<h1 style="font-size: 20px;"> 或者FireFox,Chrome,Opera,遨游等支持HTML5兼容性更好的浏览器.</h1>

	</div>
</div>
<!-- <div align="center" style="width:100%;border-top:1px solid; float:left;margin-top:10px;">
	CopyRight@2014<br/>
	西安交通大学
</div> -->
<div class="footer">
			<div class="service">
				<div class="inner">
					<div class="info">
						<ul>
							<li>
								<h3>学校资源</h3>
							</li>
							<li><a href="http://www.xjtu.edu.cn/"  target="_blank">交通大学</a></li>
							<li><a href="http://www.lib.xjtu.edu.cn/"  target="_blank">钱学森图书馆</a></li>
							<li><a href="http://nav.lib.xjtu.edu.cn/database/index.do"  target="_blank">网络数据库导航 </a></li>
						</ul>
						<ul>
							<li>
								<h3>中文资源</h3>
							</li>
							<li><a href="http://www.cnki.net/" target="_blank">中国知网</a></li>
							<li><a href="http://www.wanfangdata.com.cn/"  target="_blank">万方数据</a></li>
							<li><a href="http://xueshu.baidu.com/"  target="_blank">百度学术</a></li>
						</ul>
						<ul>
							<li>
								<h3>外文资源</h3>
							</li>
							<li><a href="http://www.isiknowledge.com" target="_blank">Web of Knowledge</a></li>
							<li><a href="http://ieeexplore.ieee.org/Xplore/home.jsp" target="_blank">IEEE Xplore Digital Library</a></li>
							<li><a href="http://dl.acm.org/" target="_blank">ACM Digital Library</a></li>
						</ul>
					</div>
					<!-- <div class="online">
						<p class="fn-clear" data-service-dom="live800" data-label="在线咨询"
							add-custom-service-module="">
							<a data-log="purchase|consult" class="online-services">在线咨询</a>
						</p>
						<p class="tel">
							<a href="tel:18729345982">18729345982</a>
						</p>
						<p>周一至周日 9:00-18:00</p>
					</div> -->
				</div>
			</div>
			<div class="copyright">
				<div class="inner fn-clear">
					<div class="copy-label">
						<div class="copy-text">Copyright © 2015, XJTU-SE . All Rights Reserved. 交通大学版权所有</div>
						
					</div>
					<!-- <ul class="footer-clause">
						<li><a href="#/agreement">网站使用条款</a></li>
						<li class="line"></li>
						<li><a href="#/privacy">隐私条款</a></li>
					</ul> -->
					<ul class="sns">
						<li><a href="http://weibo.com/lifeng632" target="_blank"
							class="weibo">新浪微博</a>
						</li>
						<li class="weixin" show-weixin-code=""><a class="weixin">微信</a>
							<div class="dimensional-code">
								<img src="<%=request.getContextPath()%>/content/weixin.png" alt="二维码">
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div style="display: block;" class="backTop"></div>
	</div>
	<!-- <script id="tempBeforeLogin" type="application/template">
	<a data-log="account|login" id="login" class="normal-link js-show-login">登录</a>
    <a  data-log="account|register" id="register" class="normal-link line-link js-show-register">注册</a>
	</script>
	 -->


	<div class="module-dialog-layer"></div>
</body>
</html>