<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
 <%@page import="com.rr.domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 模拟域中的数据 --%>
	<%
		pageContext.setAttribute("nickname", "777");
	// 存储字符串
		request.setAttribute("nickname", "rr");
	// 存储对象
		User user = new User(1, "Richard", "123");
		session.setAttribute("user", user);
	// 存储集合	
	List<User> users = new ArrayList<>();
	users.add(new User(2, "Tom", "2222"));
	users.add(new User(3, "Jerry", "3333"));
	users.add(new User(4, "Alice", "44444"));
		application.setAttribute("users", users);
	%>
	
	<%--1.使用JSP脚本的--%>
	<%=request.getAttribute("nickname") %>
	<%
		User user1 =  (User)session.getAttribute("user");
		out.write(user1.getUsername());
	%>
	<br />
	<%-- 2.使用EL表达式来获得域中的值--%>
	${requestScope.nickname} 
	${sessionScope.user.username}
	${applicationScope.users[1].username}
	<br />
	<%-- 3.使用EL表达式 全域查找(和域范围有关，越小越优先pageContext <
	 request < session < application) --%>
	 ${nickname}
	${user.username} 
	${users[0].username}
	
	<%-- 4.使用EL表达式获得表单数据 --%>
</body>
</html>