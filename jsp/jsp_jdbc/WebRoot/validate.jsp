<%@ page language="java" pageEncoding="gb2312" import="java.sql.*"%>
<jsp:useBean id="MySqlBean" scope="page" class="org.easybooks.bookstore.jdbc.MySQLConnBean" />
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	</head>
	<body>
		<%
			String usr=request.getParameter("username");//获取提交的姓名
			String pwd=request.getParameter("password");//获取提交的密码
			boolean validated=false;//验证成功标识
			//查询user表中的记录
			String sql="select * from user";
			MySqlBean.OpenConn();//调用MySqlBean中加载JDBC驱动的方法
			ResultSet rs=MySqlBean.executeQuery(sql);//取得结果集
			while(rs.next())
			{
				if((rs.getString("username").compareTo(usr)==0)&&(rs.getString("password").compareTo(pwd)==0))
				{
					validated=true;//标识为true表示验证成功通过
				}
			}
			rs.close();
			MySqlBean.closeStmt();
			MySqlBean.closeConn();
			if(validated)
			{
				//验证成功跳转到welcome.jsp
		%>
				<jsp:forward page="welcome.jsp"/>
		<%
			}
			else
			{
				//验证失败跳转到error.jsp
		%>
				<jsp:forward page="error.jsp"/>
		<%
			}
		%>
	</body>
</html>


