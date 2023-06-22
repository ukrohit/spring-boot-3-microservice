package com.ukrohit.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ukrohit.employee.model.Employee;
import com.ukrohit.employee.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/employee")
@AllArgsConstructor
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	List<Employee> getAllEmployee() {
		log.info("Get all Employee");
		return employeeRepository.findAll();
	}

	@PostMapping
	Employee addEmployee(@RequestBody Employee employee) {
		log.info("add Employee"+employee);
		return employeeRepository.addEmployee(employee);
	}

	@GetMapping("/{employeeId}")
	Employee getAllEmployee(@PathVariable long employeeId) {
		log.info("get Employee : "+employeeId);
		return employeeRepository.findById(employeeId);
	}

	@GetMapping("/department/{departmentId}")
	List<Employee> getAllDepartmentEmployee(@PathVariable long departmentId) {
		log.info("get Employee by department : "+departmentId);
		return employeeRepository.findByDepartment(departmentId);
	}

}
