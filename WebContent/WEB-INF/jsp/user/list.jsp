<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表页面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/tab.css">
	<style type="text/css">
		.tabcell2{
			width:200px;
		}
	</style>
</head>
<body>

	<div class="tab-box">
		<div class="list-box">
			<div class="list-head" style="margin: 0px auto;">
				<c:if test="${not empty loginUser }">
				
					<span class="tabcell"> <a href="<%=request.getContextPath()%>/admin/user/add">添加管理员</a> </span> 
					<span class="tabcell"> <a href="<%=request.getContextPath()%>/admin/user/users">用户列表</a> </span>
					<span class="tabcell"> <a href="<%=request.getContextPath()%>/logout">退出系统</a> </span>
					<span class="tabcell"> 当前用户:${loginUser.nickname } </span>
					<span class="tabcell2">  1为管理员；2为普通用户</span>

				</c:if>

			</div>
			<div class="list-head">
				<span class="tabcell">用户标识</span> 
				<span class="tabcell">用户名</span> 
				<span class="tabcell">用户姓名</span>
				<!-- <span class="tabcell">用户密码</span>  -->
				<span class="tabcell2">用户邮箱</span> 
				<span class="tabcell">用户类型</span>
				<span class="tabcell">操作</span>
			</div>
			<c:if test="${pagers.total le 0 }">
				<td colspan="6">目前还没有用户数据</td>
			</c:if>
			<ul class="list-content">
				<c:if test="${pagers.total gt 0 }">
					<c:forEach items="${pagers.datas }" var="u">
						<li><span class="tabcell">${u.id}</span> 
						    <span class="tabcell">${u.username}</span> 
						    <span class="tabcell">${u.nickname}</span> 
						    <%-- <span class="tabcell">${u.password}</span> --%>
						    <c:if test="${u.email == '' }">
						    	<span class="tabcell2">--- 未填写 --- </span>
						    </c:if>
						    <c:if test="${u.email != '' }">
						    	<span class="tabcell2" >${u.email}</span> 
						    </c:if>
							 <span class="tabcell">${u.userType}</span> 
							<span class="tabcell">
								<a href="${u.id }/update">更新</a> &nbsp; 
								<a href="${u.id }/delete" onclick="return confirm('是否确认删除?')">删除</a>
							</span>
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
		
		
	</div>
	
	<div style="width: 1120px;margin:0px auto 40px;"> 
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="users" name="url"/>
			<jsp:param value="${pagers.total }" name="items"/>
		</jsp:include>
	</div>
	
<!-- 	 <div id="pager" class="page-view" style="width:1160px;margin-bottom: 40px;">
						<span class="js-prev page-prev disabled">
							<a title="上一页" data-page="prev">上一页</a>
						</span> 
						<span class="js-next page-next">
							<a title="下一页" data-page="next">下一页</a>
						</span> 
						<ul>
							<li class="on"><a data-page="1">1</a></li>
							<li class=""><a data-page="2">2</a></li>
						</ul>
					</div>  -->
</body>
</html>