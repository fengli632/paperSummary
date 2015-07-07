<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>

	<div class=paper-box>
<span class="title-span">${user.nickname }:修改密码</span>
	<div class="paper-content">
	
		<sf:form method="post" modelAttribute="user">

		<span class="paper-text">
			用户名
		</span>
		<div class="input-field">
			<div class="input-field-content">
			 	<span class="input-locked"> ${user.username  }  </span> 
			 	<sf:hidden  path="username"/>  
			 	<sf:hidden  path="nickname"/>  
			 	<sf:hidden path="userType"/>
			</div>
		</div> 
		<br/> 
		
	 	<span class="paper-text">
			原始密码  
		</span>
		<div class="input-field">
			<div class="input-field-content">
				<input type="password" class="input-field" name="newPassword" />
			</div>
		</div>
		<div class="input-errors" >
			${msg }
		</div>
		<br/>  
		
		<span class="paper-text">
			请输入新密码  
		</span>
		<div class="input-field">
			<div class="input-field-content">
				<sf:password class="input-field" path="password"/>
			</div>
		</div>
		<div class="input-errors" >
			<sf:errors path="password" />
		</div>
		<br/> 

			<input class="bt-submit-input" type="submit" value="提交" > 
			<%-- <div class="bt-submit" style="float: right;">
				<a href="<%=request.getContextPath() %>/user/${user.id }/changePassword" >修改密码</a>
			</div> --%>
			
		  <br>
		</sf:form>
	</div>

	</div>
	
</body>
</html>  