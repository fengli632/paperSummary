<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加论文类别</title>
</head>
<body>

	<div class=paper-box>
<span class="title-span">添加论文类别</span>
	<div class="paper-content">
	
		<sf:form method="post" modelAttribute="paperCategory">
		
		<span class="paper-text">
			类别名称 <span class="xing">＊</span>
		</span>
		<div class="input-field">
			<div class="input-field-content">
				<sf:input class="input-field" path="categoryName"/>  
			</div>
		</div> 

		 <div class="input-errors" > 
			<sf:errors path="categoryName" /> 
		 </div> 
		<br/> 
		
		<span class="paper-text">
			类别说明  
		</span>
		<div class="input-field">
			<div class="input-field-content">
				<sf:input class="input-field" path="categoryRemark"/>
			</div>
		</div>
		<br/> 
	
			 <input class="bt-submit-input" type="submit" value="提交" >

		  <br>
		</sf:form>
	</div>

	</div>
	
</body>
</html>  