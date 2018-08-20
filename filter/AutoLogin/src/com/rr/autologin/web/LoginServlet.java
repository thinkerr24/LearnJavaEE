package com.rr.autologin.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rr.autologin.domain.User;
import com.rr.autologin.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = null;
			LoginService service = new LoginService();
			try {
				user = service.QueryUser(username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (user != null) {
				// 登录成功
				// 判断用户是否勾选自动登录
				String autoLogin = request.getParameter("autoLogin");
				if (autoLogin != null) {
					Cookie cookie_username = new Cookie("cookie_username", user.getUsername());
					Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
					// 设置cookie的持久化时间
					cookie_username.setMaxAge(60 * 60);
					cookie_password.setMaxAge(60 * 60);
					// 设置cookie携带路径
					cookie_username.setPath(request.getContextPath());
					cookie_password.setPath(request.getContextPath());
					// 发送cookie
					response.addCookie(cookie_username);
					response.addCookie(cookie_password);
				
					}
				// 查找到user
				session.setAttribute("currentUser", user);
				response.sendRedirect(request.getContextPath());
			} else { // 未查找到
				request.setAttribute("loginFaileMsg", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
