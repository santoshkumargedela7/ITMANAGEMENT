package com.ITApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "IT_SECTIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ITSection extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id

	@Column(name = "SECTION_ID")
	private Long sectionId;

	@Column(name = "SECTION_LABEL",columnDefinition = "varchar(200)")
	private String sectionLabel;
	
	@Column(name="IS_DELETED",columnDefinition = "varchar(1) default 'N'")
	private String isDeleted;
	
	@Column(name="CREATED_BY",columnDefinition = "varchar(20)")
	private String createdBy;
	
	
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("IT_SECTIONS")
	private List<ITDeclarations> itDeclarations= new ArrayList<>();
	
	
}