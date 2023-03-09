package com.ITApp.dto;

import com.ITApp.entity.ITSection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ITDeclarationsDto {

	private Long id;

	private String label;

	private String isDeleted;

	private String createdBy;
	 private ITSection section;
}
