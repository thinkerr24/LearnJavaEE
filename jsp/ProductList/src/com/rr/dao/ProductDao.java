package com.rr.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rr.domain.Product;
import com.rr.utils.C3P0Utils;

public class ProductDao {

	public List<Product> findAllProduct() throws SQLException {
		// ²Ù×÷Êý¾Ý¿â
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product";
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
		
		
	}

}
