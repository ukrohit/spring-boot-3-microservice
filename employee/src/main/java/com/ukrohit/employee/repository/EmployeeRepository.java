package com.ukrohit.employee.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ukrohit.employee.model.Employee;

@Repository
public class EmployeeRepository {

	List<Employee> employees = new ArrayList<>();

	public List<Employee> findAll() {
		return employees;
	}

	public List<Employee> findByDepartment(long departmentId) {
		return employees.stream().filter(employee -> employee.departmentId() == departmentId)
				.collect(Collectors.toList());
	}

	public Employee findById(long employeeId) {
		return employees.stream().filter(employee -> employee.empId() == employeeId).findFirst().orElseThrow();
	}

	public Employee addEmployee(Employee employee) {
		employees.add(employee);
		return employee;
	}

}
