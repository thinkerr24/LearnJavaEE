package com.rr.autologin.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rr.autologin.domain.User;
import com.rr.autologin.service.LoginService;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */

public class AutoLoginFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// ��ȡcookie�е��û�����������е�¼�Ĳ���
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		String cookie_username = null;
		String cookie_password = null;
		// 1.��ȡcookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			// ��ȡcookie_username ��cookie_password
			for (Cookie cookie : cookies) {
				if ("cookie_username".equals(cookie.getName())) {
					cookie_username = cookie.getValue();
				}
				if ("cookie_password".equals(cookie.getName())) {
					cookie_password = cookie.getValue();
				}
			}
			Object cookie_passowrd;
			// �ж�username��password�Ƿ�Ϊnull
			if (cookie_username != null && cookie_password != null) {
				User user = null;
				LoginService service = new LoginService();
				HttpSession session = req.getSession();
				try {
					user = service.QueryUser(cookie_username, cookie_password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				if (user != null) {	// ���ҵ�user
					session.setAttribute("currentUser", user);
				} 
			}
		}

		chain.doFilter(request, response);
	}

	
	public void destroy() {
		
	}


	

	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
