package com.capgemini.medicalboot.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalboot.bean.AdminUserBean;
import com.capgemini.medicalboot.bean.ProductBean;
import com.capgemini.medicalboot.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public ProductBean addProduct(ProductBean productBean) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(productBean);
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return productBean;
	}// End of addProduct()

	@Override
	public boolean deleteProduct(int productId) {
		EntityManager em = emf.createEntityManager();
		ProductBean productBean = null;
		boolean isDeleted = false;
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			productBean = em.find(ProductBean.class, productId);
			em.remove(productBean);
			isDeleted = true;
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		em.close();

		return isDeleted;
	}// End of deleteProduct()

	@Override
	public ProductBean updateProduct(ProductBean productBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		ProductBean productBean1 = em.find(ProductBean.class, productBean.getProductId());
		if (productBean1 != null) {

			if (productBean.getProductName() != null) {
				productBean1.setProductName(productBean.getProductName());
			}
			if (productBean.getProductCategory() != null) {
				productBean1.setProductCategory(productBean.getProductCategory());
			}
			if (productBean.getProductDescription() != null) {
				productBean1.setProductDescription(productBean.getProductCategory());
			}
			if (productBean.getProductQuantity() != 0) {
				productBean1.setProductQuantity(productBean.getProductQuantity());
			}
			if (productBean.getProductPrice() != 0) {
				productBean1.setProductPrice(productBean.getProductPrice());
			}

		}

		try {
			et.begin();
			em.persist(productBean1);
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();

		return productBean1;

	}// End of updateProduct()

	@Override
	public List<ProductBean> productList() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from ProductBean";
		Query query = manager.createQuery(jpql);

		List<ProductBean> productList = null;
		try {
			productList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;
	}// End of productList()

	@Override
	public ProductBean updateProductQuantity(ProductBean productBean) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		ProductBean productBean1 = em.find(ProductBean.class, productBean.getProductId());
		if (productBean1 != null) {
			if (productBean.getProductQuantity() <= 0) {
				productBean1.setProductQuantity(productBean.getProductQuantity());
			}
		}
		try {
			et.begin();
			em.persist(productBean1);
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return productBean1;

	}

	@Override
	public boolean checkProductQuantity(int productId) {
		EntityManager em = emf.createEntityManager();

		String jpql = "from ProductBean where productId=:productId";
		Query query = em.createQuery(jpql);
		query.setParameter("productId", productId);
		ProductBean productBean = (ProductBean) query.getSingleResult();

		int presentQuantity = productBean.getProductQuantity();

		if (presentQuantity == 0) {
			return true;
		}

		return false;
	}// end of checkProductQuantity
	
	@Override
	public boolean checkProductName(String productName) {
		EntityManager em = emf.createEntityManager();

		String jpql = "from ProductBean";
		Query query = em.createQuery(jpql);
		List<ProductBean> list = query.getResultList();

		for (ProductBean productNameList : list) {

			if (productName.equals(productNameList.getProductName())) {
				return true;
			}
		}

		return false;
	}

}// End of class
