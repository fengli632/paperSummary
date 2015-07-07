<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索</title>

</head>
<body>

	<div class="search-box">

	<div class="search-content">
		<form id="form-search" name="form-search" method="post">
		<div class="search-input">
			<!-- <div class="search-input-content"> -->
				<!-- <span class="username"><em class="em-username">用户名：</em></span> -->
				
				<input class="search-input-content" type="text" name="keyString" placeholder="请输入关键字" siz="18">
				
				<!-- HTML5属性: placeholder="请输入关键字" siz="18" -->
			<!-- </div> -->
			
		</div>
		<div class="bt-search" >
			 <a  href="" name="submit" onclick="document.getElementById('form-search').submit();return false">搜索</a>
		  </div>
 
		</form>
	</div>
	


	</div>

</body>
</html>