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
 * Servlet implementation class AdminUpdateProductUIServlet
 */
@WebServlet("/adminUpdateProductUI")
public class AdminUpdateProductUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 查询要查询的Product的pid
		String pid = request.getParameter("pid");
		// 传递pid查询商品信息
		AdminProductService service = new AdminProductService();
		Product product = null;
		// 获得商品类别数据
		List<Category> categoryList = null;	
		try {
		    product = service.findProductByPid(pid);
		    categoryList = service.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    request.setAttribute("categoryList", categoryList);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
