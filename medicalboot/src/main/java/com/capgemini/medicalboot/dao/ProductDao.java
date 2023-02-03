package com.capgemini.medicalboot.dao;

import java.util.List;

import com.capgemini.medicalboot.bean.ProductBean;

public interface ProductDao {

	public ProductBean addProduct(ProductBean productBean);

	public boolean deleteProduct(int productId);

	public ProductBean updateProduct(ProductBean productBean);

	public List<ProductBean> productList();
	
	public ProductBean updateProductQuantity(ProductBean productBean);
	
	public boolean checkProductQuantity(int productId);
	
	public boolean checkProductName(String productName);
}// End of interface
