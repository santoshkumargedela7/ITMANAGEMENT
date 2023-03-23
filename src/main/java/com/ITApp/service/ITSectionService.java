package com.ITApp.service;

import java.util.List;

import com.ITApp.entity.ITSection;

public interface ITSectionService {


	public List<ITSection> getAllSections();

	public ITSection getById(Long sectionId);

	public ITSection createSection(ITSection itRequest);

	public ITSection updateSection(String sectionId, ITSection dto);


	public void deleteById(Long sectionId);

}
