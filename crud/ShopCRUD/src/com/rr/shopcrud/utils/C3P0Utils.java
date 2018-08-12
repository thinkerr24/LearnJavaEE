package com.rr.shopcrud.utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
   private static ComboPooledDataSource datasource = new ComboPooledDataSource();
   // 创建ThreadLocal
   private static ThreadLocal<Connection> tl = new ThreadLocal<>();
   
   public static DataSource getDataSource() {
	   return datasource;
   }
   
   public static void rollback() throws SQLException {
	   Connection conn =  getCurrentConnection();
	   if (conn != null) {
		   conn.rollback();
		   // 将connection对象从ThreadLocal中移除
		   tl.remove();
		   conn.close();
	   }
   }
   
   public static void commit() throws SQLException {
	   Connection conn = getCurrentConnection();
	   if (conn != null) {
		   conn.commit();
		   // 将connection对象从ThreadLocal中移除
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
   
   // 开启事务
   public static void startTransaction() throws SQLException {
	   Connection conn = getCurrentConnection();
	   conn.setAutoCommit(false);
   }
   // 获得当前线程上绑定的connection
   public static Connection getCurrentConnection() {
	  // 从ThreadLocal中寻找当前线程是否有对应的connection
	   Connection connection = tl.get();
	   if (connection == null) {
		   // 获得一个新的connection
		   connection = getConnection();
		   // 将connection资源绑定到ThreadLocal(map)上
		   tl.set(connection);
	   }
	   return connection;
   }
}
