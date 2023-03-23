package com.ITApp.serviceImpl;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ITApp.entity.Employee;
import com.ITApp.exception.EmployeeNotFoundException;
import com.ITApp.repository.EmployeeRepository;
import com.ITApp.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

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
			Employee employee = employeeRepository.save(employeeRequest);
			return employee;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(Long emp_id) {
		try {
			Employee employee = employeeRepository.findById(emp_id)
					.orElseThrow(() -> new EmployeeNotFoundException("No such customer found with the id-->" + emp_id));
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
	public Employee updateEmployee(Long emp_id, Employee empRequest) {
		try {
			Employee employee = new Employee();
			employee.setEmp_id(empRequest.getEmp_id());
			employee.setName(empRequest.getName());
			employee.setPan(empRequest.getPan());
			employee.setEmailId(empRequest.getEmailId());
			employee.setMobileNumber(empRequest.getMobileNumber());
			employee.setCreatedOn(empRequest.getCreatedOn());
			employee.setCreatedBy(empRequest.getCreatedBy());
			employee.setModifiedBy(empRequest.getModifiedBy());
			employee.setIsLocked(empRequest.getIsLocked());
			employee.setPassword(empRequest.getPassword());
			employee.setUserStatus(empRequest.getUserStatus());
			
			Employee emp = employeeRepository.save(employee);
			return emp;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Employee findByName(String name) {
		Employee employee = employeeRepository.findByName(name);
		
		return employee;
	}

	@Override
	public Employee findByEmailIdAndPassword(String emailId, String password) {
		Employee employee = employeeRepository.findByEmailIdAndPassword(emailId, password);
		
		return employee;
	}

	@Override
	public Employee findByEmailId(String emailId) {
		try {
			Employee employee = employeeRepository.findByEmailId(emailId);
			return employee;
		} catch (Exception e) {
			
		}
		return null;
		
		
		
	}

	@Override
	public void updateResetPasswordToken(String token, String emailId) {
		Employee employee = employeeRepository.findByEmailId(emailId);
		if(employee!=null) {
			employee.setResetPasswordToken(token);
			employeeRepository.save(employee);
		}
		else {
			throw new EmployeeNotFoundException("couldn't find any employee with the email"+emailId);
		}
		
	}

//	@Override
//	public Employee getByResetPassword(String token) {
//		
//		return employeeRepository.findByResetPasswordToken(token);
//		}

	
	
	public void updatePassword(Employee employee, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String encodedPassword = passwordEncoder.encode(newPassword);
		employee.setPassword(encodedPassword);
		employee.setResetPasswordToken(null);
		employeeRepository.save(employee);
	}

	@Override
	public String forgotPassword(String emailId) {
		Optional<Employee> empOptional = Optional.ofNullable(
				employeeRepository.findByEmailId(emailId));
		
		if(!empOptional.isPresent()) {
			return "Invalid emailId";
		}
		
		Employee employee = empOptional.get();
		employee.setResetPasswordToken(generateToken());
		employee = employeeRepository.save(employee);
		
		return employee.getResetPasswordToken();
	}

	private String generateToken() {
		StringBuilder token = new StringBuilder();
		
		return token.append(UUID.randomUUID().toString()).append(UUID.
				randomUUID().toString()).toString();
	}

	@Override
	public String resetPassword(String resetPasswordToken, String password) {
		
		Optional<Employee> empOptional = Optional.ofNullable(employeeRepository.
				findByResetPasswordToken(resetPasswordToken));

		if (!empOptional.isPresent()) {
			return "Invalid token.";
		}
		
		Employee emp = empOptional.get();

		emp.setPassword(password);
		emp.setResetPasswordToken(resetPasswordToken);

		employeeRepository.save(emp);

		return "Your password successfully updated.";
	}

	
	
	
	
	
	
}
	



