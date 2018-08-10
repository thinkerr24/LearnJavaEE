<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl</title>
</head>
<body>
	<%-- jstl标签经常和el配合使用 --%>
	<%--1.test代表的是返回boolean的表达式 --%>
  <c:if test="${1==1}">
  		1 == 1?true 
  </c:if>
  
  <c:if test="1 != 1">
  	     false
  </c:if>
  <br />
  <%
  	request.setAttribute("count", 10);
  %>
<%-- if标签，没有else --%>
  <c:if test="${ count==10 }">
  	count = 10
  </c:if>
  <br />
 <%--forEach模拟
 	①for (int i = 0; i < 5; i++)
 		System.out.println(i);
  --%>
 <c:forEach begin="0" end="5" var="i">
 	${i}
  </c:forEach>
  <br/>
 <%-- ②模拟增强for 
 	for(User user:users)
 		System.out.println(user.getXXX());
 		
 	items:一个集合或者数组 var:代表集合中某一个元素
 	先访问el0.jsp初始化一个可迭代对象users
 --%>
 
 <c:forEach items="${users}" var="u">
 	<h1>${u.username }:${u.password}</h1> <br />
 </c:forEach>
 	
</body>
</html>