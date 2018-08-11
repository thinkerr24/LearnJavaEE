package com.rr.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.rr.utils.C3P0Utils;

public class DBUtilsDemo {
	@Test
	public void dbutilsTest() {
		Connection conn = null;
		try {
		QueryRunner qr = new QueryRunner();
		conn = C3P0Utils.getConnection();
		conn.setAutoCommit(false);
		String sql = "insert into accounts values(null, 'alice', 3600)";
		
			qr.update(conn, sql);
		conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
