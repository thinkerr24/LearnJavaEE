package com.rr.shopcrud.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rr.shopcrud.domain.Product;
import com.rr.shopcrud.service.AdminProductService;
import com.rr.shopcrud.vo.PageBean; 

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/products")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 传递请求到service层
				AdminProductService service = new AdminProductService();
				PageBean<Product> pageBean = null;
				//List<Product> list = null;
				// 模拟当前是第一页
				String currentPageStr = request.getParameter("currentPage");
				int currentPage = 1;
				if (currentPageStr != null) { 
					currentPage = Integer.parseInt(currentPageStr);
				}
				// 认为每页12条
				int currentCount = 12;
				
				try {
				    pageBean = service.findPageBean(currentPage, currentCount);
					//list = service.findAllProduct();
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// 全部商品的数据准备好了 转发给jsp显示
				//request.setAttribute("productList", list);
				
				request.setAttribute("pageBean", pageBean);
				request.getRequestDispatcher("/product_list.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
