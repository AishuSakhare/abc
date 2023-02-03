package com.capgemini.medicalboot.dao;

import java.util.List;

import com.capgemini.medicalboot.bean.AdminUserBean;

public interface AdminUserDao {

	public AdminUserBean adminuserLogin(String email, String password);

	public AdminUserBean adminuserRegister(AdminUserBean adminUserBean);

	public AdminUserBean adminuserProfile(AdminUserBean adminUserBean);

	public AdminUserBean adminuserUpdateProfile(AdminUserBean adminUserBean);

	public List<AdminUserBean> userList();
	
	public boolean userDelete(int id);
	
	public boolean checkUserEmail(String email);
}// End of interface
