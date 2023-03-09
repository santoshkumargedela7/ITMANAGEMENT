package com.ITApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITApp.entity.ITDeclarations;
import com.ITApp.entity.ITSection;

public interface ITSectionRepo extends JpaRepository<ITSection, Long>{

	void save(ITDeclarations itDeclarations);
		
	
	
}
