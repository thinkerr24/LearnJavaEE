package com.rr.shopcrud.service;

import java.sql.SQLException;
import java.util.List;

import com.rr.shopcrud.dao.AdminProductDao;
import com.rr.shopcrud.domain.Category;
import com.rr.shopcrud.domain.Product;

public class AdminProductService {

	private AdminProductDao dao = new AdminProductDao();
	public List<Product> findAllProduct() throws SQLException {
		return dao.findAllProduct();
	}
	public List<Category> findAllCategory() throws SQLException {
		return dao.findAllCategory();
	}
	public void addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		dao.addProduct(product);
	}
	public void delProductByPid(String pid) throws SQLException {
		// TODO Auto-generated method stub
		dao.delProductByPid(pid);
	}
	public Product findProductByPid(String pid) throws SQLException {
		
		return dao.findProductByPid(pid);
	}
	public void updateProduct(Product product) throws SQLException {
		dao.updateProduct(product);
		
	}

}
