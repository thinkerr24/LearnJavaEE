package com.rr.shopcrud.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.rr.shopcrud.domain.Product;
import com.rr.shopcrud.service.AdminProductService;

/**
 * Servlet implementation class AdminUpdateProductServlet
 */
@WebServlet("/adminUpdateProduct")
public class AdminUpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				// 1.获取数据
				Map<String, String[]> properties = request.getParameterMap();
				// 2.封装数据
				Product product = new Product();
				try {
					BeanUtils.populate(product, properties);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 手动设置表单中没有的数据
				//   pdate  pflag(是否下架， 0表示未下架)
			
				//product.setPimage("products/1/c_0033.jpg");
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				product.setPdate(format.format(new Date()));
				
				product.setPflag(0);
				// 3.传递数据
				AdminProductService service = new AdminProductService();
				try {
					service.updateProduct(product);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 跳转到列表页面
				response.sendRedirect(request.getContextPath() + "/adminProductList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
