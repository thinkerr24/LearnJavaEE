<%@ page language="java" pageEncoding="gb2312" import="java.sql.*"%>
<jsp:useBean id="MySqlBean" scope="page" class="org.easybooks.bookstore.jdbc.MySQLConnBean" />
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	</head>
	<body>
		<%
			String usr=request.getParameter("username");//��ȡ�ύ������
			String pwd=request.getParameter("password");//��ȡ�ύ������
			boolean validated=false;//��֤�ɹ���ʶ
			//��ѯuser���еļ�¼
			String sql="select * from user";
			MySqlBean.OpenConn();//����MySqlBean�м���JDBC�����ķ���
			ResultSet rs=MySqlBean.executeQuery(sql);//ȡ�ý����
			while(rs.next())
			{
				if((rs.getString("username").compareTo(usr)==0)&&(rs.getString("password").compareTo(pwd)==0))
				{
					validated=true;//��ʶΪtrue��ʾ��֤�ɹ�ͨ��
				}
			}
			rs.close();
			MySqlBean.closeStmt();
			MySqlBean.closeConn();
			if(validated)
			{
				//��֤�ɹ���ת��welcome.jsp
		%>
				<jsp:forward page="welcome.jsp"/>
		<%
			}
			else
			{
				//��֤ʧ����ת��error.jsp
		%>
				<jsp:forward page="error.jsp"/>
		<%
			}
		%>
	</body>
</html>


