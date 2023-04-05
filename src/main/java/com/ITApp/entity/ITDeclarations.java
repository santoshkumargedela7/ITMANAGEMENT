package com.ITApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "IT_DECLARATIONS")

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ITDeclarations extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "LABEL", columnDefinition = "varchar(2000)")
	private String label;

	@Column(name = "IS_DELETED", columnDefinition = "varchar(1) default 'N'")
	private String isDeleted;

	@Column(name = "Actual_value")
	private Long actualValue;
	@Column(name = "Approved_value")
	private Long approvedValue;
	@Column(name = "Declared_value")
	private Long declaredValue;
	
		
	@Column(name = "CREATED_BY", columnDefinition = "varchar(20)")
	private String createdBy;

//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "Declaration_id", referencedColumnName = "SECTION_ID")
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnoreProperties("itDeclarations")
//	private ITSection section;
//		
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "it_declare_id")
//	private Employee employee;

}
