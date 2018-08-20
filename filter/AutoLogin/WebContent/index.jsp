<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<div style="padding:30px;border:2px solid black;">
	<span style="text-align: center;font-size: 25px;margin-left: 47%">首页</span>
	<c:if test="${empty currentUser }">
			<a href="login.jsp" style="text-decoration: none;margin-left:35%">登录</a>
	</c:if>
	
    <%
    	if (session.getAttribute("currentUser") != null) {
    		 %>
    		 <span style="margin-left:32%">欢迎你</span>
    		 <a href="#" >${currentUser.username}</a>
    		 <a href="logout">登出</a>
    		 <%
    	}
    %>
</div>
</body>
</html>