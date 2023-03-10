package com.ITApp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITApp.dto.ITSectionDto;
import com.ITApp.entity.ITSection;
import com.ITApp.service.ITSectionService;

@RestController
@RequestMapping("/IT")
public class ITSectionController {

	protected final Logger logger = LoggerFactory.getLogger(ITSectionController.class);
	@Autowired
	private ITSectionService itSectionService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/saveSection")
	public ResponseEntity<ITSectionDto> createSection(@RequestBody ITSectionDto itSectionDto) {
		ITSection itRequest = modelMapper.map(itSectionDto, ITSection.class);
		ITSection section = itSectionService.createSection(itRequest);
		ITSectionDto dto = modelMapper.map(section, ITSectionDto.class);

		return new ResponseEntity<ITSectionDto>(dto, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<ITSectionDto> getAllSections() {

		return itSectionService.getAllSections().stream().map(section -> modelMapper.map(section, ITSectionDto.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/id")
	public ResponseEntity<ITSection> getById(@RequestParam("sectionId") Long sectionId) {
		ITSection itSection = itSectionService.getById(sectionId);
		return new ResponseEntity<ITSection>(itSection, HttpStatus.OK);
	}

	@PutMapping("/update/{sectionId}")
	public ResponseEntity<ITSectionDto> updateSection(@PathVariable("sectionId") String sectionId,
			@RequestBody ITSectionDto itSectionDto) {
		ITSection dto = modelMapper.map(itSectionDto, ITSection.class);
		ITSection itSection = itSectionService.updateSection(sectionId, dto);
		ITSectionDto itDto = modelMapper.map(itSection, ITSectionDto.class);
		return new ResponseEntity<ITSectionDto>(itDto, HttpStatus.ACCEPTED);

	}

}
