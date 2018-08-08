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
    	 // ��ServletContext���д�һ������
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
		// 1.����û���������
		String username = request.getParameter("usn");
		String password = request.getParameter("psd");
		// 2.�����ݿ�����֤�û����������Ƿ���ȷ
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		try {
			 	User user = qr.query(sql, new BeanHandler<User>(User.class) , username, password);
			 // 3.���ز�ͬ���
			 	if (user != null) {
			 		int count = (int) getServletContext().getAttribute("count");
			 		count++;
			 		response.getWriter().write("��ӭ��" + user.getUsername() +", ���ǵ�" + count +"λ��¼�ɹ����û�!");
			 		getServletContext().setAttribute("count", count);
			 	} else {
			 		response.getWriter().write("�û��������ڻ����������");
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
