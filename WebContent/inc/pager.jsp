<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="pager" class="page-view">
<pg:pager maxPageItems="10" items="${param.items }" export="curPage=pageNumber" url="${param.url }">
<%-- 	<span class="page-prev">
		<pg:last>
		共${param.items }记录,共${pageNumber }页,
		</pg:last>
		当前第${curPage }页
	</span> --%>
	<span class="page-prev">
		<pg:first>
			<a title="首页" href="${pageUrl }">首页</a>
		</pg:first>
	</span>
	<span class="page-prev">
		<pg:prev>
			<a title="上一页" href="${pageUrl }">上一页</a> 
		</pg:prev>
	</span>

<ul>
<pg:pages>
	<c:if test="${curPage eq pageNumber }">
		<li class="on">	
			[<strong>${pageNumber}</strong>]
		</li>
	</c:if>
	<c:if test="${curPage ne pageNumber }">
	<li> 
		<a href="${pageUrl }">${pageNumber }</a>
	</li>
	</c:if>
	</pg:pages>
</ul>

	<span class="page-next">
		<pg:last>
			<a title="尾页" href="${pageUrl }">尾页</a>
		</pg:last>
	</span>
		<span class="page-next">
		<pg:next>
			<a title="下一页" href="${pageUrl }">下一页</a>
		</pg:next>
	</span>
</pg:pager>
</div>