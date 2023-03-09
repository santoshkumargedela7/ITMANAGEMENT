package com.ITApp.dto;



import com.ITApp.entity.AuditModel;




public class EmployeeDto extends AuditModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long employeeid;
	private String name;
	private String designation;
	private Long phonenumber;
	private String email;
	private String pan;
	
	
	public Long getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeid=" + employeeid + ", name=" + name + ", designation=" + designation
				+ ", phonenumber=" + phonenumber + ", email=" + email + ", pan=" + pan + "]";
	}

}
