package com.ravi.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.springboot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
// we don't need to write any  code
}
