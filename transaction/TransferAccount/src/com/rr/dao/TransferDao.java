package com.rr.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.rr.utils.C3P0Utils;

public class TransferDao {

	public void out(String out, double money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "update accounts set amoney=amoney-? where aname=?";
		qr.update(C3P0Utils.getCurrentConnection(), sql, money, out);
	
	}

	public void in(String in, double money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "update accounts set amoney=amoney+? where aname=?";
		qr.update(C3P0Utils.getCurrentConnection(), sql, money, in);
	}

}
