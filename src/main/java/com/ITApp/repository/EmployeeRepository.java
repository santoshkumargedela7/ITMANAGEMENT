package com.ITApp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ITApp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByName(String name);

	Employee findByEmailIdAndPassword(String emailId, String password);
	 
	
	Employee findByEmailId(String emailId);

	Employee findByResetPasswordToken(String resetPasswordToken);
	


}
