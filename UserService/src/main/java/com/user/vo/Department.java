package com.user.vo;

public class Department {

	private Long departmentID;	
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName
				+ ", departmentAddress=" + departmentAddress + ", departmentCode=" + departmentCode + "]";
	}

	public Long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
}
