package com.rr.service;

import java.sql.SQLException;
import java.util.List;

import com.rr.dao.ProductDao;
import com.rr.domain.Product;

public class ProductService {

	public List<Product> findAllProduct() throws SQLException {
		// û�и���ҵ�񣬴�������dao��
		return new ProductDao().findAllProduct();
	}

}
