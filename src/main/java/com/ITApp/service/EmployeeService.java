package com.ITApp.service;

import java.util.List;

import com.ITApp.entity.Employee;

public interface EmployeeService {


	public List<Employee> getAllEmployees();

	public Employee createEmployee(Employee employeeRequest);

	public Employee getEmployeeById(Long emp_id);

	public void deleteEmployee(Long employeeid);

	public Employee updateEmployee(Long emp_id, Employee empRequest);

	public Employee findByName(String name);

	public Employee findByEmailIdAndPassword(String emailId, String password);

	public Employee findByEmailId(String emailId);

	public void updateResetPasswordToken(String token, String email);

//	public Employee getByResetPassword(String token);

	public String forgotPassword(String emailId);

	public String resetPassword(String resetPasswordToken, String password);


	



	
	

	
}
