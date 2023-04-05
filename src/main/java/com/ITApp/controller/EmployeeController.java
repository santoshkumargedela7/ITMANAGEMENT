package com.ITApp.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
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
import com.ITApp.util.Utility;

import net.bytebuddy.utility.RandomString;

@CrossOrigin

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeService employeeService;

//	@Autowired
//	private JavaMailSender mailSender;

//	@PostMapping("/create")
//	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
//		Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);
//		Employee employee = employeeService.createEmployee(employeeRequest);
//
//		EmployeeDto empResponse = modelMapper.map(employee, EmployeeDto.class);
//		logger.info("created Employee--->" + empResponse);
//		return new ResponseEntity<EmployeeDto>(empResponse, HttpStatus.CREATED);
//	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

	    try {
	        Employee emp = employeeService.createEmployee(employee);
	        return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	    } catch (Exception e) {

	        logger.error("error in create employee method: " + e.getMessage());
	        ;
	    }
	    return null;
	}
	@GetMapping("/get")
	public List<EmployeeDto> getAllEmployees() {
		return employeeService.getAllEmployees().stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/getbyid/{emp_id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("emp_id") Long emp_id) {
		Employee employee = employeeService.getEmployeeById(emp_id);
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		logger.info("Employee By id:" + employeeDto);
		return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
	}

	@PutMapping("/update/{emp_id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("emp_id") Long emp_id,
			@RequestBody EmployeeDto employeeDto) {
		Employee empRequest = modelMapper.map(employeeDto, Employee.class);

		Employee employee = employeeService.updateEmployee(emp_id, empRequest);
		EmployeeDto empResponse = modelMapper.map(employee, EmployeeDto.class);
		logger.info("updated employee details--->" + empResponse);
		return new ResponseEntity<EmployeeDto>(empResponse, HttpStatus.ACCEPTED);
	}

	@GetMapping("/name")
	public ResponseEntity<Employee> findByName(@RequestParam("name") String name) {
		Employee employee = employeeService.findByName(name);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/email/{emailId}")
	public ResponseEntity<Employee> findByEmailId(@PathVariable("emailId") String emailId) {
		Employee employee = employeeService.findByEmailId(emailId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/{emailId}/{password}")
	public ResponseEntity<Employee> findByEmailIdAndPassword(@PathVariable("emailId") String emailId,
			@PathVariable("password") String password) {
		Employee employee = employeeService.findByEmailIdAndPassword(emailId, password);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PostMapping("/forgot_password")
	public String processForgotPassword(HttpServletRequest request, Model model)
			throws UnsupportedEncodingException, MessagingException {
		String emailId = request.getParameter("emailId");
		String token = RandomString.make(30);
		try {
			employeeService.updateResetPasswordToken(token, emailId);
			String resetPasswordLink = Utility.getSiteUrl(request) + "/reset_password?token=" + token;

			sendEmail(emailId, resetPasswordLink);
			model.addAttribute("message", "we have sent a reset password link to your mail. Please check. ");

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "forgot_password_form";
	}

	@PostMapping("/saveDeclaration")
	public ResponseEntity<EmployeeDto> saveDeclaration(@RequestBody EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Employee emp = employeeService.saveDeclaration(employee);
		EmployeeDto dto = modelMapper.map(emp, EmployeeDto.class);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {

		JavaMailSenderImpl sender = new JavaMailSenderImpl();

		sender.setHost("smtp.gmail.com");

		MimeMessage message = sender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message);

		// helper.setFrom("santoshgedela345@gmail.com", " ");
		// helper.setFrom("santoshgedela345@gmail.com");
		helper.setTo(recipientEmail);

		String subject = "Here's the link to reset your password";

		String content = "<p>Hello,</p>" + "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>" + "<p><a href=\"" + link
				+ "\">Change my password</a></p>" + "<br>" + "<p>Ignore this email if you do remember your password, "
				+ "or you have not made the request.</p>";

		helper.setSubject(subject);

		helper.setText(content, true);

		sender.send(message);
	}

	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam("emailId") String emailId)
			throws UnsupportedEncodingException, MessagingException {
		String response = employeeService.forgotPassword(emailId);
		if (!response.startsWith("Invalid")) {
			response = "http://localhost:8080/reset-password?resetPasswordToken=" + response;
			sendEmail(emailId, response);

		}
		return response;
	}

	@PutMapping("/reset-password")
	public String resetPassword(@RequestParam String resetPasswordToken, @RequestParam String password) {

		return employeeService.resetPassword(resetPasswordToken, password);
	}

	@DeleteMapping("/delete/{employeeid}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeid") Long employeeid) {
		employeeService.deleteEmployee(employeeid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
