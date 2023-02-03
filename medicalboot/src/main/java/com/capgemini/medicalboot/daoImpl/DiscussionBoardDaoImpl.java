package com.capgemini.medicalboot.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalboot.bean.DiscussionBoardBean;
import com.capgemini.medicalboot.dao.DiscussionBoardDao;

@Repository
public class DiscussionBoardDaoImpl implements DiscussionBoardDao {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean userQuestion(DiscussionBoardBean discussionBoardBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		discussionBoardBean.setMessageType("Question");
		boolean isAdded = false;
		try {
			et.begin();
			em.persist(discussionBoardBean);
			et.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return isAdded;
	}// End of userQuestion

	@Override
	public List<DiscussionBoardBean> seeAdminResponse(DiscussionBoardBean discussionBoardBean) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		String jpql = "from DiscussionBoardBean where id=:id AND messageType=:messageType";

		et.begin();
		Query que = em.createQuery(jpql);
		String type = "Answer";
		que.setParameter("id", discussionBoardBean.getId());
		que.setParameter("messageType", "Answer");
		List<DiscussionBoardBean> seeAdminResponseList = null;
		seeAdminResponseList = que.getResultList();

		et.commit();
		return seeAdminResponseList;
	}// End of seeAdminResponse()

	@Override
	public boolean adminResponse(DiscussionBoardBean discussionBoardBean) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		discussionBoardBean.setMessageType("Answer");
		boolean isAdded = false;
		try {
			et.begin();
			em.persist(discussionBoardBean);
			et.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return isAdded;
	}// End of adminResponse

	@Override
	public List<DiscussionBoardBean> seeUserQuestion() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		String jpql = "from DiscussionBoardBean where messageType=:messageType";

		et.begin();
		Query que = em.createQuery(jpql);

		que.setParameter("messageType", "Question");
		List<DiscussionBoardBean> messageList = null;
		messageList = que.getResultList();

		et.commit();
		return messageList;
	}// End of seeUserQuestion
}// End of class
