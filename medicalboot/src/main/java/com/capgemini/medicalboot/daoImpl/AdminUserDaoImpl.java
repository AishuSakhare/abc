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
import com.capgemini.medicalboot.dao.AdminUserDao;

@Repository
public class AdminUserDaoImpl implements AdminUserDao {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public AdminUserBean adminuserLogin(String email, String password) {
		EntityManager em = emf.createEntityManager();
		AdminUserBean adminUserBean = null;

		String jpql = "from AdminUserBean where email = :email and password = :password";
		Query query = em.createQuery(jpql);

		query.setParameter("email", email);
		query.setParameter("password", password);

		try {
			adminUserBean = (AdminUserBean) query.getSingleResult();
			return adminUserBean;
		} catch (Exception e) {
			System.err.println("Email or Password is wrong`");
			return null;
		}

	}// End of adminuserLogin()

	@Override
	public AdminUserBean adminuserRegister(AdminUserBean adminUserBean) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(adminUserBean);
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();

		return adminUserBean;
	}// End of adminuserRegister()

	@Override
	public AdminUserBean adminuserProfile(AdminUserBean adminUserBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		AdminUserBean adminuserBean2 = em.find(AdminUserBean.class, adminUserBean.getId());

		et.commit();
		return adminuserBean2;
	}// End of adminuserProfile()

	@Override
	public AdminUserBean adminuserUpdateProfile(AdminUserBean adminUserBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		AdminUserBean adminUserBean1 = em.find(AdminUserBean.class, adminUserBean.getId());
		if (adminUserBean1 != null) {

			if (adminUserBean.getName() != null) {
				adminUserBean1.setName(adminUserBean.getName());
			}
			if (adminUserBean.getEmail() != null) {
				adminUserBean1.setEmail(adminUserBean.getEmail());
			}
			if (adminUserBean.getPassword() != null) {
				adminUserBean1.setPassword(adminUserBean.getPassword());
			}
			if (adminUserBean.getMobileno() != null) {
				adminUserBean1.setMobileno(adminUserBean.getMobileno());
			}
			if (adminUserBean.getAddress() != null) {
				adminUserBean1.setAddress(adminUserBean.getAddress());
			}

		}

		try {
			et.begin();
			em.persist(adminUserBean1);
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();

		return adminUserBean1;

	}// End of adminuserUpdateProfile()

	@Override
	public List<AdminUserBean> userList() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from AdminUserBean where role=:role";
		Query query = manager.createQuery(jpql);
		query.setParameter("role", "User");
		List<AdminUserBean> userList = null;
		try {
			userList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}// End of userList()

	@Override
	public boolean userDelete(int id) {
		EntityManager em = emf.createEntityManager();
		AdminUserBean adminUserBean = null;
		boolean isDeleted = false;
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			adminUserBean = em.find(AdminUserBean.class, id);
			em.remove(adminUserBean);
			isDeleted = true;
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		em.close();

		return isDeleted;
	}

	@Override
	public boolean checkUserEmail(String email) {
		EntityManager em = emf.createEntityManager();

		String jpql = "from AdminUserBean";
		Query query = em.createQuery(jpql);
		List<AdminUserBean> list = query.getResultList();

		for (AdminUserBean adminUserEmail : list) {

			if (email.equals(adminUserEmail.getEmail())) {
				return true;
			}
		}

		return false;
	}

}// End of class
