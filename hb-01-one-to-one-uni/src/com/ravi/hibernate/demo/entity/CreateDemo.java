package com.ravi.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Deleting : " + theInstructor);
			session.delete(theInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			
		}
		finally {
			session.close();
		}
		

	}

}
