package com.capgemini.medicalboot.response;

import java.util.List;

import com.capgemini.medicalboot.bean.AdminUserBean;
import com.capgemini.medicalboot.bean.CartBean;
import com.capgemini.medicalboot.bean.DiscussionBoardBean;
import com.capgemini.medicalboot.bean.OrderProductBean;
import com.capgemini.medicalboot.bean.ProductBean;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalResponse {

	private int statusCode;
	private String message;
	private String description;

	private double totalBill;
	private String role;

	private AdminUserBean adminUserBean;
	private List<AdminUserBean> adminUserBeanList;

	private CartBean cartBean;
	private List<CartBean> cartBeanList;

	private DiscussionBoardBean discussionBoardBean;
	private List<DiscussionBoardBean> discussionBoardBeanList;

	private OrderProductBean orderProductBean;
	private List<OrderProductBean> orderProductBeanList;

	private ProductBean productBean;
	private List<ProductBean> productBeanList;

	// Getter Setter Method

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AdminUserBean getAdminUserBean() {
		return adminUserBean;
	}

	public void setAdminUserBean(AdminUserBean adminUserBean) {
		this.adminUserBean = adminUserBean;
	}

	public List<AdminUserBean> getAdminUserBeanList() {
		return adminUserBeanList;
	}

	public void setAdminUserBeanList(List<AdminUserBean> adminUserBeanList) {
		this.adminUserBeanList = adminUserBeanList;
	}

	public CartBean getCartBean() {
		return cartBean;
	}

	public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}

	public List<CartBean> getCartBeanList() {
		return cartBeanList;
	}

	public void setCartBeanList(List<CartBean> cartBeanList) {
		this.cartBeanList = cartBeanList;
	}

	public DiscussionBoardBean getDiscussionBoardBean() {
		return discussionBoardBean;
	}

	public void setDiscussionBoardBean(DiscussionBoardBean discussionBoardBean) {
		this.discussionBoardBean = discussionBoardBean;
	}

	public List<DiscussionBoardBean> getDiscussionBoardBeanList() {
		return discussionBoardBeanList;
	}

	public void setDiscussionBoardBeanList(List<DiscussionBoardBean> discussionBoardBeanList) {
		this.discussionBoardBeanList = discussionBoardBeanList;
	}

	public OrderProductBean getOrderProductBean() {
		return orderProductBean;
	}

	public void setOrderProductBean(OrderProductBean orderProductBean) {
		this.orderProductBean = orderProductBean;
	}

	public List<OrderProductBean> getOrderProductBeanList() {
		return orderProductBeanList;
	}

	public void setOrderProductBeanList(List<OrderProductBean> orderProductBeanList) {
		this.orderProductBeanList = orderProductBeanList;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public List<ProductBean> getProductBeanList() {
		return productBeanList;
	}

	public void setProductBeanList(List<ProductBean> productBeanList) {
		this.productBeanList = productBeanList;
	}

}// End of class
