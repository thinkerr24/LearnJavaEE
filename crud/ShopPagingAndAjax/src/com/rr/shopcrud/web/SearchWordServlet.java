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
		// 1.获得关键字
		String word = request.getParameter("word");
		
		// 2.查询该关键字的所有商品
		AdminProductService service = new AdminProductService();
		List<Object> productList = null;
		try {
			 productList = service.findProductByWord(word);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.转成json格式(使用json转换工具将服务器端的对象或者集合转成json格式字符串)
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
