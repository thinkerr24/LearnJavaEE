<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="#">首页</a></li>
			</ol>
		</div>

		<c:forEach items="${productList }" var="product">
			<div class="col-md-2" style="height:250px">
			<a href="product_info.jsp?product_id=${product.pid}&simg=${product.pimage}">
			 <img src="${pageContext.request.contextPath }/${product.pimage }"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>${product.pname}</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;${product.shop_price }</font>
			</p>
		</div>
		</c:forEach>

	

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>