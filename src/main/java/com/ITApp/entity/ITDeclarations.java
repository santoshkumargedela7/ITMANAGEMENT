package com.ITApp.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="IT_DECLARATIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ITDeclarations extends AuditModel{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "LABEL", columnDefinition = "varchar(2000)")
	private String label;
	
	@Column(name="IS_DELETED",columnDefinition = "varchar(1) default 'N'")
	private String isDeleted;
	
	@Column(name="CREATED_BY",columnDefinition = "varchar(20)")
	private String createdBy;
	
	
	
	
		
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="Declaration_id",referencedColumnName = "SECTION_ID")
	@JsonIgnoreProperties("itDeclarations")
	 private ITSection section;
	
	
	
	
	
}
