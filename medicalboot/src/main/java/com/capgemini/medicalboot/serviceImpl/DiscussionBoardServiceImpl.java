package com.capgemini.medicalboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalboot.bean.DiscussionBoardBean;
import com.capgemini.medicalboot.dao.DiscussionBoardDao;
import com.capgemini.medicalboot.service.DiscussionBoardService;

@Service
public class DiscussionBoardServiceImpl implements DiscussionBoardService {

	@Autowired
	private DiscussionBoardDao discussionBoardDao;

	@Override
	public boolean userQuestion(DiscussionBoardBean discussionBoardBean) {
		return discussionBoardDao.userQuestion(discussionBoardBean);
	}

	@Override
	public List<DiscussionBoardBean> seeAdminResponse(DiscussionBoardBean discussionBoardBean) {
		return discussionBoardDao.seeAdminResponse(discussionBoardBean);
	}

	@Override
	public boolean adminResponse(DiscussionBoardBean discussionBoardBean) {
		return discussionBoardDao.adminResponse(discussionBoardBean);
	}

	@Override
	public List<DiscussionBoardBean> seeUserQuestion() {
		return discussionBoardDao.seeUserQuestion();
	}
}// End of class
