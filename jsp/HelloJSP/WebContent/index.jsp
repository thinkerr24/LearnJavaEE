<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"
    pageEncoding="utf-8" errorPage="/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First JSP page</title>
</head>
<body>
			<%@ include file="/demo.jsp" %>
	<%
		out.write("你好, world!");
		Date date = new Date(); 
		out.println(date.toLocaleString());
		
	%>
	
	<jsp:include page="demo2.jsp"></jsp:include>

</body>
</html>