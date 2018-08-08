package com.rr.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.rr.domain.User;
import com.rr.jdbc.utils.C3P0Utils;
import com.rr.jdbc.utils.DataSourceUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    public void init() throws ServletException{
    	 // 再ServletContext域中存一个数据
		int count = 0;
		getServletContext().setAttribute("count", count);
     }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		 response.setCharacterEncoding("utf-8");
		// 1.获得用户名和密码
		String username = request.getParameter("usn");
		String password = request.getParameter("psd");
		// 2.从数据库中验证用户名和密码是否正确
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		try {
			 	User user = qr.query(sql, new BeanHandler<User>(User.class) , username, password);
			 // 3.返回不同结果
			 	if (user != null) {
			 		int count = (int) getServletContext().getAttribute("count");
			 		count++;
			 		response.getWriter().write("欢迎你" + user.getUsername() +", 您是第" + count +"位登录成功的用户!");
			 		getServletContext().setAttribute("count", count);
			 	} else {
			 		response.getWriter().write("用户名不存在或者密码错误");
			 	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
