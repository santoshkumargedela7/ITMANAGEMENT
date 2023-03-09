package com.ITApp.service;

import java.util.List;

import com.ITApp.entity.ITDeclarations;
import com.ITApp.entity.ITSection;

public interface ITSectionService {

	

	public List<ITDeclarations> getAll();

	public List<ITSection> getAllSections();

	public ITSection getById(Long sectionId);

	public ITSection updateSection(String sectionId, ITSection itSection);

	public ITSection createSection(ITSection itRequest);

}
