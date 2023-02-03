package com.capgemini.medicalboot.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalboot.bean.AdminUserBean;
import com.capgemini.medicalboot.bean.CartBean;
import com.capgemini.medicalboot.bean.OrderProductBean;
import com.capgemini.medicalboot.bean.ProductBean;
import com.capgemini.medicalboot.dao.CartDao;

@Repository
public class CartDaoImpl implements CartDao {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public List<CartBean> viewCartProduct(CartBean cartBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		String jpql = "from CartBean where id=:id";

		et.begin();
		Query que = em.createQuery(jpql);
		int id = cartBean.getId();
		que.setParameter("id", id);
		List<CartBean> cartList = null;
		cartList = que.getResultList();

		et.commit();
		return cartList;
	}// End of viewCartProduct()

	@Override
	public CartBean addProductToCart(CartBean cartBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		AdminUserBean adminuserBean = null;
		ProductBean productBean = null;

		et.begin();

		String jpql = "from AdminUserBean where id=:id";
		Query q = em.createQuery(jpql);

		int id = cartBean.getId();
		q.setParameter("id", id);
		adminuserBean = (AdminUserBean) q.getSingleResult();

		String email = adminuserBean.getEmail();

		cartBean.setEmail(email); // ..........................1...email
		cartBean.setId(id); // ..........................2.....id

		String productName = cartBean.getProductName();
		String jpql2 = "from ProductBean where productName=:productName";
		Query q2 = em.createQuery(jpql2);
		q2.setParameter("productName", productName);
		productBean = (ProductBean) q2.getSingleResult();
		cartBean.setProductName(productName);// ........................3....productName

		double productPrice = productBean.getProductPrice();
		cartBean.setProductPrice(productPrice);// ........................4.....productPrice

		int productId = productBean.getProductId();
		cartBean.setProductId(productId);// ..........................5...productId

		String productDescription = productBean.getProductDescription();
		cartBean.setProductDescription(productDescription);

		String productCategory = productBean.getProductCategory();
		cartBean.setProductCategory(productCategory);

		int productQuantity = cartBean.getProductQuantity();
		cartBean.setProductQuantity(productQuantity);
		try {

			em.persist(cartBean);
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return cartBean;

	}// End of addProductToCart()

	@Override
	public boolean deleteProductFromCart(int cartId) {
		EntityManager em = emf.createEntityManager();
		boolean isDeleted = false;
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			// String jpql = "delete from CartBean where productName=:productName AND
			// id=:id";
			String jpql = "delete from  CartBean where cartId=:cartId";
			Query que = em.createQuery(jpql);
			// que.setParameter("productName", cartBean.getProductName());
			// que.setParameter("id", cartBean.getId());
			que.setParameter("cartId", cartId);
			int result = que.executeUpdate();
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		em.close();
		return isDeleted;

	}// End of deleteProductFromCart()

	@Override
	public CartBean orderProduct(CartBean cartBean) {
		return null;
	}// End of orderProduct()

	@Override
	public OrderProductBean addProductToOrderList(CartBean cartBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		OrderProductBean orderProductBean = new OrderProductBean();

		AdminUserBean adminuserBean = null;

		int cartId = cartBean.getCartId();
		orderProductBean.setCartId(cartId);

		int id = cartBean.getId();
		orderProductBean.setId(id);

		String email = cartBean.getEmail();
		orderProductBean.setEmail(email);

		String jpql = "from AdminUserBean where id=:id";
		Query q = em.createQuery(jpql);

		q.setParameter("id", id);
		adminuserBean = (AdminUserBean) q.getSingleResult();
		String address = adminuserBean.getAddress();

		orderProductBean.setAddress(address);

		int productId = cartBean.getProductId();
		orderProductBean.setProductId(productId);

		String productName = cartBean.getProductName();
		orderProductBean.setProductName(productName);

		double productPrice = cartBean.getProductPrice();
		orderProductBean.setProductPrice(productPrice);

		String productCategory = cartBean.getProductCategory();
		orderProductBean.setProductCategory(productCategory);

		String productDescription = cartBean.getProductDescription();
		orderProductBean.setProductDescription(productDescription);

		int productQuantity = cartBean.getProductQuantity();
		orderProductBean.setProductQuantity(productQuantity);

		try {
			et.begin();
			em.persist(orderProductBean);
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return orderProductBean;

	}// End of addProductToOrderList

	@Override
	public List<OrderProductBean> viewOrder(OrderProductBean orderProductBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		String jpql = "from OrderProductBean where id=:id";

		et.begin();
		Query que = em.createQuery(jpql);
		int id = orderProductBean.getId();
		que.setParameter("id", id);
		List<OrderProductBean> orderList = null;
		orderList = que.getResultList();

		et.commit();
		return orderList;
	}

	@Override
	public boolean deleteUserFromCart(int id) {
		EntityManager em = emf.createEntityManager();
		boolean isDeleted = false;
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			// String jpql = "delete from CartBean where productName=:productName AND
			// id=:id";
			String jpql = "delete from  CartBean where id=:id";
			Query que = em.createQuery(jpql);
			// que.setParameter("productName", cartBean.getProductName());
			// que.setParameter("id", cartBean.getId());
			que.setParameter("id", id);
			int result = que.executeUpdate();
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		em.close();
		return isDeleted;
	}

	@Override
	public double payment(CartBean cartBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		String jpql = "select SUM(productPrice*productQuantity) from CartBean where id=:id AND productId=:productId";

		et.begin();
		Query que = em.createQuery(jpql);
		
		int id = cartBean.getId();
		System.out.println("..................................."+id);
		
		int productId = cartBean.getProductId();
		System.out.println("..................................."+productId);
		
		que.setParameter("id", id);
		que.setParameter("productId", productId);
		
	//	double totalBill = (double) que.getSingleResult();
		double totalBill = 0;
		List<Double> list = que.getResultList();
		for (Double double1 : list) {
			totalBill = double1.doubleValue();
		}

		et.commit();
		return totalBill;
	}
}// End of class
