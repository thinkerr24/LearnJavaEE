package com.rr.shopcrud.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rr.shopcrud.domain.Category;
import com.rr.shopcrud.domain.Product;
import com.rr.shopcrud.service.AdminProductService;

/**
 * Servlet implementation class adminProductListServlet
 */
@WebServlet("/adminProductList")
public class AdminProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> productList = null;
		// 传递请求到service层
		AdminProductService service = new AdminProductService();
		try {
			 productList = service.findAllProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 将productList放到request域
		request.setAttribute("productList", productList);
	
		// 获得商品类别数据
		List<Category> categoryList = null;	
		   try {
			 categoryList = service.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  request.setAttribute("categoryList", categoryList);
		
	
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
