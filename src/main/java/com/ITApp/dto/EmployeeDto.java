package com.ITApp.dto;

import com.ITApp.entity.AuditModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long emp_id;
	private String name;

	private Long mobileNumber;
	private String emailId;

	private String password;
	private String pan;

	private String isLocked;

	private String userStatus;

	private String createdBy;
	private String modifiedBy;

}
