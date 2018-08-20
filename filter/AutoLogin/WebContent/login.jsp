<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<span>用户名:</span> <input type="text" name="username"><br/>
		<span style="margin-left:16px">密码:</span> <input type="password" name="password"> <br/>
		<input type="checkbox" name="autoLogin" value="autoLogin">自动登录  &nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="登录"> 
		<div>
		<%
		if (request.getAttribute("loginFaileMsg") != null) {
			%>
			<%=request.getAttribute("loginFaileMsg") %>
			<%
		}
		
		%>
		</div>
	</form>
</body>
</html>