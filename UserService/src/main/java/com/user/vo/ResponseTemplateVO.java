package com.user.vo;

import com.user.entity.User;

public class ResponseTemplateVO {


	private User user;
	private Department department;
	
	public ResponseTemplateVO() {}
	
	public ResponseTemplateVO(User use, Department department) {
		
		this.user = use;
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ResponseTemplateVO [user=" + user + ", department=" + department + "]";
	}
}
