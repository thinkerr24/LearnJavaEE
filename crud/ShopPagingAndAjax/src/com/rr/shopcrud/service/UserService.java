package com.rr.shopcrud.service;

import java.sql.SQLException;

import com.rr.shopcrud.dao.UserDao;

public class UserService {
	private UserDao dao = new UserDao();
	public boolean checkUsername(String username) throws SQLException {
		Long isExist = dao.checkUsername(username);
		
		return isExist > 0;
	}

}
