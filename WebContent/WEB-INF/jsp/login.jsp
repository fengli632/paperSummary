<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>

</head>
<body>
	<div class=login-box>

	<div class="login-content">
		<form id="form-login" name="form-login" method="post">
		<div class="login-username">
			 <div class="login-username-content">
				<!-- <span class="username"><em class="em-username">用户名：</em></span>  -->
				<!-- <i>邮箱/手机号</i> -->
				<input class="input-username" type="text" name="username" placeholder="请输入用户名"> 
			 </div> 
			
		</div>
		
		<br/> 
		<div class="login-username">
		<div class="login-username-content">
				<!-- <span class="username"><em class="em-password">密 &nbsp码:</em></span> -->
				<!-- <i>密码</i> -->
				<input class="input-username" type="password" name="password" placeholder="请输入密码"> 
			</div>

		</div>
		<br> 
		<div class="bt-blue">
			<!--  <input  type="submit" value="">  -->
			 <a class="bt-login" href="" name="submit" onclick="document.getElementById('form-login').submit();return false">登录</a>
			 
		  </div>
		 <div class="bt-gray">
			<a href="<%=request.getContextPath() %>/register">注册</a>
		 </div>
		 
		 
		</form>
	</div>
		


	</div>

</body>
</html>