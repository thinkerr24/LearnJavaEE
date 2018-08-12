package com.rr.shopcrud.utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
   private static ComboPooledDataSource datasource = new ComboPooledDataSource();
   // ����ThreadLocal
   private static ThreadLocal<Connection> tl = new ThreadLocal<>();
   
   public static DataSource getDataSource() {
	   return datasource;
   }
   
   public static void rollback() throws SQLException {
	   Connection conn =  getCurrentConnection();
	   if (conn != null) {
		   conn.rollback();
		   // ��connection�����ThreadLocal���Ƴ�
		   tl.remove();
		   conn.close();
	   }
   }
   
   public static void commit() throws SQLException {
	   Connection conn = getCurrentConnection();
	   if (conn != null) {
		   conn.commit();
		   // ��connection�����ThreadLocal���Ƴ�
		   tl.remove();
		   conn.close();
	   }
   }
   public static Connection getConnection() {
	   try {
		return datasource.getConnection();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
   }
   
   // ��������
   public static void startTransaction() throws SQLException {
	   Connection conn = getCurrentConnection();
	   conn.setAutoCommit(false);
   }
   // ��õ�ǰ�߳��ϰ󶨵�connection
   public static Connection getCurrentConnection() {
	  // ��ThreadLocal��Ѱ�ҵ�ǰ�߳��Ƿ��ж�Ӧ��connection
	   Connection connection = tl.get();
	   if (connection == null) {
		   // ���һ���µ�connection
		   connection = getConnection();
		   // ��connection��Դ�󶨵�ThreadLocal(map)��
		   tl.set(connection);
	   }
	   return connection;
   }
}
