package com.ravi.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
//			 begin transaction
			session.beginTransaction();
			Instructor theInstructor = new Instructor("Ravi", "shah", "ravishah8176@gmail.com");
			
			InstructorDetail theInstructorDetail = new InstructorDetail("https://www.youtube.com/ravishah", "coding");
			
			theInstructor.setInstructorDetail(theInstructorDetail);
			
			Course theCourse1 = new Course("Java Mastery-1");
			Course theCourse2 = new Course("Python Mastery-1");
			Course theCourse3 = new Course("Hibernate Mastery-1");
			List<Course> list = new ArrayList<>();
			list.add(theCourse1);
			list.add(theCourse2);
			list.add(theCourse3);
			
			theInstructor.setCourse(list);
			
			session.save(theInstructor);			
			session.save(theCourse1);
			session.save(theCourse2);
			session.save(theCourse3);
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
