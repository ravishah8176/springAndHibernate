package com.ravi.hibernate.Hibernate.and.Jpa.dao;

import com.ravi.hibernate.Hibernate.and.Jpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer theId);
    List<Student> findAll();
    void update(Student theStudent);
    void delete(Integer theId);
}
