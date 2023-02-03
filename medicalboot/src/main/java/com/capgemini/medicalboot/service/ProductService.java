package com.capgemini.medicalboot.service;

import java.util.List;

import com.capgemini.medicalboot.bean.ProductBean;

public interface ProductService {

	public ProductBean addProduct(ProductBean productBean);

	public boolean deleteProduct(int productId);

	public ProductBean updateProduct(ProductBean productBean);

	public List<ProductBean> productList();
	
	public ProductBean updateProductQuantity(ProductBean productBean);
	
	public boolean checkProductName(String productName);
}// End of interface
