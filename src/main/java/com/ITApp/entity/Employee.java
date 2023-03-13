package com.ITApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TAX_PAYERS")
@Data
@EqualsAndHashCode(callSuper = false)

@NoArgsConstructor
@AllArgsConstructor
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
	private String emailId;

	@Column(name = "PASSWORD", columnDefinition = "varchar(12) default 'Y'", nullable = false)
	private String password;
	@Column(name = "PAN", columnDefinition = "varchar(15)", nullable = false)
	private String pan;

	@Column(name = "IS_LOCKED", columnDefinition = "varchar(1) default 'N'", nullable = false)
	private String isLocked;

	@Column(name = "USER_STATUS", columnDefinition = "varchar(1) default 'A'", nullable = false)
	private String userStatus;

	@Column(name = "CREATED_BY", columnDefinition = "varchar(20)")
	@CreatedBy
	private String createdBy;
	@Column(name = "MODIFIED_BY")
	@LastModifiedBy
	private String modifiedBy;

}
