package com.rr.servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rr.login.LoginServlet;

/**
 * Servlet implementation class GetResourcepathByServletContext
 */
@WebServlet("/rspath")
public class GetResourcepathByServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// *��ȡWebӦ�����κ���Դ�ľ���·��*
		 
				 // *����һ*
				 ServletContext context = getServletContext();
				 // �ٻ�ȡa.log
				 String realPath = context.getRealPath("/WEB-INF/a.log");
				 System.out.println(realPath);
				 // *������*
				 System.out.println(GetResourcepathByServletContext.class.getClassLoader().getResource("a.txt").getPath());
				 
				// ����� --��ServletContext�д�����
				 context.setAttribute("name", "rr");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
