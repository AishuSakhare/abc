package com.capgemini.medicalboot.service;

import java.util.List;

import com.capgemini.medicalboot.bean.AdminUserBean;
import com.capgemini.medicalboot.bean.CartBean;

public interface AdminUserService {

	public AdminUserBean adminuserLogin(String email, String password);

	public AdminUserBean adminuserRegister(AdminUserBean adminUserBean);

	public AdminUserBean adminuserProfile(AdminUserBean adminUserBean);

	public AdminUserBean adminuserUpdateProfile(AdminUserBean adminUserBean);

	public List<AdminUserBean> userList();
	
	public boolean userDelete(int id);
	
	public boolean checkUserEmail(String email);
}// End of class
