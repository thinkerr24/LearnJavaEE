package com.rr.shopcrud.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rr.shopcrud.domain.Category;
import com.rr.shopcrud.domain.Product;
import com.rr.shopcrud.utils.C3P0Utils;

public class AdminProductDao {

	public List<Product> findAllProduct() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product";
		
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
	}

	public List<Category> findAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category";
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
	}

	// ÃÌº”…Ã∆∑
	public void addProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into product  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		qr.update(sql, product.getPid(),product.getPname(), product.getMarket_price(),
				product.getShop_price(), product.getPimage(), product.getPdate(), product.getIs_hot(),
				product.getPdesc(), product.getPflag(), product.getCid());
	}

	public void delProductByPid(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "delete from product where pid=?";
		qr.update(sql, pid);
	}

	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid=?";
		return qr.query(sql, new BeanHandler<Product>(Product.class), pid);
	}

	public void updateProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update product set pname=?, market_price=?, shop_price = ?, pdate = ?, is_hot = ?, pdesc = ?, pflag = ?, cid = ? where pid=?";
		qr.update(sql, product.getPname(), product.getMarket_price(),
				product.getShop_price(),  product.getPdate(), product.getIs_hot(),
				product.getPdesc(), product.getPflag(), product.getCid(), product.getPid());
	}

}
