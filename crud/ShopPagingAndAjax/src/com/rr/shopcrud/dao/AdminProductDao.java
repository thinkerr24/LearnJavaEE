package com.rr.shopcrud.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.rr.shopcrud.domain.Category;
import com.rr.shopcrud.domain.Product;
import com.rr.shopcrud.utils.C3P0Utils;
import com.rr.shopcrud.vo.Condition;

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

	// 添加商品
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

	public List<Product> findProductListByCondition(Condition condition) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		List<String> paraList = new ArrayList<>();
		String sql = "select * from product where 1=1 ";
		if (condition.getPname() != null && !condition.getPname().trim().equals("")) {
			sql += "and pname like ? ";
			paraList.add("%" + condition.getPname().trim() + "%");
		}  
		if (condition.getIsHot() != null && !condition.getIsHot().trim().equals("")) {
			sql += "and is_hot = ? ";
			paraList.add(condition.getIsHot().trim());
		}
		if (condition.getCid() != null && !condition.getCid().trim().equals("")) {
			sql += "and cid = ?";
			paraList.add(condition.getCid().trim());
		}
		return qr.query(sql, new BeanListHandler<Product>(Product.class), paraList.toArray());
		
	}

	public int getTotalCount() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from product";
		Long totalCount = (Long) qr.query(sql, new ScalarHandler());
		return totalCount.intValue();
	}
	
	// 获得分页的商品数据
	public List<Product> findProductListForPageBean(int index, int currentCount) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product limit ?, ?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), index, currentCount);
	}

	public List<Object> findProductByWord(String word) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pname like ? limit 0,8";
		List<Object> pnameList =  (List<Object>) qr.query(sql, new ColumnListHandler("pname"), "%"+word+"%");
		
		return pnameList;
	}

}
