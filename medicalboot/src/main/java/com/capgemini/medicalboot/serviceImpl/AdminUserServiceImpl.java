package com.capgemini.medicalboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalboot.bean.AdminUserBean;
import com.capgemini.medicalboot.dao.AdminUserDao;
import com.capgemini.medicalboot.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserDao adminUserDao;

	@Override
	public AdminUserBean adminuserLogin(String email, String password) {
		return adminUserDao.adminuserLogin(email, password);
	}

	@Override
	public AdminUserBean adminuserRegister(AdminUserBean adminUserBean) {
		return adminUserDao.adminuserRegister(adminUserBean);
	}

	@Override
	public AdminUserBean adminuserProfile(AdminUserBean adminUserBean) {
		return adminUserDao.adminuserProfile(adminUserBean);
	}

	@Override
	public AdminUserBean adminuserUpdateProfile(AdminUserBean adminUserBean) {
		return adminUserDao.adminuserUpdateProfile(adminUserBean);
	}

	@Override
	public List<AdminUserBean> userList() {
		return adminUserDao.userList();
	}

	@Override
	public boolean userDelete(int id) {
		return adminUserDao.userDelete(id);
	}

	@Override
	public boolean checkUserEmail(String email) {
		return adminUserDao.checkUserEmail(email);
	}
}// End of class
