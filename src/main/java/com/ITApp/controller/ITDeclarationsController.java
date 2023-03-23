package com.ITApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITApp.entity.ITDeclarations;
import com.ITApp.service.ITDeclarationsService;

@RestController
@RequestMapping("/declaration")
public class ITDeclarationsController {

	@Autowired
	private ITDeclarationsService service;

	@GetMapping("/all")
	public ResponseEntity<List<ITDeclarations>> getAll() {
		List<ITDeclarations> list = service.getAll();
		return new ResponseEntity<List<ITDeclarations>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ITDeclarations> declarationById(@PathVariable("id") Long id) {
		ITDeclarations itDeclarations = service.declarationById(id);
		return new ResponseEntity<ITDeclarations>(itDeclarations, HttpStatus.OK);

	}

}
