package com.rr.autologin.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.rr.autologin.domain.User;
import com.rr.autologin.utils.C3P0Utils;

public class LoginDao {

	public User QueryUser(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		Object[] object = {username, password};
		return qr.query(sql, new BeanHandler<User>(User.class), object);
	}

}
