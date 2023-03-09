package com.ITApp.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITApp.entity.ITDeclarations;
import com.ITApp.entity.ITSection;
import com.ITApp.repository.ITDeclarationsRepo;
import com.ITApp.repository.ITSectionRepo;
import com.ITApp.service.ITSectionService;

@Service
public class ITSectionServiceImpl implements ITSectionService{
		
	
	
	protected final Logger logger = LoggerFactory.getLogger(ITSectionServiceImpl.class);
	@Autowired
	private ITSectionRepo itSectionRepo;
	
	
	@Autowired
	private ITDeclarationsRepo repo;
	
	
	@Override
	public ITSection createSection(ITSection itRequest) {
		
		ITSection itSection = itSectionRepo.save(itRequest);
		
		return itSection;
	}
	
	
	
	@Override
	public List<ITDeclarations> getAll() {
		List<ITDeclarations> list = repo.findAll();
		return list;
	}

	@Override
	public List<ITSection> getAllSections() {
		List<ITSection> list = itSectionRepo.findAll();
		return list;
	}

	@Override
	public ITSection getById(Long sectionId) {
		ITSection itSection = itSectionRepo.findById(sectionId).get();
		return itSection;
	}

	@Override
	public ITSection updateSection(String sectionId, ITSection itSection) {
		ITSection section = new ITSection();
		
		section.setSectionId(itSection.getSectionId());
		section.setSectionLabel(itSection.getSectionLabel());
		section.setCreatedBy(itSection.getCreatedBy());
		section.setCreatedOn(itSection.getCreatedOn());
		section.setIsDeleted(itSection.getIsDeleted());
		section.setModifiedOn(itSection.getModifiedOn());
		section.setItDeclarations(itSection.getItDeclarations());
		ITSection sec = itSectionRepo.save(section);
		logger.info("updated details ---->"+section);
		return sec;
	}

	
	
	

}
