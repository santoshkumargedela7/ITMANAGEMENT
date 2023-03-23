package com.ITApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITApp.entity.ITDeclarations;
import com.ITApp.repository.ITDeclarationsRepo;
import com.ITApp.service.ITDeclarationsService;

@Service
public class ITDeclarationsServiceImpl implements ITDeclarationsService{
		
	
	
	@Autowired
	private ITDeclarationsRepo repo;
	
	@Override
	public List<ITDeclarations> getAll() {
		List<ITDeclarations> list = repo.findAll();
		return list;
	}

	@Override
	public ITDeclarations declarationById(Long id) {
		ITDeclarations declarations = repo.findById(id).get();
		return declarations;
	}

	

	
	

}