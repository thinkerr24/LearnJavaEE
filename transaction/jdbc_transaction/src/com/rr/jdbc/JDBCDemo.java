package com.rr.jdbc;

import java.sql.*;

import org.junit.Test;


public class JDBCDemo {
	@Test
	public  void jdbcTest() {
		Connection conn = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 conn = DriverManager.getConnection("jdbc:mysql:///learn_transaction", "root", "root");
		
		// 手动开启事务
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		String sql = "insert into accounts values(null, 'peter', 2500)";
		stmt.executeUpdate(sql);
		
		sql = "update accounts set amoney = 5000 where aname = 'Tom'";
		stmt.executeUpdate(sql);
		// 提交事务
		conn.commit();
		
		stmt.close();
		conn.close();
		} catch(Exception ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}
}
