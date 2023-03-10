package com.ITApp.service;

import java.util.List;

import com.ITApp.entity.Employee;

public interface EmployeeService {


	public List<Employee> getAllEmployees();

	public Employee createEmployee(Employee employeeRequest);

	public Employee getEmployeeById(Long id);

	public void deleteEmployee(Long employeeid);

	public Employee updateEmployee(Long employeeid, Employee empRequest);

	public Employee findByName(String name);

	public Employee findByEmailIdAndPassword(String emailId, String password);


//	public Employee findByemailId(String emailId, String password);
//
//	public Employee findByName(String name, Employee empRequest);

}
