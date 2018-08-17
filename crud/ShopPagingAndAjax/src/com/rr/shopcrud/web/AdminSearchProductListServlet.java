package com.rr.shopcrud.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.rr.shopcrud.domain.Category;
import com.rr.shopcrud.domain.Product;
import com.rr.shopcrud.service.AdminProductService;
import com.rr.shopcrud.vo.Condition;

/**
 * Servlet implementation class AdminSearchProductListServlet
 */
@WebServlet("/adminSearchProductList")
public class AdminSearchProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 1.收集表单数据
		Map<String, String[]> parameterMap = request.getParameterMap();
		// 2.将散装的查询条件封装到一个VO实体中
		Condition condition = new Condition();
		try {
			BeanUtils.populate(condition, parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.将实体传递给service层
		AdminProductService service = new AdminProductService();
		List<Product> productList = null;
		try {
			productList = service.findProductListByCondition(condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 4.准备商品类别
		List<Category> categoryList = null;	
		   try {
			 categoryList = service.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("condition", condition);   
		request.setAttribute("categoryList", categoryList);   
		request.setAttribute("productList", productList);
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
