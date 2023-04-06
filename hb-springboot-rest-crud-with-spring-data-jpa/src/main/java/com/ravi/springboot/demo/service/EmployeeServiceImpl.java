package com.ravi.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.springboot.demo.dao.EmployeeRepository;
import com.ravi.springboot.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepositiry;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepositiry = theEmployeeRepository;
	}
	

	@Override
	public List<Employee> findAll() {
		return employeeRepositiry.findAll();
	}

	
	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepositiry.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else throw new RuntimeException("Did not find the employee id " + theId);
		
		return theEmployee;
	}


	
	@Override
	public Employee save(Employee theEmployee) {
		return employeeRepositiry.save(theEmployee);
	}

	
	
	@Override
	public void deleteById(int theId) {
		employeeRepositiry.deleteById(theId);
	}

}
