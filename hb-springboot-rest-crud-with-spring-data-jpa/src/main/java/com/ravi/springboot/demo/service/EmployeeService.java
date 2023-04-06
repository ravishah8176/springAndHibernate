package com.ravi.springboot.demo.service;

import java.util.List;

import com.ravi.springboot.demo.entity.Employee;

public interface EmployeeService {
	List<Employee>findAll();
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);

	Employee findById(int theId);
}
