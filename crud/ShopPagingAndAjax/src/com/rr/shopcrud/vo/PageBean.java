package com.rr.shopcrud.vo;

import java.util.ArrayList;
import java.util.List;

import com.rr.shopcrud.domain.Product;

public class PageBean<T> {
	// ��ǰҳ
	private int currentPage;
	// ��ǰҳ��ʾ��ҳ��
	private int currentCount;
	// ������
	private int totalCount;
	// ��ҳ��
	private int totalPage;
	// ÿҳ��ʾ������
	private List<T> productList = new ArrayList<T>();
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getProductList() {
		return productList;
	}
	public void setProductList(List<T> productList) {
		this.productList = productList;
	}
	
}
