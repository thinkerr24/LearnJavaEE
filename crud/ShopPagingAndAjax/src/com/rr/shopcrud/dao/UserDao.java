package com.rr.shopcrud.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.rr.shopcrud.utils.C3P0Utils;

public class UserDao {

	public Long checkUsername(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from user where username = ?";
		
		return (Long) qr.query(sql, new ScalarHandler(), username);
	}

}
