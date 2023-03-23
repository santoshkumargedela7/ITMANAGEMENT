package com.ITApp.service;

import java.util.List;

import com.ITApp.entity.ITDeclarations;

public interface ITDeclarationsService {

	public List<ITDeclarations> getAll();

	public ITDeclarations declarationById(Long id);

}
