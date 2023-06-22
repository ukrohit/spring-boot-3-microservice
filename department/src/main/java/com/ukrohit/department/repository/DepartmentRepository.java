package com.ukrohit.department.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ukrohit.department.model.Department;

@Repository
public class DepartmentRepository {

	List<Department> departments = new ArrayList<>();

	public Department addDepartment(Department department) {
		departments.add(department);

		return department;
	}

	public Department findByDepartmentId(long departmentId) {
		return departments.stream().filter(department -> department.getDepartmentId() == departmentId).findFirst()
				.orElseThrow();

	}

	public List<Department> findAll() {
		return departments;

	}

}
