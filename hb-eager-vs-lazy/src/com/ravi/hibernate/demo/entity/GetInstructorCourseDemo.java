package com.ravi.hibernate.demo.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourseDemo {

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
			
			// begin transaction
			session.beginTransaction();
			
			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);
			System.out.println("the instructor is " + theInstructor);
			System.out.println("The courses are " + theInstructor.getCourses());
			
			session.getTransaction().commit();			
			
		}
		finally {
			session.close();
		}
		

	}

}
