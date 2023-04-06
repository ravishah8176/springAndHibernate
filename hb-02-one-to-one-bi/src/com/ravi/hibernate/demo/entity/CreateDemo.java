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
			
			// begin transaction
			
			session.beginTransaction();
			
			int theId = 4;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("The instructor Detail with ID 4 is \n" + theInstructorDetail);
			
			Instructor theInstructor = theInstructorDetail.getInstructor();
			System.out.println("The associated Instructor is \n" + theInstructor);
			
			// remove the associated object reference
			// break bi-directional link
			theInstructor.setInstructorDetail(null);
			session.delete(theInstructorDetail);
			
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
