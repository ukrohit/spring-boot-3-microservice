package com.ukrohit.department.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.ukrohit.department.model.Employee;

@HttpExchange
public interface EmployeeClient {
	
	@GetExchange("/employee/department/{departmentId}")
	List<Employee> getAllDepartmentEmployee(@PathVariable long departmentId) ;
	

}
