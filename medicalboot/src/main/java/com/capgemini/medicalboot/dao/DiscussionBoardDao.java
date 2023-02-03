package com.capgemini.medicalboot.dao;

import java.util.List;

import com.capgemini.medicalboot.bean.DiscussionBoardBean;

public interface DiscussionBoardDao {

	public boolean userQuestion(DiscussionBoardBean discussionBoardBean);

	public List<DiscussionBoardBean> seeAdminResponse(DiscussionBoardBean discussionBoardBean);

	public boolean adminResponse(DiscussionBoardBean discussionBoardBean);

	public List<DiscussionBoardBean> seeUserQuestion();
}// End of interface
