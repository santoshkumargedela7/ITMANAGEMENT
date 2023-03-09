package com.ITApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITApp.entity.Employee;
import com.ITApp.exception.EmployeeNotFoundException;
import com.ITApp.repository.EmployeeRepository;
import com.ITApp.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
		
	@Autowired
	private EmployeeRepository employeeRepository;



	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emp = employeeRepository.findAll();
		return emp;
	}
	
	
	@Override
	public Employee createEmployee(Employee employeeRequest) {
		
		try {
			Employee employee  = employeeRepository.save(employeeRequest);
			return employee;
		} catch (Exception e) {
			// TODO: handle exception
		}
				return null;
	}


	@Override
	public Employee getEmployeeById(Long id) {
		try {
			Employee employee = employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("No such customer found with the id-->"+id));
			return employee;
		} catch (Exception e) {
			
		}
		return null;
	}


	@Override
	public void deleteEmployee(Long employeeid) {
		employeeRepository.deleteById(employeeid);
		
	}


	


	@Override
	public Employee updateEmployee(Long employeeid, Employee empRequest) {
		try {
			Employee employee  = new Employee();
			employee.setEmp_id(empRequest.getEmp_id());
			employee.setName(empRequest.getName());
			employee.setPan(empRequest.getPan());
			employee.setEmail_Id(empRequest.getEmail_Id());
			employee.setMobileNumber(empRequest.getMobileNumber());
			employee.setCreatedOn(empRequest.getCreatedOn());
			Employee emp = employeeRepository.save(employee);
			return emp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	@Override
	public Employee findByName(String name, Employee empRequest) {
		try {
			Employee employee = employeeRepository.findByName(name);
			System.out.println("employee by name:"+employee);
			return employee;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
