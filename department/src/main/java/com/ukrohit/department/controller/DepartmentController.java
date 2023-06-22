package com.ukrohit.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ukrohit.department.client.EmployeeClient;
import com.ukrohit.department.model.Department;
import com.ukrohit.department.repository.DepartmentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/department")
@AllArgsConstructor
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeClient employeeClient;

	@GetMapping
	List<Department> getAllDepartment() {
		log.info("Get All Departments");
		return departmentRepository.findAll();
	}

	@PostMapping
	Department addDepartment(@RequestBody Department department) {
		log.info("Add Department");
		return departmentRepository.addDepartment(department);
	}

	@GetMapping("/{departmentId}")
	Department getAllEmployee(@PathVariable long departmentId) {

		log.info("Get Department :" + departmentId);
		return departmentRepository.findByDepartmentId(departmentId);
	}

	@GetMapping("/withemployees")
	List<Department> getAllWithEmployeeDepartment() {
		log.info("Get All Departments");

		List<Department> departments = departmentRepository.findAll();
		departmentRepository.findAll().forEach(department -> department
				.setEmployees(employeeClient.getAllDepartmentEmployee(department.getDepartmentId())));
		
		
		return departments;
	}
}
