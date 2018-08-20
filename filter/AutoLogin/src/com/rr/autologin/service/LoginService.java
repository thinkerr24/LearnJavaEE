package com.rr.autologin.service;

import java.sql.SQLException;

import com.rr.autologin.dao.LoginDao;
import com.rr.autologin.domain.User;

public class LoginService {

	public User QueryUser(String username, String password) throws SQLException {
		LoginDao dao = new LoginDao();
		return dao.QueryUser(username, password);
	}

}
