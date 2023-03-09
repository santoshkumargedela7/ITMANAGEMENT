package com.ITApp.dto;

import java.util.ArrayList;
import java.util.List;

import com.ITApp.entity.ITDeclarations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ITSectionDto {
	
	private Long sectionId;

	private String sectionLabel;
	
	private String isDeleted;
	
	private String createdBy;
	
	private List<ITDeclarations> itDeclarations= new ArrayList<>();
	
}
