package com.rr.service;

import java.sql.SQLException;
import java.util.List;

import com.rr.dao.ProductDao;
import com.rr.domain.Product;

public class ProductService {

	public List<Product> findAllProduct() throws SQLException {
		// 没有复杂业务，传递请求到dao层
		return new ProductDao().findAllProduct();
	}

}
