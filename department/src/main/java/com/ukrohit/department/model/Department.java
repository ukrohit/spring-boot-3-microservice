package com.ukrohit.department.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {

	private long departmentId;
	
	private String departmentName;
	
	private List<Employee> employees;
}
