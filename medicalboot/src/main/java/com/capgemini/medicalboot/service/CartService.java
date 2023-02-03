package com.capgemini.medicalboot.service;

import java.util.List;

import com.capgemini.medicalboot.bean.CartBean;
import com.capgemini.medicalboot.bean.OrderProductBean;

public interface CartService {

	public List<CartBean> viewCartProduct(CartBean cartBean);

	public CartBean addProductToCart(CartBean cartBean);

	public boolean deleteProductFromCart(int cartId);

	public CartBean orderProduct(CartBean cartBean);
	
	public OrderProductBean addProductToOrderList(CartBean cartBean);
	
	public List<OrderProductBean> viewOrder(OrderProductBean orderProductBean);
	
	public boolean deleteUserFromCart(int id);
	
	public double payment(CartBean cartBean);

}// End of interface
