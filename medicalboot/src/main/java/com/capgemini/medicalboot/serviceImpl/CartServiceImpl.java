package com.capgemini.medicalboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalboot.bean.CartBean;
import com.capgemini.medicalboot.bean.OrderProductBean;
import com.capgemini.medicalboot.dao.CartDao;
import com.capgemini.medicalboot.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Override
	public List<CartBean> viewCartProduct(CartBean cartBean) {
		return cartDao.viewCartProduct(cartBean);
	}

	@Override
	public CartBean addProductToCart(CartBean cartBean) {
		return cartDao.addProductToCart(cartBean);
	}

	@Override
	public boolean deleteProductFromCart(int cartId) {
		return cartDao.deleteProductFromCart(cartId);
	}

	@Override
	public CartBean orderProduct(CartBean cartBean) {
		return cartDao.orderProduct(cartBean);
	}

	@Override
	public OrderProductBean addProductToOrderList(CartBean cartBean) {
		return cartDao.addProductToOrderList(cartBean);
	}

	@Override
	public List<OrderProductBean> viewOrder(OrderProductBean orderProductBean) {
		return cartDao.viewOrder(orderProductBean);
	}

	@Override
	public boolean deleteUserFromCart(int id) {
		return cartDao.deleteUserFromCart(id);
	}

	@Override
	public double payment(CartBean cartBean) {
		return cartDao.payment(cartBean);
	}
}// End of class
