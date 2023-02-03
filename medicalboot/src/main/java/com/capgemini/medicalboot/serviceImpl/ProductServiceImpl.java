package com.capgemini.medicalboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalboot.bean.ProductBean;
import com.capgemini.medicalboot.dao.ProductDao;
import com.capgemini.medicalboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public ProductBean addProduct(ProductBean productBean) {
		return productDao.addProduct(productBean);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

	@Override
	public ProductBean updateProduct(ProductBean productBean) {
		return productDao.updateProduct(productBean);
	}

	@Override
	public List<ProductBean> productList() {
		return productDao.productList();
	}

	@Override
	public ProductBean updateProductQuantity(ProductBean productBean) {
		return productDao.updateProductQuantity(productBean);
	}

	@Override
	public boolean checkProductName(String productName) {
		return productDao.checkProductName(productName);
	}
}// End of class
