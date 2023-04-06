package com.ravi.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		try {
			// create session factory
			SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
			
			// create session 
			Session session = factory.getCurrentSession();
			
			// begin transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theInstructorDetailId = 2;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theInstructorDetailId);
			// print the instructor detail
			System.out.println("Printing theInstructorDetail by id: " + theInstructorDetail);
			
			// print the associated instructor
			Instructor theInstructor = theInstructorDetail.getInstructor();
			System.out.println("The associated theInstructor is " + theInstructor);
			
			
			System.out.println("deleteing theInsdtructorDetail: "+ theInstructorDetail);
			session.delete(theInstructorDetail);
			
			// commit session
			session.getTransaction().commit();
			
			session.close();
			factory.close();
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		

	}

}
