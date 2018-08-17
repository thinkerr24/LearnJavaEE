package com.rr.shopcrud.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.rr.shopcrud.domain.Product;
import com.rr.shopcrud.service.AdminProductService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SearchWordServlet
 */
@WebServlet("/searchWord")
public class SearchWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.��ùؼ���
		String word = request.getParameter("word");
		
		// 2.��ѯ�ùؼ��ֵ�������Ʒ
		AdminProductService service = new AdminProductService();
		List<Object> productList = null;
		try {
			 productList = service.findProductByWord(word);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.ת��json��ʽ(ʹ��jsonת�����߽��������˵Ķ�����߼���ת��json��ʽ�ַ���)
		/*JSONArray fromObject = JSONArray.fromObject(productList);
		String jsonStr = fromObject.toString();
		System.out.println(jsonStr);*/
		Gson gson = new Gson();
		String json = gson.toJson(productList);
		//System.out.println(json);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
