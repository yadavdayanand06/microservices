package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userID;
	
	private String userName;
	private String userEmail;
	private Long userDepartmentId;
	
	public User() {
		
	}
	
	public User(Long userId, String userName, String userEmail, Long userDepartmentId) {
		this.userID = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userDepartmentId = userDepartmentId;
	}

	public Long getUserId() {
		return userID;
	}

	public void setUserId(Long userId) {
		this.userID = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getUserDepartmentId() {
		return userDepartmentId;
	}

	public void setUserDepartmentId(Long userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userID + ", userName=" + userName + ", userEmail=" + userEmail + ", userDepartmentId="
				+ userDepartmentId + "]";
	}
}
