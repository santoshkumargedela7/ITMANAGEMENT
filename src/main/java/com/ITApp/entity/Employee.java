package com.ITApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAX_PAYERS")

public class Employee extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMP_ID", columnDefinition = "varchar(20)", nullable = false)

	private Long emp_id;

	@Column(name = "Name", columnDefinition = "varchar(50)", nullable = false)
	private String name;

	@Column(name = "MOBILE_NUMBER", columnDefinition = "varchar(15) default 'XX-XXX-XXX-XXXX'")
	private Long mobileNumber;
	@Column(name = "EMAIL_ID", columnDefinition = "varchar(50)", nullable = false)
	private String email_Id;

	@Column(name = "PASSWORD", columnDefinition = "varchar(12) default 'Y'", nullable = false)
	private String password;
	@Column(name = "PAN", columnDefinition = "varchar(15)", nullable = false)
	private String pan;

	@Column(name = "IS_LOCKED", columnDefinition = "varchar(1) default 'N'", nullable = false)
	private String isLocked;

	@Column(name = "USER_STATUS", columnDefinition = "varchar(1) default 'A'", nullable = false)
	private String userStatus;

	@Column(name = "CREATED_BY", columnDefinition = "varchar(20)")
	private String createdBy;
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	public Long getEmp_id() {
		return emp_id;
	}
	public String getName() {
		return name;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public String getEmail_Id() {
		return email_Id;
	}
	public String getPassword() {
		return password;
	}
	public String getPan() {
		return pan;
	}
	public String getIsLocked() {
		return isLocked;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", email_Id="
				+ email_Id + ", password=" + password + ", pan=" + pan + ", isLocked=" + isLocked + ", userStatus="
				+ userStatus + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}

}
