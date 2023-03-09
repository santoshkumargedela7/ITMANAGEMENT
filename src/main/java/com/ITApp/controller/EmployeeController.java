package com.ITApp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITApp.dto.EmployeeDto;
import com.ITApp.entity.Employee;
import com.ITApp.service.EmployeeService;

@CrossOrigin

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);
		Employee employee = employeeService.createEmployee(employeeRequest);

		EmployeeDto empResponse = modelMapper.map(employee, EmployeeDto.class);
		logger.info("created Employee--->" + empResponse);
		return new ResponseEntity<EmployeeDto>(empResponse, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<EmployeeDto> getAllEmployees() {
		return employeeService.getAllEmployees().stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/getbyid/{employeeid}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employeeid") Long id) {
		Employee employee = employeeService.getEmployeeById(id);
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		logger.info("Employee By id:" + employeeDto);
		return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
	}

	@PutMapping("/update/{employeeid}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("employeeid") Long employeeid,
			@RequestBody EmployeeDto employeeDto) {
		Employee empRequest = modelMapper.map(employeeDto, Employee.class);

		Employee employee = employeeService.updateEmployee(employeeid, empRequest);
		EmployeeDto empResponse = modelMapper.map(employee, EmployeeDto.class);
	logger.info("updated employee details--->" + empResponse);
		return new ResponseEntity<EmployeeDto>(empResponse, HttpStatus.ACCEPTED);
	}
		
	@GetMapping("/name")
	public ResponseEntity<EmployeeDto> findByName(@RequestParam("name")String name){
		Employee empRequest = modelMapper.map(name, Employee.class);
		Employee employee = employeeService.findByName(name,empRequest);
		EmployeeDto empResponse = modelMapper.map(employee, EmployeeDto.class);
		return new ResponseEntity<EmployeeDto>(empResponse,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	@DeleteMapping("/delete/{employeeid}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeid") Long employeeid) {
		employeeService.deleteEmployee(employeeid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
