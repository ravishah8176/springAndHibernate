package com.ravi.hibernate.Hibernate.and.Jpa.dao;

import com.ravi.hibernate.Hibernate.and.Jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager theEntityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        theEntityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        theEntityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer theId) {
        return theEntityManager.find(Student.class, theId);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = theEntityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        theEntityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer theId) {
        Student theStudent = theEntityManager.find(Student.class, theId);
        theEntityManager.remove(theStudent);
    }
}
