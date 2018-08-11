package com.rr.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.rr.dao.TransferDao;
import com.rr.utils.C3P0Utils;

public class TransferService {

	public boolean transfer(String out, String in, double money) {
		
		TransferDao dao = new TransferDao();
		//Connection conn = null;
		try {
			/* ①
			// 获取连接
			conn = C3P0Utils.getConnection();
			// 开启事务
			conn.setAutoCommit(false);
			
			*/
			/* ② */
			// 开启事务
			C3P0Utils.startTransaction();
			// 转出钱方法
			dao.out(out, money);
			// *出现问题*
		   // int i = 1 / 0;
			// 转入钱方法
			dao.in(in, money);
		} catch (Exception e) {
			// 事件回滚
			try {
				C3P0Utils.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			try {
				C3P0Utils.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

}
