package com.rr.shopcrud.service;

import java.sql.SQLException;
import java.util.List;

import com.rr.shopcrud.dao.AdminProductDao;
import com.rr.shopcrud.domain.Category;
import com.rr.shopcrud.domain.Product;
import com.rr.shopcrud.vo.Condition;
import com.rr.shopcrud.vo.PageBean;

public class AdminProductService {

	private AdminProductDao dao = new AdminProductDao();
	public List<Product> findAllProduct() throws SQLException {
		return dao.findAllProduct();
	}
	public List<Category> findAllCategory() throws SQLException {
		return dao.findAllCategory();
	}
	public void addProduct(Product product) throws SQLException {
	
		dao.addProduct(product);
	}
	public void delProductByPid(String pid) throws SQLException {
		
		dao.delProductByPid(pid);
	}
	public Product findProductByPid(String pid) throws SQLException {
		
		return dao.findProductByPid(pid);
	}
	public void updateProduct(Product product) throws SQLException {
		dao.updateProduct(product);
		
	}
	public List<Product> findProductListByCondition(Condition condition) throws SQLException {
		return dao.findProductListByCondition(condition);
	}
	
	// 分页操作 (封装一个pageBean并返回)
	public PageBean findPageBean(int currentPage, int currentCount) throws SQLException {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		List<Product> productList = dao.findProductListForPageBean((currentPage - 1)*currentCount, currentCount);
		pageBean.setProductList(productList);
		return pageBean;
	}
	// 根据关键字查询商品
	public List<Object> findProductByWord(String word) throws SQLException {
		
		return dao.findProductByWord(word);
	}

}
