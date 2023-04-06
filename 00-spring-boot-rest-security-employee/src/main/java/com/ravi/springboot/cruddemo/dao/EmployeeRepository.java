package com.ravi.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}
